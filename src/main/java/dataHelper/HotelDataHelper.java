package dataHelper;

import java.util.Map;

import message.ResultMessage;
import model.HotelFilter;
import po.HotelPO;

public interface HotelDataHelper {
	
	public Map<Integer,HotelPO> getHotelList(HotelFilter filter);

	public ResultMessage addHotel(HotelPO hotelPO) ;
	
	public ResultMessage updateHotel(HotelPO hotelPO);
	
	public ResultMessage delHotel(int hotelID) ;
	
	//因为查询具体酒店信息之前  必有查询酒店列表。
}
