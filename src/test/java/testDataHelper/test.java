package testDataHelper;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import dao.HotelDao;
import dao.OrderDao;
import dao.RoomDao;
import daoImpl.HotelDaoImpl;
import daoImpl.OrderDaoImpl;
import daoImpl.RoomDaoImpl;
import dataHelperImpl.HotelDataMysqlHelper;
import message.OrderStateMessage;
import message.RoomStateMessage;
import po.AppealPO;
import po.HotelPO;
import po.OrderPO;
import po.RoomInfoPO;

public class test {

	public static void main(String[] args) throws ParseException, InterruptedException {
		HotelDataMysqlHelper hotelDataMysqlHelper = new HotelDataMysqlHelper();
		HotelDao hotelDao = new HotelDaoImpl();
		RoomDao roomDao = new RoomDaoImpl();
		OrderDao orderDao = new OrderDaoImpl();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式
		Date date = dateFormat.parse("2015-07-31"); // 指定日期
	
		Map<String, RoomInfoPO> roomList = null;
		try {
			OrderPO orderPO;
			orderDao.getOrderList(0, null,null);
			orderPO = orderDao.getOrderInfo(10);
		
			AppealPO appealPO = new AppealPO(0, orderPO.getOrderID(), orderPO.getUserID(), 0, null, "不服", null);
			orderDao.addAppealOrder(appealPO);
			System.out.println(orderDao.getAppealOrder(orderPO.getOrderID()));
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
