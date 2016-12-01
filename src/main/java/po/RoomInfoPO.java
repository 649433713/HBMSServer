package po;


import java.io.Serializable;
import java.util.Date;

public class RoomInfoPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int roomInfoID;
	int hotelID;
	String roomID;
	String roomType;
	int roomPrice;
	int roomState;
	Date detailedInfo1;
	Date detailedInfo2;
	public RoomInfoPO(int roomInfoID, int hotelID, String roomID, String roomType, int roomPrice, int roomState,
			Date detailedInfo1, Date detailedInfo2) {
		super();
		this.roomInfoID = roomInfoID;
		this.hotelID = hotelID;
		this.roomID = roomID;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomState = roomState;
		this.detailedInfo1 = detailedInfo1;
		this.detailedInfo2 = detailedInfo2;
	}
	
	
	@Override
	public String toString() {
		return "RoomInfoPO [roomInfoID=" + roomInfoID + ", hotelID=" + hotelID + ", roomID=" + roomID + ", roomType="
				+ roomType + ", roomPrice=" + roomPrice + ", roomState=" + roomState + ", detailedInfo1="
				+ detailedInfo1 + ", detailedInfo2=" + detailedInfo2 + "]";
	}


	public int getRoomInfoID() {
		return roomInfoID;
	}
	public void setRoomInfoID(int roomInfoID) {
		this.roomInfoID = roomInfoID;
	}
	public int getHotelID() {
		return hotelID;
	}
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getRoomPrice() {
		return roomPrice;
	}
	public void setRoomPrice(int roomPrice) {
		this.roomPrice = roomPrice;
	}
	public int getRoomState() {
		return roomState;
	}
	public void setRoomState(int roomState) {
		this.roomState = roomState;
	}
	public Date getDetailedInfo1() {
		return detailedInfo1;
	}
	public void setDetailedInfo1(Date detailedInfo1) {
		this.detailedInfo1 = detailedInfo1;
	}
	public Date getDetailedInfo2() {
		return detailedInfo2;
	}
	public void setDetailedInfo2(Date detailedInfo2) {
		this.detailedInfo2 = detailedInfo2;
	}
	
	
	
}
