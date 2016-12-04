package testDataHelper;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.Map;

import dao.HotelDao;
import dao.RoomDao;
import daoImpl.HotelDaoImpl;
import daoImpl.RoomDaoImpl;
import dataHelperImpl.HotelDataMysqlHelper;
import po.HotelPO;

public class test {

	public static void main(String[] args) {
		HotelDataMysqlHelper hotelDataMysqlHelper = new HotelDataMysqlHelper();
		HotelDao hotelDao = new HotelDaoImpl();
		RoomDao roomDao = new RoomDaoImpl();
		
		Map<Integer, HotelPO> hotelList = null;
		
		try {
			hotelList = hotelDao.getHotelList(null, "score", new Date());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (HotelPO hotelPO : hotelList.values()) {
		System.out.println(hotelPO);
		}
		
	}
}
