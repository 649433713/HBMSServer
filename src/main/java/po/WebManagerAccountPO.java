package po;

import java.io.Serializable;
import java.util.List;

public class WebManagerAccountPO implements Serializable{
    String account;
    String password;
    List<UserPO> webManagerList;

    public WebManagerAccountPO(String a,String p,List<UserPO> wM
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

    public List<UserPO> getWebManagerList() {
        return webManagerList;
    }

    public void setWebManagerList(List<UserPO> webManagerList) {
        this.webManagerList = webManagerList;
    }


}
