package dataHelperImpl;

import java.awt.Image;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;

import dataHelper.HotelDataHelper;
import message.ResultMessage;
import model.HotelFilter;
import po.CommentInfoPO;
import po.HotelPO;
import po.RegionPO;

public class HotelDataMysqlHelper implements HotelDataHelper {
	Connection connection;

	public HotelDataMysqlHelper() {
		connection = DBUtil.getConnection();
	}

	@Override
	public Map<Integer, HotelPO> getHotelList(HotelFilter filter,String order,java.util.Date date) {

		if (date!=null) {
			Calendar c1 = Calendar.getInstance();
	        Calendar c2 = Calendar.getInstance();
	        
	        c1.setTime(new java.util.Date());
	        c2.setTime(date);

	        int difference = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
	        DecimalFormat decimalFormat = new DecimalFormat("00");
	        String dayOff = "day"+decimalFormat.format(difference);
			
			String sql = "{call updateLowestPrice(?)}";
			try {
				CallableStatement callableStatement = connection.prepareCall(sql);
				callableStatement.setString(1, dayOff);
				callableStatement.execute();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		StringBuffer stringBuffer = new StringBuffer("select * from hotel where 1=1");

		if (filter != null && filter.filter.size() > 0) {
			for (int i = 0; i < filter.filter.size(); i++) {
				Map<String, Object> map = filter.filter.get(i);
				stringBuffer.append(" and " + map.get("name") + " " + map.get("relation") + " " + map.get("value"));
			}
		}
		if (order!=null) {
			if (order.equals("lowestPrice")) {
				stringBuffer.append(" order by "+order);
			}
			else {
				stringBuffer.append(" order by "+order+" desc");
			}
		
		}
		Map<Integer, HotelPO> map = new LinkedHashMap<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(stringBuffer.toString());
			ResultSet resultSet = preparedStatement.executeQuery();

			HotelPO hotelPO = null;
			while (resultSet.next()) {
				List<Image> images = new ArrayList<>();
				ImageIcon icon;
				if (resultSet.getString("environment1") != null) {
					icon = new ImageIcon(resultSet.getString("environment1"));
					images.add(icon.getImage());
				}
				if (resultSet.getString("environment2") != null) {
					icon = new ImageIcon(resultSet.getString("environment2"));
					images.add(icon.getImage());
				}
				if (resultSet.getString("environment3") != null) {
					icon = new ImageIcon(resultSet.getString("environment3"));
					images.add(icon.getImage());
				}

				hotelPO = new HotelPO(resultSet.getString("name"), resultSet.getInt("hotelID"),
						resultSet.getInt("star"), resultSet.getString("address"), resultSet.getInt("region"),
						resultSet.getString("introduction"), resultSet.getString("facility"), images,
						resultSet.getInt("score"),resultSet.getInt("lowestPrice"));

	
				map.put(hotelPO.getId(), hotelPO);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return map;
	}

	@Override
	public ResultMessage addHotel(HotelPO hotelPO) {
		
		List<Image> images = hotelPO.getEnvironment();
		String imagePath1 = null;
		String imagePath2 = null;
		String imagePath3 = null;
		/*
		 * 这个path我是不会存
		 * 
		 */
		String sql = ""+
					" insert into hotel"+
					" (name,address,region,introduction,"+
					" star,environment1,environment2,environment3,facility,score)"+
					" values(?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, hotelPO.getName());
			preparedStatement.setString(2, hotelPO.getAddress());
			preparedStatement.setInt(3, hotelPO.getRegion());
			preparedStatement.setString(4, hotelPO.getIntroduction());
			preparedStatement.setInt(5, hotelPO.getStar());
			preparedStatement.setString(6, imagePath1);
			preparedStatement.setString(7, imagePath2);
			preparedStatement.setString(8, imagePath3);
			preparedStatement.setString(9, hotelPO.getFacility());
			preparedStatement.setInt(10, hotelPO.getScore());
			
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	@Override
	public ResultMessage updateHotel(HotelPO hotelPO) {
		List<Image> images = hotelPO.getEnvironment();
		String imagePath1 = null;
		String imagePath2 = null;
		String imagePath3 = null;
		/*
		 * 这个path我是不会存
		 * 
		 */
		String sql = ""+
					" update hotel"+
					" set name=?,address=?,region=?,introdution=?,"+
					" star=?,environment1=?,environment2=?,environment3=?,facility=?,score=?"+
					" where hotelID=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, hotelPO.getName());
			preparedStatement.setString(2, hotelPO.getAddress());
			preparedStatement.setInt(3, hotelPO.getRegion());
			preparedStatement.setString(4, hotelPO.getIntroduction());
			preparedStatement.setInt(5, hotelPO.getStar());
			preparedStatement.setString(6, imagePath1);
			preparedStatement.setString(7, imagePath2);
			preparedStatement.setString(8, imagePath3);
			preparedStatement.setString(9, hotelPO.getFacility());
			preparedStatement.setInt(10, hotelPO.getScore());
			preparedStatement.setInt(11, hotelPO.getId());
			
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	}

	@Override
	public ResultMessage delHotel(int hotelID) {

		String sql = "" + " Select * from hotel" + " where hotelID =? ";

		String sql2 = "" + "delete from hotel where hotelID = ?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		/*	preparedStatement.setInt(1, hotelID);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (!resultSet.next()) {
				System.out.println("不存在此id");
				return ResultMessage.notexist;
			}
*/
			preparedStatement = connection.prepareStatement(sql2);
			preparedStatement.setInt(1, hotelID);
			if (preparedStatement.execute()) {
				return ResultMessage.success;
			}
			System.out.println("还是不存在");
			return ResultMessage.notexist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}

		
	}

	@Override
	public List<CommentInfoPO> getComments(int hotelID) {
			
		String sql = "select * from commentinfo where hotelID =? ";

		List<CommentInfoPO> list = new ArrayList<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, hotelID);
			ResultSet resultSet = preparedStatement.executeQuery();

			CommentInfoPO commentInfoPO = null;
			while (resultSet.next()) {
	
				Image image1 = null,image2 = null,image3 = null;
				if (resultSet.getString("picture1") != null) {
					image1 = new ImageIcon(resultSet.getString("picture1")).getImage();
	
				}
				if (resultSet.getString("picture2") != null) {
					image2 = new ImageIcon(resultSet.getString("picture2")).getImage();
					
				}
				if (resultSet.getString("picture3") != null) {
					image3 = new ImageIcon(resultSet.getString("picture3")).getImage();
				}

				commentInfoPO = new CommentInfoPO(resultSet.getInt("commentID"), 
						resultSet.getDate("time"), resultSet.getInt("hotelID"), 
						resultSet.getInt("score"), resultSet.getString("comment"),
						image1,image2,image3);

				list.add(commentInfoPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return list;
		
	
	}

	@Override
	public ResultMessage addComment(CommentInfoPO commentInfoPO) {
		
		String imagePath1 = null;
		String imagePath2 = null;
		String imagePath3 = null;
		/*
		 * 这个path我是不会存
		 * 
		 */
		String sql = ""+
					" insert into commentinfo"+
					" (time,hotelID,score,comment,picture1,picture2,picture3)"+
					" values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setDate(1,new Date(commentInfoPO.getTime().getTime()));
			preparedStatement.setInt(2,commentInfoPO.getHotelID());
			preparedStatement.setInt(3,commentInfoPO.getScore());
			preparedStatement.setString(4,commentInfoPO.getComment());
			preparedStatement.setString(5, imagePath1);
			preparedStatement.setString(6, imagePath2);
			preparedStatement.setString(7, imagePath3);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResultMessage.failure;
		}
		return ResultMessage.success;
	
	}

	@Override
	public Map<Integer, RegionPO> getRegions() {
		
		String sql = "select * from region";

		Map<Integer, RegionPO> map = new LinkedHashMap<>();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(sql);
	
			ResultSet resultSet = preparedStatement.executeQuery();

			RegionPO regionPO = null;
			while (resultSet.next()) {

				regionPO = new RegionPO(resultSet.getInt("regionID"),
						resultSet.getString("province") , resultSet.getString("city"), 
						resultSet.getString("regionName"));
				
				map.put(regionPO.getRegionID(), regionPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return map;
		
	}

}
