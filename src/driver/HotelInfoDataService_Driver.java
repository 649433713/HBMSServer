package driver;

import java.rmi.RemoteException;

import PO.HotelPO;
import dao.HotelDao;

public class HotelInfoDataService_Driver {
	public void drive(HotelDao hotelInfoDataService) {
	try {
		hotelInfoDataService.addHotel(new HotelPO());
		hotelInfoDataService.modifyHotel(new HotelPO());
		hotelInfoDataService.deleteHotel("0001");
		hotelInfoDataService.getHotelList();
		hotelInfoDataService.getHotelList("0001");
		hotelInfoDataService.getHotelInfo("0001");
	} catch (RemoteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
}
