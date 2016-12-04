package dataHelperImpl;

import java.awt.Image;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import dataHelper.RoomDataHelper;
import message.ResultMessage;
import message.RoomStateMessage;
import po.RoomInfoPO;

public class RoomDataMysqlHelper implements RoomDataHelper {
	Connection connection;

	public RoomDataMysqlHelper() {
		connection = DBUtil.getConnection();
	}

	@Override
	public Map<String, RoomInfoPO> getRoomList(int hotel_ID) {

		String sql = "select * from roominfo where hotelID =? ";

		Map<String, RoomInfoPO> map = new LinkedHashMap<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, hotel_ID);
			ResultSet resultSet = preparedStatement.executeQuery();

			RoomInfoPO roomInfoPO = null;
			while (resultSet.next()) {

				roomInfoPO = new RoomInfoPO(resultSet.getInt("roomInfoID"), resultSet.getInt("hotelID"),
						resultSet.getString("roomID"), resultSet.getString("roomType"), resultSet.getInt("dafaultPrice"),
						RoomStateMessage.values()[resultSet.getInt("roomState")], resultSet.getDate("detailedInfo1"),
						resultSet.getDate("detailedInfo2"));

				map.put(roomInfoPO.getRoomID(), roomInfoPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return map;

	}

	@Override
	public ResultMessage addRoom(RoomInfoPO po) {

		String sql = "" + " insert into roominfo"
				+ " (hotelID,roomID,roomType,defaultPrice,roomState,detailedInfo1,detailedInfo2)"
				+ " values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, po.getHotelID());
			preparedStatement.setString(2, po.getRoomID());
			preparedStatement.setString(3, po.getRoomType());
			preparedStatement.setInt(4, po.getDefaultPrice());
			preparedStatement.setInt(5, po.getRoomState().ordinal());
			preparedStatement.setDate(6, new Date(po.getDetailedInfo1().getTime()));
			preparedStatement.setDate(7, new Date(po.getDetailedInfo2().getTime()));
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
		return ResultMessage.success;

	}

	@Override
	public ResultMessage modifyRoom(RoomInfoPO po) {

		String sql =" update roominfo"
				+ " set hotelID=?,roomID=?,roomType=?,defaultPrice=?,roomState=?,detailedInfo1=?,detailedInfo2=?"
				+ " where roomInfoID =?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, po.getHotelID());
			preparedStatement.setString(2, po.getRoomID());
			preparedStatement.setString(3, po.getRoomType());
			preparedStatement.setInt(4, po.getDefaultPrice());
			preparedStatement.setInt(5, po.getRoomState().ordinal());
			preparedStatement.setDate(6, new Date(po.getDetailedInfo1().getTime()));
			preparedStatement.setDate(7, new Date(po.getDetailedInfo2().getTime()));
			preparedStatement.setInt(8, po.getRoomInfoID());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	@Override
	public ResultMessage deleteRoom(Map<String, Object> condition) {

		StringBuffer stringBuffer = new StringBuffer("delete from roominfo where ");
		stringBuffer.append(condition.get("name") + " " + condition.get("relation") + " " + condition.get("value"));
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(stringBuffer.toString());
			if(preparedStatement.execute())
				return ResultMessage.success;
			return ResultMessage.notexist;
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
	}

}
