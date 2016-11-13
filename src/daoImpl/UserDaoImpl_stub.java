package daoImpl;

import PO.CustomerPO;
import PO.StaffPO;
import PO.WebManagerPO;
import PO.WebMarketerPO;
import dao.UserDao;
import message.ResultMessage;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by alex on 16-11-9.
 */
public class UserDaoImpl_stub implements UserDao{
    @Override
    public ArrayList<Object> getUserList() throws RemoteException {
        ArrayList<Object> userlist=new ArrayList<>();
        userlist.add(new CustomerPO());
        userlist.add(new CustomerPO());
        userlist.add(new CustomerPO());
        userlist.add(new CustomerPO());
        return userlist;
    }

    @Override
    public ResultMessage add(Object po) throws RemoteException {
        //Conundrums here: how to identify a po as an object?
        //in this method, we have to know what kind of po is so that we can call different methods
        //temporary solution::
        //1. create a general userPO
        //2. directly decoding the Object po so that the actual type is accessible
        //same conundrums as below
        //3. add an, maybe repeatedly, id into the parameter list.
        System.out.println("adding successfully!");
        return ResultMessage.success;
    }

    @Override
    public Object find(String id) throws RemoteException {
        if(id.equals("0000")){
            System.out.println("a customer found");
            return new CustomerPO();
        }else if(id.equals("0001")){
            System.out.println("a staff found");
            return new StaffPO();
        }else if(id.equals("0002")){
            System.out.println("a web marketer found");
            return new WebMarketerPO();
        }else if(id.equals("0003")){
            System.out.println("a web manager found");
            return new WebManagerPO();
        }
        System.out.println("find unsuccessfully");
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage delete(Object po) throws RemoteException {
        System.out.println("delete successfully");
        return ResultMessage.success;
    }

    @Override
    public ResultMessage update(Object po) throws RemoteException {
        System.out.println("update successfully");
        return ResultMessage.success;
    }

    @Override
    public ResultMessage login(String id, String pwd) throws RemoteException {
        if(id.equals(pwd)) {
            if(id.equals("0000")){
                System.out.println("a customer logged in");
            }else if(id.equals("0001")){
                System.out.println("a staff logged in");
            }else if(id.equals("0002")){
                System.out.println("a web marketer logged in");
            }else if(id.equals("0003")){
                System.out.println("a web manager logged in");
            }
            return ResultMessage.success;
        }
        else{
            System.out.println("login unsuccessfully");
            return ResultMessage.failure;
        }
    }

    @Override
    public ResultMessage signup(Object po) throws RemoteException {
        //the processes of checking and DB operation are ignored
        System.out.println("signup successfully");
        return ResultMessage.success;
    }
}
