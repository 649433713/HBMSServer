package daoImpl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import dao.RoomDao;
import dataHelper.DataFactory;
import dataHelper.RoomDataHelper;
import dataHelperImpl.DataFactoryImpl;
import po.RoomInfoPO;
import message.RoomStateMessage;
import message.ResultMessage;

public class RoomDaoImpl implements RoomDao {

	private Map<String, RoomInfoPO> map;

	private static RoomDaoImpl roomDaoImpl;

	private DataFactory dataFactory;

	private RoomDataHelper roomDataHelper;

	public static RoomDaoImpl getInstance() {
		if (roomDaoImpl == null) {
			roomDaoImpl = new RoomDaoImpl();
		}
		return roomDaoImpl;
	}

	public RoomDaoImpl() {
		if (map == null) {
			dataFactory = new DataFactoryImpl();
			roomDataHelper = dataFactory.getRoomDataHelper();
			map = null;
		}
	}

	@Override
	public Map<String, RoomInfoPO> getRoomList(int hotel_ID) throws RemoteException {
		map = roomDataHelper.getRoomList(hotel_ID);
		return map;
	}

	@Override
	public RoomInfoPO getRoomInfo(String roomType) throws RemoteException {
		RoomInfoPO copy = null;
		for (RoomInfoPO roomInfoPO : map.values()) {
			if (roomType.equals(roomInfoPO.getRoomType())) {
				copy = roomInfoPO;
				break;
			}
		}
		return copy;
	}

	@Override
	public int getRoomNum(String roomType) throws RemoteException {
		int count = 0;
		for (RoomInfoPO roomInfoPO : map.values()) {
			if (roomType.equals(roomInfoPO.getRoomType())) {
				++count;
			}
		}
		return count;
	}

	@Override
	public ResultMessage addRoom(RoomInfoPO po) throws RemoteException {

		return roomDataHelper.addRoom(po);
	}

	@Override
	public ResultMessage modifyRoom(RoomInfoPO po) throws RemoteException {

		return roomDataHelper.modifyRoom(po);
	}

	@Override
	public ResultMessage deleteRoom(int roomInfoID) throws RemoteException {
		Map<String, Object> condition = new LinkedHashMap<>();

		condition.put("name", "roomInfoID");
		condition.put("relation", "=");
		condition.put("value", roomInfoID);

		return roomDataHelper.deleteRoom(condition);
	}

	@Override
	public ResultMessage deleteRoom(String roomID) throws RemoteException {
		Map<String, Object> condition = new LinkedHashMap<>();

		condition.put("name", "roomID");
		condition.put("relation", "=");
		condition.put("value", roomID);

		return roomDataHelper.deleteRoom(condition);
	}

	@Override
	public ResultMessage modifyRoomState(String roomID, RoomStateMessage room_state, Date date1, Date date2)
			throws RemoteException {

		RoomInfoPO copy = null;
		for (RoomInfoPO roomInfoPO : map.values()) {
			if (roomID.equals(roomInfoPO.getRoomID())) {
				copy = roomInfoPO;
				break;
			}
		}
		copy.setRoomState(room_state);
		copy.setDetailedInfo1(date1);
		copy.setDetailedInfo2(date2);
		
		return roomDataHelper.modifyRoom(copy);
	}

}
