package dataHelper;

import java.util.Map;

import po.RoomInfoPO;

public interface RoomDataHelper {
	public Map<Integer,RoomInfoPO> getRoomInfoData();

	public void updateRoomInfoData(Map<Integer,RoomInfoPO> map);
}
