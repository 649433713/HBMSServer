/**
 * 
 */
package dataHelperImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import dataHelper.OrderDataHelper;
import message.OrderStateMessage;
import message.ResultMessage;
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
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ResultMessage modifyOrderState(int orderID, OrderStateMessage orderState) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addOrder(OrderPO orderPO) {
		// TODO Auto-generated method stub
		return null;
	}



}
