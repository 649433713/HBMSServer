package driver;

import dao.UserDao;
import po.UserPO;

import java.rmi.RemoteException;

/**
 * Created by alex on 16-11-9.
 */
public class UserInfoDataService_Driver {
    public void drive(UserDao userInfoDataService){
        try{
            userInfoDataService.signup(new UserPO("0000000000"));
            userInfoDataService.login("0000000000","0000000000");
            userInfoDataService.login("0100000000","0100000000");
            userInfoDataService.login("0200000000","0200000000");
            userInfoDataService.login("0300000000","0300000000");
            userInfoDataService.login("0400000000","0400000000");
            userInfoDataService.find("0000000000");
            userInfoDataService.find("0100000000");
            userInfoDataService.find("0200000000");
            userInfoDataService.find("0200000001");
            userInfoDataService.find("0300000000");
            userInfoDataService.add(new UserPO("1110000000"));
            userInfoDataService.add(new UserPO("0200000000"));
            userInfoDataService.delete("1110000000");
            userInfoDataService.update(new UserPO("1110000000"));
            userInfoDataService.update(new UserPO("0200000000"));
        }catch(RemoteException e){
            e.printStackTrace();
        }
    }
}
