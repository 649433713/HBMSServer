package dataHelper;

import java.util.Map;

import po.OrderPO;

public interface OrderDataHelper {
	public Map<Integer,OrderPO> getRoomInfoData();

	public void updateRoomInfoData(Map<Integer,OrderPO> map);
}
