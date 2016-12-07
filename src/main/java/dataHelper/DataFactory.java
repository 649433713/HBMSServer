package dataHelper;

public interface DataFactory {
	
	public HotelDataHelper getHotelDataHelper();
	
	public UserDataHelper getUserDataHelper();
	
	public RoomDataHelper getRoomDataHelper() ;
	
	public OrderDataHelper getOrderDataHelper();

	public CreditDataHelper getCreditDataHelper();
}
