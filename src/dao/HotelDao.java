package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;

import PO.HotelPO;

public interface HotelDao extends Remote{
	
	public HotelPO[] getHotelList(String hotel_region)throws RemoteException;	
	
	public HotelPO getHotelInfo(String hotel_ID)throws RemoteException;
	
	public HotelPO[] getHotelList()throws RemoteException;
	
	public boolean addHotel(HotelPO po)throws RemoteException;
	
	public boolean modifyHotel(HotelPO po)throws RemoteException;
	
	public boolean deleteHotel(String hotel_ID)throws RemoteException;
	
}
