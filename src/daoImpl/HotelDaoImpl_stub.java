package daoImpl;

import PO.HotelPO;
import dao.HotelDao;

public class HotelDaoImpl_stub implements HotelDao{
	@Override
	public HotelPO[] getHotelList(String hotel_region) {
		// TODO Auto-generated method stub
		if (hotel_region.equals("0001")) {
			HotelPO hotelPO[] = new HotelPO[2];
			System.out.println("getHotelList success!");
			return hotelPO;
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
	public HotelPO[] getHotelList() {
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
