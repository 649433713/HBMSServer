package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import PO.HotelPO;

public interface HotelDao extends Remote{
	
	public Map<String, HotelPO> getHotelList(String hotel_region)throws RemoteException;	
	
	public HotelPO getHotelInfo(String hotel_ID)throws RemoteException;
	
	public Map<String, HotelPO> getHotelList()throws RemoteException;
	
	public boolean addHotel(HotelPO po)throws RemoteException;
	
	public boolean modifyHotel(HotelPO po)throws RemoteException;
	
	public boolean deleteHotel(String hotel_ID)throws RemoteException;
	
}
