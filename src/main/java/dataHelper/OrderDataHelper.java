package dataHelper;

import java.util.Map;

import message.OrderStateMessage;
import message.ResultMessage;
import model.UserType;
import po.OrderPO;

public interface OrderDataHelper {
	public Map<Integer,OrderPO> getOrderList(int ID,UserType userType,OrderStateMessage orderState);

	public ResultMessage modifyOrderState(int orderID,OrderStateMessage orderState);
	
	public ResultMessage addOrder(OrderPO orderPO);
}
