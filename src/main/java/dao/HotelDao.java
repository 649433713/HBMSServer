package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import message.ResultMessage;
import model.HotelFilter;
import po.HotelPO;

public interface HotelDao extends Remote{
	
	public Map<Integer, HotelPO> getHotelList(HotelFilter filter)throws RemoteException;	
	
	public HotelPO getHotelInfo(String hotel_ID)throws RemoteException;
	
	public ResultMessage addHotel(HotelPO po)throws RemoteException;
	
	public ResultMessage modifyHotel(HotelPO po)throws RemoteException;
	
	public ResultMessage deleteHotel(int hotel_ID)throws RemoteException;
	
}
