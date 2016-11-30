package dataHelperImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import dataHelper.HotelDataHelper;
import message.ResultMessage;
import model.HotelFilter;
import po.HotelPO;

public class HotelDataMysqlHelper implements HotelDataHelper{
	Connection connection;
	public HotelDataMysqlHelper() {
		connection = DBUtil.getConnection();
	}
	

	@Override
	public Map<Integer, HotelPO> getHotelList(HotelFilter filter) {
		
		return null;
	}

	@Override
	public ResultMessage addHotel(HotelPO hotelPO) {
		
		return null;
	}

	@Override
	public ResultMessage updateHotel(HotelPO hotelPO) {
		
		return null;
	}

	@Override
	public ResultMessage delHotel(int hotelID) {
		String sql = ""+
					"delete from hotel where hotelID = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, hotelID);
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
		
		return ResultMessage.success;
	}

}
