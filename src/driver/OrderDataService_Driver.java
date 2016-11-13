package driver;

import java.rmi.RemoteException;

import dao.OrderDao;
import po.OrderPO;

public class OrderDataService_Driver {
	public void drive(OrderDao orderserviceImpl) throws RemoteException
	{
		orderserviceImpl.addOrder(new OrderPO("0001"));
		orderserviceImpl.deleteOrder(new OrderPO("0001"));
		orderserviceImpl.findOrder("0001");
		orderserviceImpl.getOrderList("0001");
		orderserviceImpl.modifyOrder(new OrderPO("0001"));
	}
}
