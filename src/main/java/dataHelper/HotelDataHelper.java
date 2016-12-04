package dataHelper;

import java.util.Date;
import java.util.List;
import java.util.Map;

import message.ResultMessage;
import model.HotelFilter;
import po.CommentInfoPO;
import po.HotelPO;
import po.RegionPO;

public interface HotelDataHelper {
	
	public Map<Integer,HotelPO> getHotelList(HotelFilter filter, String order, Date date);

	public ResultMessage addHotel(HotelPO hotelPO) ;
	
	public ResultMessage updateHotel(HotelPO hotelPO);
	
	public ResultMessage delHotel(int hotelID) ;

	public List<CommentInfoPO> getComments(int hotelID);

	public ResultMessage addComment(CommentInfoPO commentInfoPO);

	public Map<Integer, RegionPO> getRegions();
	
	//��Ϊ��ѯ����Ƶ���Ϣ֮ǰ  ���в�ѯ�Ƶ��б�
}
