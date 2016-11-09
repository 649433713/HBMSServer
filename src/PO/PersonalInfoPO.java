package PO;

import java.awt.Image;
import java.io.Serializable;

public class PersonalInfoPO implements Serializable{
	String name;
	String contactInfo;
	Image portrait;
	public PersonalInfoPO(String n,String cI,Image p){
		name=n;
		contactInfo=cI;
		portrait=p;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public Image getPortrait() {
		return portrait;
	}
	public void setPortrait(Image portrait) {
		this.portrait = portrait;
	}
	
}
