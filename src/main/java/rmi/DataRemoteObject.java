package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import dao.CreditDao;
import dao.HotelDao;
import dao.OrderDao;
import dao.RoomDao;
import dao.UserDao;
import daoImpl.CreditDaoImpl;
import daoImpl.HotelDaoImpl;
import daoImpl.OrderDaoImpl;
import daoImpl.RoomDaoImpl;
import daoImpl.UserDaoImpl;
import message.ResultMessage;
import message.RoomStateMessage;
import model.HotelFilter;
import po.CommentInfoPO;
import po.CreditPO;
import po.HotelPO;
import po.OrderPO;
import po.RegionPO;
import po.RoomInfoPO;
import po.UserPO;

public class DataRemoteObject extends UnicastRemoteObject implements HotelDao, UserDao, CreditDao, OrderDao, RoomDao {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4462344837104616646L;
	//鍒殑dao鐨勬帴鍙ｉ兘implements ,鐒跺悗鍐欏湪杩欙紝鐒跺悗鏋勯�犲嚱鏁伴噷鍒濆鍖�
	private HotelDao hotelDao;
	private UserDao userDao;
	private CreditDao creditDao;
	private OrderDao orderDao;
	private RoomDao roomDao;
	
	protected DataRemoteObject() throws RemoteException {
		super();
		hotelDao = new HotelDaoImpl();
		userDao=new UserDaoImpl();
		creditDao = new CreditDaoImpl();
		orderDao = new OrderDaoImpl();
		roomDao = new RoomDaoImpl();
		 
		
	}

	@Override
	public Map<Integer, HotelPO> getHotelList(HotelFilter filter,String order,java.util.Date date) throws RemoteException{

			return hotelDao.getHotelList(filter,order,date);
	}

	@Override
	public HotelPO getHotelInfo(int hotel_ID) throws RemoteException{
		
			return hotelDao.getHotelInfo(hotel_ID);
	
	}



	@Override
	public ResultMessage addHotel(HotelPO po) throws RemoteException{
	
			return hotelDao.addHotel(po);
	
	}

	@Override
	public ResultMessage modifyHotel(HotelPO po) throws RemoteException{
	
			return hotelDao.modifyHotel(po);
	
	}

	@Override
	public ResultMessage deleteHotel(int hotel_ID) throws RemoteException{
	
			return hotelDao.deleteHotel(hotel_ID) ;
	
	}

	@Override
	public ResultMessage add(UserPO po) throws RemoteException {
	
			return userDao.add(po);

	}

	@Override
	public UserPO find(String id) throws RemoteException {
	
			return userDao.find(id);
	
	}

	@Override
	public ResultMessage delete(String id) throws RemoteException {
	
			return userDao.delete(id);
	
	}

	@Override
	public ResultMessage update(UserPO po) throws RemoteException {
	
			return userDao.update(po);

	}

	@Override
	public ResultMessage login(String id, String pwd) throws RemoteException {
		
			return userDao.login(id,pwd);

	}

	@Override
	public ResultMessage signup(UserPO po) throws RemoteException {
		
			return userDao.signup(po);
	
	}

	@Override
	public ArrayList<UserPO> getUserList() throws RemoteException {
	
			return userDao.getUserList();
	
	}

	@Override
	public Map<String, RoomInfoPO> getRoomList(int hotel_ID,Date date) throws RemoteException {
		return roomDao.getRoomList(hotel_ID,date);
	}

	@Override
	public RoomInfoPO getRoomInfo(String roomType) throws RemoteException {
		return roomDao.getRoomInfo(roomType);
	}

	@Override
	public ResultMessage addRoom(RoomInfoPO po) throws RemoteException {
		
		return roomDao.addRoom(po);
	}

	@Override
	public ResultMessage modifyRoom(RoomInfoPO po) throws RemoteException {
		
		return roomDao.modifyRoom(po);
	}

	@Override
	public ResultMessage deleteRoom(int room_ID) throws RemoteException {
		
		return roomDao.deleteRoom(room_ID);
	}


	@Override
	public Map<String, OrderPO> getOrderList(String id) throws RemoteException {
		
		return orderDao.getOrderList(id);
	}

	@Override
	public ResultMessage addOrder(OrderPO orderpo) throws RemoteException {
		
		return  orderDao.addOrder(orderpo);
	}

	@Override
	public ResultMessage deleteOrder(OrderPO orderpo) throws RemoteException {
		
		return  orderDao.deleteOrder(orderpo);
	}

	@Override
	public ResultMessage modifyOrder(OrderPO orderpo) throws RemoteException {
		
		return  orderDao.modifyOrder(orderpo);
	}

	@Override
	public OrderPO findOrder(String orderID) throws RemoteException {
		
		return  orderDao.findOrder(orderID);
	}

	@Override
	public void showCredit() throws RemoteException {
		creditDao.showCredit();
	}

	@Override
	public void showCreditRecord() throws RemoteException {
		creditDao.showCreditRecord();
	}

	@Override
	public boolean addCredit(int creditValue) throws RemoteException {
		
		return creditDao.addCredit(creditValue);
	}

	@Override
	public boolean resumeCredit(CreditPO credit) throws RemoteException {
		
		return creditDao.resumeCredit(credit);
	}

	@Override
	public int getCreditValue(String id) throws RemoteException {
		
		return creditDao.getCreditValue(id);
	}

	@Override
	public int setCreditValue(String id, int value) throws RemoteException {
		
		return creditDao.setCreditValue(id, value);
	}

	@Override
	public String getChangeType(String id) throws RemoteException {
		
		return creditDao.getChangeType(	id);
	}

	@Override
	public String getReasonType(String id) throws RemoteException {
		
		return creditDao.getReasonType(id);
	}

	@Override
	public String getAccount(String id) throws RemoteException {
		
		return creditDao.getAccount(id);
	}

	@Override
	public List<CommentInfoPO> getComments(int hotelID) throws RemoteException {
		
		return hotelDao.getComments(hotelID);
	}

	@Override
	public ResultMessage addComment(CommentInfoPO commentInfoPO) throws RemoteException {
		
		return hotelDao.addComment(commentInfoPO);
	}

	@Override
	public Map<Integer, RegionPO> getRegions() throws RemoteException {
		
		return hotelDao.getRegions();
	}


	@Override
	public ResultMessage modifyRoomState(int roomInfoID, RoomStateMessage room_state, Date date1, Date date2)
			throws RemoteException {
		
		return roomDao.modifyRoomState(roomInfoID, room_state, date1, date2);
	}

	@Override
	public ResultMessage deleteRoom(int hotelID, String roomID) throws RemoteException {
		
		return roomDao.deleteRoom(hotelID, roomID);
	}


	@Override
	public ResultMessage modifyRoomStateByDay(int roomInfoID, RoomStateMessage roomState, Date date)
			throws RemoteException {
		
		return roomDao.modifyRoomStateByDay(roomInfoID, roomState, date);
	}


	@Override
	public ResultMessage setPrice(int roomInfoID, Date date, int price) throws RemoteException {
		
		return roomDao.setPrice(roomInfoID, date, price);
	}
}
