package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

import message.ResultMessage;
import message.RoomStateMessage;
import po.RoomInfoPO;

public interface RoomDao extends Remote {
	public Map<String, RoomInfoPO> getRoomList(int hotel_ID)throws RemoteException;
	
	public RoomInfoPO getRoomInfo(String roomType)throws RemoteException;
	
	public int getRoomNum(String roomType)throws RemoteException;
	
	public ResultMessage addRoom(RoomInfoPO po)throws RemoteException;
	
	public ResultMessage modifyRoom(RoomInfoPO po)throws RemoteException;
	
	public ResultMessage deleteRoom(int roomInfoID)throws RemoteException;
	
	public ResultMessage deleteRoom(String roomID)throws RemoteException;
	
	public ResultMessage modifyRoomState(String roomID,RoomStateMessage room_state,Date date1,Date date2)throws RemoteException;
	
	
}
