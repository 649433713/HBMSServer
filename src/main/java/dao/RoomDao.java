package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import message.ResultMessage;
import message.RoomStateMessage;
import po.RoomInfoPO;

public interface RoomDao extends Remote {
	public Map<String, RoomInfoPO> getRoomList(int hotel_ID)throws RemoteException;
	
	public RoomInfoPO getRoomInfo(String roomType)throws RemoteException;
	
	public ResultMessage addRoom(RoomInfoPO po)throws RemoteException;
	
	public ResultMessage modifyRoom(RoomInfoPO po)throws RemoteException;
	
	public ResultMessage deleteRoom(int room_ID)throws RemoteException;
	
	public ResultMessage modifyRoomState(int room_ID,RoomStateMessage room_state)throws RemoteException;
	
}
