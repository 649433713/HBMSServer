package PO;

import java.io.Serializable;
import java.util.List;

public class StaffAccountPO implements Serializable{
	String name;
	String password;
	List<StaffPO> staffList;
	
	public StaffAccountPO(String n,String p,List<StaffPO> sL){
		name=n;
		password=p;
		staffList=sL;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<StaffPO> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<StaffPO> staffList) {
		this.staffList = staffList;
	}
	
}
