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
	
	//��Ϊ��ѯ����Ƶ���Ϣ֮ǰ  ���в�ѯ�Ƶ��б�
}
