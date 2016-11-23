package po;

import java.io.Serializable;
import java.util.List;

public class WebMarketerAccountPO implements Serializable{
	String name;
	String password;
	List<UserPO> webMarketerList;
	
	
	public WebMarketerAccountPO(String a,String p,List<UserPO> wM
			){
		name=a;
		password=p;
		webMarketerList=wM;	
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


	public List<UserPO> getWebMarketerList() {
		return webMarketerList;
	}


	public void setWebMarketerList(List<UserPO> webMarketerList) {
		this.webMarketerList = webMarketerList;
	}
	
	
}
