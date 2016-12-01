package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import message.ResultMessage;
import model.HotelFilter;
import po.CommentInfoPO;
import po.HotelPO;
import po.RegionPO;

public interface HotelDao extends Remote{
	
	public Map<Integer, HotelPO> getHotelList(HotelFilter filter)throws RemoteException;	
	
	public HotelPO getHotelInfo(int hotelID)throws RemoteException;
	
	public ResultMessage addHotel(HotelPO po)throws RemoteException;
	
	public ResultMessage modifyHotel(HotelPO po)throws RemoteException;
	
	public ResultMessage deleteHotel(int hotel_ID)throws RemoteException;
	
	public List<CommentInfoPO> getComments(int hotelID)throws RemoteException;

	public ResultMessage addComment(CommentInfoPO commentInfoPO)throws RemoteException;

	public Map<Integer, RegionPO> getRegions()throws RemoteException;
}
