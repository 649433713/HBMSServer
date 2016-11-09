package po;


import java.io.Serializable;
import java.util.List;

public class RoomInfoPO implements Serializable{
	List<RoomInfoPO> roomList;
	String roomType;
	int price;
	
	
	public RoomInfoPO(List<RoomInfoPO> rL,String rT,int p){
		roomList=rL;
		roomType=rT;
		price=p;
		
	}


	public RoomInfoPO() {
		// TODO Auto-generated constructor stub
	}


	public List<RoomInfoPO> getRoomList() {
		return roomList;
	}


	public void setRoomList(List<RoomInfoPO> roomList) {
		this.roomList = roomList;
	}


	public String getRoomType() {
		return roomType;
	}


	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}

	
}
