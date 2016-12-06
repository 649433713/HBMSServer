/**
 * 
 */
package dataHelperImpl;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import dao.RoomDao;
import daoImpl.RoomDaoImpl;
import dataHelper.OrderDataHelper;
import message.OrderStateMessage;
import message.ResultMessage;
import message.RoomStateMessage;
import model.UserType;
import po.OrderPO;

/**  
* 
* @ClassName: OrderDataMysqlHelper
* @Description: TODO
* @author wangfan
* @date 2016年12月6日 上午11:48:18
*
*/
/**
 * @author 凡
 *
 */
public class OrderDataMysqlHelper implements OrderDataHelper {

	Connection connection;
	public OrderDataMysqlHelper() {
		connection = DBUtil.getConnection();
	}
	@Override
	public Map<Integer, OrderPO> getOrderList(int ID, UserType userType, OrderStateMessage orderState) {
		StringBuffer sql = new StringBuffer("select * from orderlist ");
		if (userType==UserType.Customer) {
			sql.append("where userID ="+ID);
		}else if (userType==UserType.Staff) {
			sql.append("where hotelID ="+ID);
		}

		if (orderState!=null) {
			sql.append(" and orderState ="+orderState.ordinal());
		}
		
		Map<Integer, OrderPO> map = new LinkedHashMap<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			OrderPO orderPO = null;
			while(resultSet.next()){
				orderPO = new OrderPO(resultSet.getInt("orderID"), resultSet.getInt("userID"),
						resultSet.getInt("hotelID"), resultSet.getInt("roomInfoID"),OrderStateMessage.values()[resultSet.getInt("orderState")], 
						resultSet.getDate("generateTime"), resultSet.getDate("cancelTime"), resultSet.getDate("executeDDl"),
						resultSet.getDate("checkinTime"), resultSet.getDate("checkoutTime"), resultSet.getInt("number"), 
						resultSet.getInt("hasChild"), resultSet.getInt("price"));
				
				map.put(orderPO.getOrderID(), orderPO);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return map;
	}

	@Override
	public ResultMessage modifyOrderState(int orderID, OrderStateMessage orderState) {
		// TODO Auto-generated method stub
		String sql = null;
		switch (orderState) {
		case Executed:
			 sql = "update orderlist set chechinTime = now(),orderState = 1 where orderID = "+orderID;
			break;
		case Abnormal:
			 sql = "update orderlist set orderState = 2 where orderID = "+orderID;
			break;
		case Cancelled:
			 sql = "update orderlist set cancelTime = now(),executeDDL=default,orderState = 3 where orderID = "+orderID;
			break;
		default:
			break;
		}
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	@Override
	public ResultMessage addOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		String sql = "insert into orderList(userID,hotelID,roomInfoID,"
				+ "orderState,executeDDL,number,hasChild,price) "
				+ "values(?,?,?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderPO.getUserID());
			preparedStatement.setInt(2, orderPO.getHotelID());
			preparedStatement.setInt(3, orderPO.getRoomInfoID());
			preparedStatement.setInt(4, orderPO.getOrderState().ordinal());
			preparedStatement.setDate(5, new Date(orderPO.getExecuteDDl().getTime()));
			preparedStatement.setInt(6, orderPO.getNumber());
			preparedStatement.setInt(7, orderPO.getHasChild());
			preparedStatement.setInt(8, orderPO.getPrice());
			
			preparedStatement.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}



}
