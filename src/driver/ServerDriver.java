package driver;

import dao.HotelDao;
import daoImpl.HotelDaoImpl_stub;

/**
 * 驱动的总测试入口
 * @author 王凡
 *
 */
public class ServerDriver {
	public static void main(String[] args) {
	
		HotelDao hotelInfoDataService = new HotelDaoImpl_stub();
		HotelInfoDataService_Driver hotelInfoDataService_Driver= new HotelInfoDataService_Driver();
		hotelInfoDataService_Driver.drive(hotelInfoDataService);
	
	}
}
