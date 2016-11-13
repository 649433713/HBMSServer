package daoImpl;

import java.util.HashMap;
import java.util.Map;

import PO.OrderPO;
import dao.OrderDao;
import message.ResultMessage;

public class OrderDaoImpl implements OrderDao
{

	@Override
	public Map<String, OrderPO> getOrderList(String userID)
	{
		// TODO Auto-generated method stub
		if(userID.equals("0001"))
		{
			Map<String, OrderPO> orderList = new HashMap<String, OrderPO>();
			for(int i = 0; i < orderList.size();i++)
			{
				OrderPO orderPO = new OrderPO("0001");//从文件中或者数据库中读出来的orderpo
				orderList.put("0001", orderPO);
			}
			return orderList;
		}
		return null;
	}
	
	@Override
	public ResultMessage addOrder(OrderPO orderpo) {
		// TODO Auto-generated method stub
		System.out.println("addOrder successfully!");
		return ResultMessage.success;
	}

	@Override
	public ResultMessage deleteOrder(OrderPO orderpo) {
		// TODO Auto-generated method stub
		System.out.println("deleteOrder successfully!");
		return ResultMessage.success;
	}

	@Override
	public ResultMessage modifyOrder(OrderPO orderpo) {
		// TODO Auto-generated method stub
		System.out.println("modifyOrder successfully!");
		return ResultMessage.success;
	}

	@Override
	public OrderPO findOrder(String orderID) {
		// TODO Auto-generated method stub
		Map<String, OrderPO> orderList = new HashMap<String, OrderPO>();
		for(int i = 0; i < orderList.size();i++)
		{
			OrderPO orderPO = new OrderPO("0001");//从文件中或者数据库中读出来的orderpo
			orderList.put("0001", orderPO);
		}
		OrderPO returnOrderPO = orderList.get(orderID);
		return returnOrderPO;
	}

}
