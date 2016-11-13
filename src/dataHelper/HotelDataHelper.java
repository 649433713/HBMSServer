package dataHelper;

import java.util.Map;

import PO.HotelPO;

public interface HotelDataHelper {
	
	public Map<Integer,HotelPO> getHotelData();

	public void updateHotelData(Map<Integer,HotelPO> map);
}
