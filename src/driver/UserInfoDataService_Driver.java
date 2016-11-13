package driver;

import dao.UserDao;
import po.CustomerPO;
import po.StaffPO;
import po.WebManagerPO;
import po.WebMarketerPO;

import java.rmi.RemoteException;

/**
 * Created by alex on 16-11-9.
 */
public class UserInfoDataService_Driver {
    public void drive(UserDao userInfoDataService){
        try{
            userInfoDataService.signup(new CustomerPO());
            userInfoDataService.login("0000","0000");
            userInfoDataService.login("0001","0001");
            userInfoDataService.login("0002","0002");
            userInfoDataService.login("0003","0003");
            userInfoDataService.login("0004","0004");
            userInfoDataService.find("0000");
            userInfoDataService.find("00001");
            userInfoDataService.find("0001");
            userInfoDataService.find("0002");
            userInfoDataService.find("0003");
            userInfoDataService.add(new CustomerPO());
            userInfoDataService.add(new StaffPO());
            userInfoDataService.delete(new CustomerPO());
            userInfoDataService.delete(new WebManagerPO());
            userInfoDataService.update(new WebMarketerPO());
            userInfoDataService.update(new WebManagerPO());
        }catch(RemoteException e){
            e.printStackTrace();
        }
    }
}
