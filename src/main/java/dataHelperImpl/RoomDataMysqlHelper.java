package dataHelperImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import dataHelper.RoomDataHelper;
import message.ResultMessage;
import message.RoomStateMessage;
import model.DateToDayOff;
import po.RoomInfoPO;

public class RoomDataMysqlHelper implements RoomDataHelper {
	Connection connection;

	public RoomDataMysqlHelper() {
		connection = DBUtil.getConnection();
	}

	@Override
	public Map<String, RoomInfoPO> getRoomList(int hotel_ID,java.util.Date date) {

		if (date==null) {
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
							resultSet.getString("roomID"), resultSet.getString("roomType"), resultSet.getInt("defaultPrice"),
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

		}else {
			String dayOff = DateToDayOff.dateToDatOff(date);
			
			String sql = "select * from roominfo where hotelID =? group by roomType ";
			String sql2 = "select count(*)num,roomType from roomdate inner join roominfo "
					+ "on roomdate.roomInfoID = roominfo.roomInfoID where roominfo.hotelID = ? "
					+ "and "+dayOff+"=1 group by roomType";
			Map<String, RoomInfoPO> map = new LinkedHashMap<>();
			Map<String, Integer> roomNum = new LinkedHashMap<>();
			PreparedStatement preparedStatement;
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setInt(1, hotel_ID);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				preparedStatement = connection.prepareStatement(sql2);
				preparedStatement.setInt(1, hotel_ID);
		
				ResultSet resultSet2 = preparedStatement.executeQuery();

				while (resultSet2.next()) {
					
					roomNum.put(resultSet2.getString("roomType"), resultSet2.getInt("num"));					
				}

				RoomInfoPO roomInfoPO = null;
				while (resultSet.next()) {

					roomInfoPO = new RoomInfoPO(resultSet.getInt("roomInfoID"), resultSet.getInt("hotelID"),
							resultSet.getString("roomID"), resultSet.getString("roomType"), resultSet.getInt("defaultPrice"),
							RoomStateMessage.values()[resultSet.getInt("roomState")], resultSet.getDate("detailedInfo1"),
							resultSet.getDate("detailedInfo2"));
					int i = 0;
					if (roomNum.get(roomInfoPO.getRoomType())!=null) {
						i =roomNum.get(roomInfoPO.getRoomType());
					}
				
					roomInfoPO.setTempNum(i);
					map.put(roomInfoPO.getRoomID(), roomInfoPO);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}

			return map;

		}
		
	}

	@Override
	public ResultMessage addRoom(RoomInfoPO po) {

		String sql = "" + " insert into roominfo"
				+ " (hotelID,roomID,roomType,defaultPrice,roomState)"
				+ " values(?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, po.getHotelID());
			preparedStatement.setString(2, po.getRoomID());
			preparedStatement.setString(3, po.getRoomType());
			preparedStatement.setInt(4, po.getDefaultPrice());
			preparedStatement.setInt(5, 1);
			
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
	public ResultMessage deleteRoom(int roomInfoID) {

		if (roomInfoID == 0) {
			return ResultMessage.notexist;
		}
		String sql = "delete from roominfo where  roomInfoID ="+roomInfoID;
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

	/*
	* Title: modifyStateByDay
	*Description: 
	* @param roomInfoID
	* @param roomState
	* @param date
	* @return 
	* @see dataHelper.RoomDataHelper#modifyStateByDay(int, message.RoomStateMessage, java.util.Date) 
	*/
	@Override
	public ResultMessage modifyStateByDay(int roomInfoID, RoomStateMessage roomState, java.util.Date date) {
		String dayOff = null;
		if (date!=null) {
			dayOff = DateToDayOff.dateToDatOff(date);
	
		}

		String sql =" update roomdate set "+dayOff+"=? where roomInfoID =?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

	
			preparedStatement.setInt(1, roomState.ordinal());
			preparedStatement.setInt(2, roomInfoID);
		
			preparedStatement.execute();
				
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}
		
	/*
	* Title: modifyPriceByDay
	*Description: 
	* @param roomInfoID
	* @param price
	* @param date
	* @return 
	* @see dataHelper.RoomDataHelper#modifyPriceByDay(int, int, java.util.Date) 
	*/
	@Override
	public ResultMessage modifyPriceByDay(int roomInfoID, int price, java.util.Date date) {
		String dayOff = DateToDayOff.dateToDatOff(date);
        
		String sql = " update roomprice set "+dayOff+"=? where roomInfoID =?";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
	
			preparedStatement.setInt(1, price);
			preparedStatement.setInt(2, roomInfoID);
			
			preparedStatement.execute();
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	
}
