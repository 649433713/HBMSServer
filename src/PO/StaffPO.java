package PO;

import java.io.Serializable;

import javax.print.DocFlavor.STRING;

public class StaffPO implements Serializable{
	String name;
	String workid;
	String id;
	String hotelid;
	String contactInfo;
	
	public StaffPO(String n,String w,String i,
			String h,String cI){
		name=n;
		workid=w;
		id=i;
		hotelid=h;
		contactInfo=cI;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkid() {
		return workid;
	}

	public void setWorkid(String workid) {
		this.workid = workid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHotelid() {
		return hotelid;
	}

	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
}
