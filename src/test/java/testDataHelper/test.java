package testDataHelper;

import java.rmi.RemoteException;
import java.util.Map;

import dao.HotelDao;
import daoImpl.HotelDaoImpl;
import dataHelperImpl.HotelDataMysqlHelper;
import model.HotelFilter;
import po.HotelPO;
import po.RegionPO;

public class test {

	public static void main(String[] args) {
		HotelDataMysqlHelper hotelDataMysqlHelper = new HotelDataMysqlHelper();
		HotelDao hotelDao = new HotelDaoImpl();
		
		
		
		
		try {
			Map<Integer, RegionPO> map = hotelDao.getRegions() ;
			for (RegionPO regionPO : map.values()) {
				System.out.println(regionPO);
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
