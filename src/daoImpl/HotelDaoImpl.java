package daoImpl;

import java.util.Map;

import PO.HotelPO;
import dao.HotelDao;
import dataHelper.DataFactory;
import dataHelper.HotelDataHelper;
import dataHelperImpl.DataFactoryImpl;

public class HotelDaoImpl implements HotelDao{
	private Map<Integer, HotelPO> map;
	
	private static HotelDaoImpl hotelDaoImpl;
	
	private DataFactory dataFactory;
	
	private HotelDataHelper hotelDataHelper;
	
	public static HotelDaoImpl getInstance(){
		if(hotelDaoImpl == null){
			hotelDaoImpl = new HotelDaoImpl();
		}
		return hotelDaoImpl;
	}
	public HotelDaoImpl() {
		if (map==null) {
			dataFactory = new DataFactoryImpl();
			hotelDataHelper = dataFactory.getHotelDataHelper();
			map = hotelDataHelper.getHotelData();
		}
	}

	@Override
	public HotelPO[] getHotelList(String hotel_region) {
		
		return null;
	}

	@Override
	public HotelPO getHotelInfo(String hotel_ID) {
		
		return null;
	}

	@Override
	public HotelPO[] getHotelList() {
		
		return null;
	}

	@Override
	public boolean addHotel(HotelPO po) {
		
		return false;
	}

	@Override
	public boolean modifyHotel(HotelPO po) {
		
		return false;
	}

	@Override
	public boolean deleteHotel(String hotel_ID) {
		
		return false;
	}

}
