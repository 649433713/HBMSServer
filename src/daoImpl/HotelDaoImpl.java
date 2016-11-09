package daoImpl;

import java.util.Map;

import PO.HotelPO;
import dao.HotelDao;
import dataHelper.DataFactory;
import dataHelper.HotelDataHelper;
import dataHelperImpl.DataFactoryImpl;
import message.ResultMessage;

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
	public Map<String, HotelPO> getHotelList(String hotel_region) {
		
		return null;
	}

	@Override
	public HotelPO getHotelInfo(String hotel_ID) {
		
		return null;
	}

	@Override
	public Map<String, HotelPO> getHotelList() {
		
		return null;
	}

	@Override
	public ResultMessage addHotel(HotelPO po) {
		
		return ResultMessage.failure;
	}

	@Override
	public ResultMessage modifyHotel(HotelPO po) {
		
		return ResultMessage.failure;
	}

	@Override
	public ResultMessage deleteHotel(String hotel_ID) {
		
		return ResultMessage.failure;
	}

}
