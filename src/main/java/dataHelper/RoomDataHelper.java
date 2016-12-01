package dataHelper;

import java.util.Map;

import message.ResultMessage;
import po.RoomInfoPO;

public interface RoomDataHelper {
	
	public Map<String, RoomInfoPO> getRoomList(int hotel_ID);
		
	public ResultMessage addRoom(RoomInfoPO po);
	
	public ResultMessage modifyRoom(RoomInfoPO po);
	
	public ResultMessage deleteRoom(Map<String, Object> condition);
	
	
}
