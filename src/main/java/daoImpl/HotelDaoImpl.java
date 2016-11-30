package daoImpl;

import java.util.Map;

import dao.HotelDao;
import dataHelper.DataFactory;
import dataHelper.HotelDataHelper;
import dataHelperImpl.DataFactoryImpl;
import message.ResultMessage;
import model.HotelFilter;
import po.HotelPO;

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
			map = null;
		}
	}

	@Override
	public Map<Integer, HotelPO> getHotelList(HotelFilter filter) {
		map = hotelDataHelper.getHotelList(filter);
		return map;
	}

	@Override
	public HotelPO getHotelInfo(String hotel_ID) {
		
		return map.get(hotel_ID);
	}



	@Override
	public ResultMessage addHotel(HotelPO po) {
		
		return hotelDataHelper.addHotel(po);
	}

	@Override
	public ResultMessage modifyHotel(HotelPO po) {
		
		return hotelDataHelper.updateHotel(po);
	}

	@Override
	public ResultMessage deleteHotel(int hotel_ID) {
		
		return hotelDataHelper.delHotel(hotel_ID);
	}

}
