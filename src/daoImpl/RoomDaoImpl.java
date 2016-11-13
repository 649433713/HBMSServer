package daoImpl;

import java.rmi.RemoteException;
import java.util.Map;

import dao.RoomDao;
import dataHelper.DataFactory;
import dataHelper.RoomDataHelper;
import dataHelperImpl.DataFactoryImpl;
import po.RoomInfoPO;
import message.RoomStateMessage;
import message.ResultMessage;

public class RoomDaoImpl implements RoomDao {

private Map<Integer, RoomInfoPO> map;
	
	private static RoomDaoImpl roomDaoImpl;
	
	private DataFactory dataFactory;
	
	private RoomDataHelper roomDataHelper;
	
	public static RoomDaoImpl getInstance(){
		if(roomDaoImpl == null){
			roomDaoImpl = new RoomDaoImpl();
		}
		return roomDaoImpl;
	}
	public RoomDaoImpl() {
		if (map==null) {
			dataFactory = new DataFactoryImpl();
			roomDataHelper = dataFactory.getRoomDataHelper();
			map = roomDataHelper.getRoomInfoData();
		}
	}
	
	
	
	@Override
	public ResultMessage deleteRoom(String room_ID) throws RemoteException {

		return null;
	}

	@Override
	public Map<String, RoomInfoPO> getRoomList(String hotel_ID) throws RemoteException {
		
		return null;
	}

	@Override
	public RoomInfoPO getRoomInfo(String roomType) throws RemoteException {
		
		return null;
	}

	@Override
	public ResultMessage addRoom(RoomInfoPO po) throws RemoteException {
		
		return null;
	}

	@Override
	public ResultMessage modifyRoom(RoomInfoPO po) throws RemoteException {
		
		return null;
	}

	@Override
	public ResultMessage modifyRoomState(String room_ID, RoomStateMessage room_state) throws RemoteException {
		
		return null;
	}



}
