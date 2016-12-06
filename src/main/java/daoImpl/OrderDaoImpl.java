package daoImpl;

import java.rmi.RemoteException;
import java.util.Map;

import dao.OrderDao;
import dataHelper.DataFactory;
import dataHelper.OrderDataHelper;
import dataHelperImpl.DataFactoryImpl;
import message.OrderStateMessage;
import message.ResultMessage;
import model.UserType;
import po.OrderPO;

public class OrderDaoImpl implements OrderDao
{
	
	private Map<Integer, OrderPO> map;
	
	private static OrderDaoImpl orderDaoImpl;
	
	private DataFactory dataFactory;
	
	private OrderDataHelper orderDataHelper;
	
	public static OrderDaoImpl getInstance(){
		if(orderDaoImpl == null){
			orderDaoImpl = new OrderDaoImpl();
		}
		return orderDaoImpl;
	}
	public OrderDaoImpl() {
		if (map==null) {
			dataFactory = new DataFactoryImpl();
			orderDataHelper = dataFactory.getOrderDataHelper();
			
		}
	}
	
	

	@Override
	public Map<Integer, OrderPO> getOrderList(int ID, UserType userType) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDataHelper.getOrderList(ID, userType, null);
	}
	
	
	@Override
	public Map<Integer, OrderPO> getUnexecutedOrderList(int ID, UserType userType) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDataHelper.getOrderList(ID, userType, OrderStateMessage.Unexecuted);
	}
	@Override
	public Map<Integer, OrderPO> getExecutedOrderList(int ID, UserType userType) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDataHelper.getOrderList(ID, userType, OrderStateMessage.Executed);
	}
	@Override
	public Map<Integer, OrderPO> getCancelledOrderList(int ID, UserType userType) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDataHelper.getOrderList(ID, userType, OrderStateMessage.Cancelled);
	}
	@Override
	public Map<Integer, OrderPO> getAbnormalOrderList(int ID, UserType userType) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDataHelper.getOrderList(ID, userType, OrderStateMessage.Abnormal);
	}
	@Override
	public OrderPO getOrderInfo(int orderID) throws RemoteException {
		// TODO Auto-generated method stub
		OrderPO copy = map.get(orderID);
		
		return copy;
	}
	@Override
	public ResultMessage changeOrderState(int orderID, OrderStateMessage orderState) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDataHelper.modifyOrderState(orderID, orderState);
	}
	@Override
	public ResultMessage addOrder(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return orderDataHelper.addOrder(po);
	}


}
