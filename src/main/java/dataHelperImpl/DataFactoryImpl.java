package dataHelperImpl;

import dataHelper.DataFactory;
import dataHelper.HotelDataHelper;
import dataHelper.RoomDataHelper;
import dataHelper.UserDataHelper;

public class DataFactoryImpl implements DataFactory{

	public HotelDataHelper getHotelDataHelper() {
		HotelDataHelper hotelDataHelper = new HotelDataMysqlHelper();
		return hotelDataHelper;
	}

	public UserDataHelper getUserDataHelper(){
		UserDataHelper userDataHelper=new UserDataTxtHelper();
		return userDataHelper;
	}

	@Override
	public RoomDataHelper getRoomDataHelper() {
		RoomDataHelper roomDataHelper = new RoomDataTxtHelper();
		return roomDataHelper;
	}
}
