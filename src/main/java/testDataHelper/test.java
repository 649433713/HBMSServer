package testDataHelper;

import java.util.Map;

import dataHelperImpl.HotelDataMysqlHelper;
import model.HotelFilter;
import po.HotelPO;

public class test {

	public static void main(String[] args) {
		HotelDataMysqlHelper hotelDataMysqlHelper = new HotelDataMysqlHelper();
		Map<Integer, HotelPO> map = hotelDataMysqlHelper.getHotelList(new HotelFilter()) ;
		
		hotelDataMysqlHelper.delHotel(138);
		System.out.println("当前存在的酒店数:"+map.size());
		System.out.println("NO.120");
		System.out.println(map.get(120));
	}
}
