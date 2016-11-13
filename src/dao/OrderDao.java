package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import message.ResultMessage;
import po.OrderPO;

public interface OrderDao extends Remote{
		public Map<String, OrderPO> getOrderList(String id) throws RemoteException;
		public ResultMessage addOrder(OrderPO orderpo) throws RemoteException;
		public ResultMessage deleteOrder(OrderPO orderpo) throws RemoteException;
		public ResultMessage modifyOrder(OrderPO orderpo) throws RemoteException;
		public OrderPO findOrder(String orderID) throws RemoteException;
}
