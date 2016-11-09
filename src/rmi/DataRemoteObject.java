package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import PO.HotelPO;
import dao.HotelDao;
import dao.UserDao;
import daoImpl.HotelDaoImpl;
import daoImpl.UserDaoImpl;
import message.ResultMessage;

public class DataRemoteObject extends UnicastRemoteObject implements HotelDao, UserDao{


	/**
	 * 
	 */
	private static final long serialVersionUID = 4462344837104616646L;
	//别的dao的接口都implements ,然后写在这，然后构造函数里初始化
	private HotelDao hotelDao;
	private UserDao userDao;
	
	protected DataRemoteObject() throws RemoteException {
		super();
		hotelDao = new HotelDaoImpl();
		userDao=new UserDaoImpl();
		
		 
		
	}

	@Override
	public HotelPO[] getHotelList(String hotel_region) {
		
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
	public HotelPO[] getHotelList() {
		
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

	@Override
	public ResultMessage add(Object po) throws RemoteException {
		try {
			return userDao.add(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}

	@Override
	public Object find(String id) throws RemoteException {
		try {
			return userDao.find(id);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultMessage delete(Object po) throws RemoteException {
		try {
			return userDao.delete(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}

	@Override
	public ResultMessage update(Object po) throws RemoteException {
		try {
			return userDao.update(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}

	@Override
	public ResultMessage login(String id, String pwd) throws RemoteException {
		try {
			return userDao.login(id,pwd);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}

	@Override
	public ResultMessage signup(Object po) throws RemoteException {
		try {
			return userDao.signup(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.failure;
	}
}
