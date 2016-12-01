package testDataHelper;

import java.rmi.RemoteException;
import java.util.Map;

import dao.HotelDao;
import dao.RoomDao;
import daoImpl.HotelDaoImpl;
import daoImpl.RoomDaoImpl;
import dataHelperImpl.HotelDataMysqlHelper;
import dataHelperImpl.RoomDataMysqlHelper;
import model.HotelFilter;
import po.HotelPO;
import po.RegionPO;
import po.RoomInfoPO;

public class test {

	public static void main(String[] args) {
		HotelDataMysqlHelper hotelDataMysqlHelper = new HotelDataMysqlHelper();
		HotelDao hotelDao = new HotelDaoImpl();
		RoomDao roomDao = new RoomDaoImpl();
		
		
		
		try {
			hotelDao.deleteHotel(138);
			roomDao.addRoom(roomDao.getRoomList(120).get("888"));
			RoomInfoPO roomInfoPO = roomDao.getRoomList(120).get("888");
			roomInfoPO.setHotelID(20);
			roomDao.modifyRoom(roomInfoPO);
			
			roomDao.addRoom(roomDao.getRoomList(120).get("888"));
			roomDao.deleteRoom(2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
