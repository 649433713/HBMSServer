package PO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class OrderPO implements Serializable{
	PersonalInfoPO personalInfo;
	String id;
	Date createDate;
	Date cancelDate;
	HotelPO hotelInfo;
	CreditRecordPO creditRecord;
	String state;
	Date checkDate;
	Date checkoutDate;
	int number;
	boolean hasChild;
	String contactInfo;
	String creditExplanation;
	Date executeDeadline;
	int price;
	
	
	public OrderPO(PersonalInfoPO pI,String i,Date cD,Date caD,HotelPO hI,
			CreditRecordPO cR,String s,
			Date chD,Date coD,int num,boolean hC,String cI,
			String cE,Date eD,int p){
		personalInfo=pI;
		id=i;
		createDate=cD;
		cancelDate=caD;
		hotelInfo=hI;
		creditRecord=cR;
		state=s;
		checkDate=cD;
		checkoutDate=coD;
		number=num;
		hasChild=hC;
		contactInfo=cI;
		creditExplanation=cE;
		executeDeadline=eD;
		price=p;
		
	}


	public PersonalInfoPO getPersonalInfo() {
		return personalInfo;
	}


	public void setPersonalInfo(PersonalInfoPO personalInfo) {
		this.personalInfo = personalInfo;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getCancelDate() {
		return cancelDate;
	}


	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
	}


	public HotelPO getHotelInfo() {
		return hotelInfo;
	}


	public void setHotelInfo(HotelPO hotelInfo) {
		this.hotelInfo = hotelInfo;
	}


	public CreditRecordPO getCreditRecord() {
		return creditRecord;
	}


	public void setCreditRecord(CreditRecordPO creditRecord) {
		this.creditRecord = creditRecord;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public Date getCheckDate() {
		return checkDate;
	}


	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}


	public Date getCheckoutDate() {
		return checkoutDate;
	}


	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public boolean isHasChild() {
		return hasChild;
	}


	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}


	public String getContactInfo() {
		return contactInfo;
	}


	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}


	public String getCreditExplanation() {
		return creditExplanation;
	}


	public void setCreditExplanation(String creditExplanation) {
		this.creditExplanation = creditExplanation;
	}


	public Date getExecuteDeadline() {
		return executeDeadline;
	}


	public void setExecuteDeadline(Date executeDeadline) {
		this.executeDeadline = executeDeadline;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	

	
	
	
}
