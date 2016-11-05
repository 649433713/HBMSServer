package PO;

import java.awt.Image;
import java.io.Serializable;
import java.util.List;

public class HotelPO implements Serializable{
	String name;
	String id;
	int star;
	String address;
	String region;
	String introduction;
	String facility;
	Image environment;
	CommentInfoPO commentInfo;
	RoomInfoPO roomInfo;
	List<OrderPO> historyOrder;
	StaffAccountPO staffAccount;
	
	public HotelPO(String n,String i,int s,String a,
			String r,String in,String f,Image e,
			RoomInfoPO rI,List<OrderPO> hO,StaffAccountPO sA){
		name=n;
		id=i;
		star=s;
		address=a;
		region=r;
		introduction=in;
		facility=f;
		environment=e;
		roomInfo=rI;
		historyOrder=hO;
		staffAccount=sA;
	}

	public HotelPO() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public Image getEnvironment() {
		return environment;
	}

	public void setEnvironment(Image environment) {
		this.environment = environment;
	}

	public CommentInfoPO getCommentInfo() {
		return commentInfo;
	}

	public void setCommentInfo(CommentInfoPO commentInfo) {
		this.commentInfo = commentInfo;
	}

	public RoomInfoPO getRoomInfo() {
		return roomInfo;
	}

	public void setRoomInfo(RoomInfoPO roomInfo) {
		this.roomInfo = roomInfo;
	}

	public List<OrderPO> getHistoryOrder() {
		return historyOrder;
	}

	public void setHistoryOrder(List<OrderPO> historyOrder) {
		this.historyOrder = historyOrder;
	}

	public StaffAccountPO getStaffAccount() {
		return staffAccount;
	}

	public void setStaffAccount(StaffAccountPO staffAccount) {
		this.staffAccount = staffAccount;
	}

	
	
}
