package dataHelperImpl;

import dataHelper.DataFactory;
import dataHelper.HotelDataHelper;

public class DataFactoryImpl implements DataFactory{

	public HotelDataHelper getHotelDataHelper() {
		HotelDataHelper hotelDataHelper = new HotelDataTxtHelper();
		return hotelDataHelper;
	}
}
