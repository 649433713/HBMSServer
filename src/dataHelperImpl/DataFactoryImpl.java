package dataHelperImpl;

import dataHelper.DataFactory;
import dataHelper.HotelDataHelper;
import dataHelper.UserDataHelper;

public class DataFactoryImpl implements DataFactory{

	public HotelDataHelper getHotelDataHelper() {
		HotelDataHelper hotelDataHelper = new HotelDataTxtHelper();
		return hotelDataHelper;
	}

	public UserDataHelper getUserDataHelper(){
		UserDataHelper userDataHelper=new UserDataTxtHelper();
		return userDataHelper;
	}
}
