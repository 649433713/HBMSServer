package testDataHelper;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

import dao.HotelDao;
import dao.RoomDao;
import daoImpl.HotelDaoImpl;
import daoImpl.RoomDaoImpl;
import dataHelperImpl.HotelDataMysqlHelper;
import message.RoomStateMessage;
import po.HotelPO;
import po.RoomInfoPO;

public class test {

	public static void main(String[] args) {
		HotelDataMysqlHelper hotelDataMysqlHelper = new HotelDataMysqlHelper();
		HotelDao hotelDao = new HotelDaoImpl();
		RoomDao roomDao = new RoomDaoImpl();
		
	
		Map<String, RoomInfoPO> roomList = null;
		try {
			roomList = roomDao.getRoomList(119,null);

		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for (RoomInfoPO roomInfoPO : roomList.values()) {
			System.out.println(roomInfoPO);
		}
		
	}
}
