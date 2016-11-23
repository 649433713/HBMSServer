package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import message.ResultMessage;
import po.HotelPO;

public interface HotelDao extends Remote{
	
	public Map<String, HotelPO> getHotelList(String hotel_region)throws RemoteException;	
	
	public HotelPO getHotelInfo(String hotel_ID)throws RemoteException;
	
	public Map<String, HotelPO> getHotelList()throws RemoteException;
	
	public ResultMessage addHotel(HotelPO po)throws RemoteException;
	
	public ResultMessage modifyHotel(HotelPO po)throws RemoteException;
	
	public ResultMessage deleteHotel(String hotel_ID)throws RemoteException;
	
}
