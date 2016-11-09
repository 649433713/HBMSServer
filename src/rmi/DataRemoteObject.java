package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

import dao.HotelDao;
import daoImpl.HotelDaoImpl;
import po.HotelPO;

public class DataRemoteObject extends UnicastRemoteObject implements HotelDao{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4462344837104616646L;
	//别的dao的接口都implements ,然后写在这，然后构造函数里初始化
	private HotelDao hotelDao;
	
	protected DataRemoteObject() throws RemoteException {
		super();
		hotelDao = new HotelDaoImpl();
		
		
		 
		
	}

	@Override
	public Map<String, HotelPO> getHotelList(String hotel_region) {
		
		try {
			return hotelDao.getHotelList(hotel_region);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public HotelPO getHotelInfo(String hotel_ID) {
		
		try {
			return hotelDao.getHotelInfo(hotel_ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, HotelPO> getHotelList() {
		
		try {
			return hotelDao.getHotelList();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addHotel(HotelPO po) {
		
		try {
			return hotelDao.addHotel(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean modifyHotel(HotelPO po) {
		
		try {
			return hotelDao.modifyHotel(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteHotel(String hotel_ID) {
		
		try {
			return hotelDao.deleteHotel(hotel_ID);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
