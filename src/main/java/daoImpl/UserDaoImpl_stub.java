package daoImpl;

import dao.UserDao;
import message.ResultMessage;
import model.UserType;
import model.UserTypeHelper;
import po.UserPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by alex on 16-11-9.
 */
public class UserDaoImpl_stub implements UserDao{
    @Override
    public ArrayList<UserPO> getUserList() throws RemoteException {
        ArrayList<UserPO> userlist=new ArrayList<>();
        userlist.add(new UserPO("0000000000"));
        userlist.add(new UserPO("0100000000"));
        userlist.add(new UserPO("0200000000"));
        userlist.add(new UserPO("0300000000"));
        return userlist;
    }

    @Override
    public ResultMessage add(UserPO po) throws RemoteException {
        UserTypeHelper userTypeHelper=new UserTypeHelper();
        String user_id=po.getId();
        if(userTypeHelper.getUserType(user_id).equals(UserType.Customer)){
            System.out.println("adding a customer successfully!");
            return ResultMessage.success;
        }else if(userTypeHelper.getUserType(user_id).equals(UserType.Staff)){
            System.out.println("adding a staff successfully!");
            return ResultMessage.success;
        }else if(userTypeHelper.getUserType(user_id).equals(UserType.WebMarketer)){
            System.out.println("adding a web manager successfully!");
            return ResultMessage.success;
        }else if(userTypeHelper.getUserType(user_id).equals(UserType.WebManager)){
            System.out.println("adding a web marketer successfully!");
            return ResultMessage.success;
        }else{
            return ResultMessage.failure;
        }
    }

    @Override
    public UserPO find(String id) throws RemoteException {
        UserTypeHelper userTypeHelper=new UserTypeHelper();
        UserType userType=userTypeHelper.getUserType(id);
        if(userType.equals(UserType.Customer)){
            System.out.println("a customer found");
            return new UserPO(id);
        }else if(userType.equals(UserType.Staff)){
            System.out.println("a staff found");
            return new UserPO(id);
        }else if(userType.equals(UserType.WebMarketer)){
            System.out.println("a web marketer found");
            return new UserPO(id);
        }else if(userType.equals(UserType.WebManager)){
            System.out.println("a web manager found");
            return new UserPO(id);
        }
        System.out.println("find unsuccessfully");
        return null;
    }

    @Override
    public ResultMessage delete(String id) throws RemoteException {
        System.out.println("delete successfully");
        return ResultMessage.success;
    }

    @Override
    public ResultMessage update(UserPO po) throws RemoteException {
        System.out.println("update successfully");
        return ResultMessage.success;
    }

    @Override
    public ResultMessage login(String id, String pwd) throws RemoteException {
        UserTypeHelper userTypeHelper=new UserTypeHelper();
        UserType userType=userTypeHelper.getUserType(id);
        if(id.equals(pwd)) {
            if(userType.equals(UserType.Customer)){
                System.out.println("a customer logged in");
                return ResultMessage.success;
            }else if(userType.equals(UserType.Staff)){
                System.out.println("a staff logged in");
                return ResultMessage.success;
            }else if(userType.equals(UserType.WebMarketer)){
                System.out.println("a web marketer logged in");
                return ResultMessage.success;
            }else if(userType.equals(UserType.WebManager)){
                System.out.println("a web manager logged in");
                return ResultMessage.success;
            }else{
                System.out.println("wrong id or password");
                return ResultMessage.failure;
            }
        } else{
            System.out.println("login unsuccessfully");
            return ResultMessage.failure;
        }
    }

    @Override
    public ResultMessage signup(UserPO po) throws RemoteException {
        //the processes of checking and DB operation are ignored
        System.out.println("signup successfully");
        return ResultMessage.success;
    }
}
