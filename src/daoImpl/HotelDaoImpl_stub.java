package daoImpl;

import java.util.HashMap;
import java.util.Map;

import PO.HotelPO;
import dao.HotelDao;
import message.ResultMessage;

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
	public ResultMessage addHotel(HotelPO po) {
		// TODO Auto-generated method stub
		System.out.println("addHotel success!");
		return ResultMessage.success;
	}

	@Override
	public ResultMessage modifyHotel(HotelPO po) {
		// TODO Auto-generated method stub
		System.out.println("modifyHotel success!");
		return ResultMessage.success;
	}

	@Override
	public ResultMessage deleteHotel(String hotel_ID) {
		// TODO Auto-generated method stub
		System.out.println("deleteHotel success!");
		return ResultMessage.success;
	}
}
