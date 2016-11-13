package po;

import java.io.Serializable;
import java.util.List;

public class WebMarketerAccountPO implements Serializable{
	String name;
	String password;
	List<WebMarketerPO> webMarketerList;
	
	
	public WebMarketerAccountPO(String a,String p,List<WebMarketerPO> wM
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


	public List<WebMarketerPO> getWebMarketerList() {
		return webMarketerList;
	}


	public void setWebMarketerList(List<WebMarketerPO> webMarketerList) {
		this.webMarketerList = webMarketerList;
	}
	
	
}
