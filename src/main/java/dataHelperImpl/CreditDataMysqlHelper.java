package dataHelperImpl;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

import dataHelper.CreditDataHelper;
import dataHelper.UserDataHelper;
import message.ResultMessage;
import model.CreditRecordChangeType;
import model.CreditRecordChangeTypeHelper;
import model.CreditRecordReasonType;
import model.CreditRecordReasonTypeHelper;
import po.CreditRecordPO;
import po.UserPO;

public class CreditDataMysqlHelper implements CreditDataHelper{
	Connection connection;

	public CreditDataMysqlHelper() {
		connection=DBUtil_Alex.getConnection();
	}


	@Override
	public Map<Integer, CreditRecordPO> getCreditRecordList(int userID) {
		CreditRecordChangeTypeHelper changeTypeHelper=new CreditRecordChangeTypeHelper();
		CreditRecordReasonTypeHelper reasonTypeHelper=new CreditRecordReasonTypeHelper();
		String sentence="select * from creditrecord where userID='"+userID+"'";
		Map<Integer,CreditRecordPO> map=new LinkedHashMap<>();
		PreparedStatement preparedStatement;
		try{
			preparedStatement=connection.prepareStatement(sentence);
			ResultSet resultSet = preparedStatement.executeQuery();
			CreditRecordPO creditRecordPO;
			while(resultSet.next()){
				creditRecordPO=new CreditRecordPO(resultSet.getInt("creditRecordID")
						,resultSet.getTime("time"),resultSet.getInt("userID")
						,changeTypeHelper.getCreditRecordChangeType(resultSet.getInt("changeType"))
						,reasonTypeHelper.getCreditRecordReasonType(resultSet.getInt("reasonType"))
						,resultSet.getLong("amount"),resultSet.getInt("orderID"));
				map.put(creditRecordPO.getCreditRecordID(),creditRecordPO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public ResultMessage addCreditRecord(CreditRecordPO po) {

		String sql="INSERT into creditrecord(time,userID,changeType,reasonType,amount,orderID)" +
				"VALUES (?,?,?,?,?,?)";
		PreparedStatement preparedStatement;
		try{
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setDate(1,new Date(po.getTime().getTime()));
			preparedStatement.setInt(2,po.getUserID());
			preparedStatement.setInt(3,po.getChangeType().ordinal());
			preparedStatement.setInt(4,po.getReasonType().ordinal());
			preparedStatement.setLong(5,po.getAmount());
			preparedStatement.setInt(6,po.getOrderID());
			preparedStatement.execute();
		}catch(SQLException e){
			e.printStackTrace();
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}
}
