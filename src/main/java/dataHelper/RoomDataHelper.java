package dataHelper;

import java.util.Map;

import message.ResultMessage;
import message.RoomStateMessage;
import po.RoomInfoPO;

public interface RoomDataHelper {
	
	public Map<String, RoomInfoPO> getRoomList(int hotel_ID);
	
	public RoomInfoPO getRoomInfo(String roomType);
	
	public ResultMessage addRoom(RoomInfoPO po);
	
	public ResultMessage modifyRoom(RoomInfoPO po);
	
	public ResultMessage deleteRoom(int room_ID);
	
	public ResultMessage modifyRoomState(int room_ID,RoomStateMessage room_state);
	
}
