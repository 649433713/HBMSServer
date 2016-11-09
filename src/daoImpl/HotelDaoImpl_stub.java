package daoImpl;

import java.util.HashMap;
import java.util.Map;

import dao.HotelDao;
import po.HotelPO;

public class HotelDaoImpl_stub implements HotelDao{
	@Override
	public Map<String, HotelPO> getHotelList(String hotel_region) {
		// TODO Auto-generated method stub
		if (hotel_region.equals("0001")) {
			Map<String, HotelPO> hotelPOs = new HashMap<String, HotelPO>();
			System.out.println("getHotelList success!");
			return hotelPOs;
		}
		return null;
	}

	@Override
	public HotelPO getHotelInfo(String hotel_ID) {
		// TODO Auto-generated method stub
		if (hotel_ID.equals("0001")) {
			System.out.println("getHotelInfo success!");
			return new HotelPO();
		}
		
		return null;
	}

	@Override
	public Map<String, HotelPO> getHotelList() {
		// TODO Auto-generated method stub
		System.out.println("getHotelList success!");
		return null;
	}

	@Override
	public boolean addHotel(HotelPO po) {
		// TODO Auto-generated method stub
		System.out.println("addHotel success!");
		return true;
	}

	@Override
	public boolean modifyHotel(HotelPO po) {
		// TODO Auto-generated method stub
		System.out.println("modifyHotel success!");
		return true;
	}

	@Override
	public boolean deleteHotel(String hotel_ID) {
		// TODO Auto-generated method stub
		System.out.println("deleteHotel success!");
		return true;
	}
}
