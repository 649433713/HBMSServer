package daoImpl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

import dao.RoomDao;
import dataHelper.DataFactory;
import dataHelper.RoomDataHelper;
import dataHelperImpl.DataFactoryImpl;
import po.RoomInfoPO;
import message.RoomStateMessage;
import message.ResultMessage;

public class RoomDaoImpl implements RoomDao {

private Map<String , RoomInfoPO> map;
	
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
			map = null;
		}
	}
	@Override
	public Map<String, RoomInfoPO> getRoomList(int hotel_ID) throws RemoteException {
		
		return null;
	}
	@Override
	public RoomInfoPO getRoomInfo(String roomType) throws RemoteException {
		
		return null;
	}
	@Override
	public int getRoomNum(String roomType) throws RemoteException {
		
		return 0;
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
	public ResultMessage deleteRoom(int roomInfoID) throws RemoteException {
		
		return null;
	}
	@Override
	public ResultMessage deleteRoom(String roomID) throws RemoteException {
		
		return null;
	}
	@Override
	public ResultMessage modifyRoomState(String roomID, RoomStateMessage room_state, Date date1, Date date2)
			throws RemoteException {
		
		return null;
	}
	
	
	

}
