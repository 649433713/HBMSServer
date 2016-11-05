package PO;

import java.awt.Image;
import java.io.Serializable;

public class UserPO implements Serializable{
	String id;
	String accountName;
	String password;
	PersonalInfoPO personalInfo;
	CreditPO creditInfo;
	MemberInfoPO memberInfo;
	
	public UserPO(String i,String aN,String p
			,PersonalInfoPO pI,CreditPO cI,MemberInfoPO mI){
		id=i;
		accountName=aN;
		password=p;
		personalInfo=pI;
		creditInfo=cI;
		memberInfo=mI;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PersonalInfoPO getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfoPO personalInfo) {
		this.personalInfo = personalInfo;
	}

	public CreditPO getCreditInfo() {
		return creditInfo;
	}

	public void setCreditInfo(CreditPO creditInfo) {
		this.creditInfo = creditInfo;
	}

	public MemberInfoPO getMemberInfo() {
		return memberInfo;
	}

	public void setMemberInfo(MemberInfoPO memberInfo) {
		this.memberInfo = memberInfo;
	}
	
	

}
