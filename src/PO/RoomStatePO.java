package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RoomStatePO implements Serializable{
	RoomInfoPO roomInfo;
	int price;
	String number;
	String type;
	List<Date> detailedInfo;
	
	public RoomStatePO(RoomInfoPO rI,int p,String n,String t
			,List<Date> dI){
		roomInfo=rI;
		price=p;
		number=n;
		type=t;
		detailedInfo=dI;
	}

	public RoomInfoPO getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(RoomInfoPO roomInfo) {
		this.roomInfo = roomInfo;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Date> getDetailedInfo() {
		return detailedInfo;
	}

	public void setDetailedInfo(List<Date> detailedInfo) {
		this.detailedInfo = detailedInfo;
	}

	
	
}
