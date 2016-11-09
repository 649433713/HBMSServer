package po;

import java.io.Serializable;
import java.util.List;

public class WebManagerAccountPO implements Serializable{
	String account;
	String password;
	List<WebManagerPO> webManagerList;
	
	public WebManagerAccountPO(String a,String p,List<WebManagerPO> wM
			){
		account=a;
		password=p;
		webManagerList=wM;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<WebManagerPO> getWebManagerList() {
		return webManagerList;
	}

	public void setWebManagerList(List<WebManagerPO> webManagerList) {
		this.webManagerList = webManagerList;
	}
	
	
}
