package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import message.ResultMessage;
import po.OrderPO;

public interface OrderDao extends Remote{
		//以下是用户    对订单模块数据层的需求操作
		//获得待提交订单列表（即订单已存在，但是还未生成该订单）
		public Map<Integer, OrderPO> getEditingOrderList(String userId) throws RemoteException;
		//获取未执行订单（即订单已生成，但是订单的用户还未入住，订单未执行状态）
		public Map<Integer, OrderPO> getUnexecutedOrderList(String userId) throws RemoteException;
		//获取已执行订单（即订单用户已入住，订单处于在执行状态，直到用户退房或撤销订单）
		public Map<Integer, OrderPO> getExecutedOrderList(String userId) throws RemoteException;
		//获取已撤销订单（即订单用户对该订单执行撤销操作之后，订单处于的状态）
		public Map<Integer, OrderPO> getCancelledOrderList(String userId) throws RemoteException;
		//获取异常订单（即用户未按照规定时间入住，订单处于的状态）
		public Map<Integer, OrderPO> getAbnormalOrderList(String userId) throws RemoteException;
		
		//用户点击“生成订单”，订单状态  “待提交”---->"未执行"
		public ResultMessage changeOrderStateToUnexecuted(Integer orderId) throws RemoteException;
		//用户点击“撤销订单”，订单状态  “未执行”---->"已撤销"
		public ResultMessage changeOrderStateToCancelled(Integer orderId) throws RemoteException;

		//用户点击“生成订单”，添加订单
		public ResultMessage addOrder(OrderPO po) throws RemoteException;
		
		
		//以下是酒店管理人员 + 网站营销人员    对订单模块数据层的需求操作
		//酒店管理人员登记用户入住，订单状态  “待提交”---->"已执行"
		//该方法网站营销人员也要使用，将申诉合格的订单状态 “异常”---->"已执行"
		public ResultMessage changeOrderStateToExecuted(Integer orderId) throws RemoteException;
		//用户未按照规定时间入住，订单状态系统自动！！！！  “未执行”---->"异常"
		public ResultMessage changeOrderStateToAbnormal(Integer orderId) throws RemoteException;
}
