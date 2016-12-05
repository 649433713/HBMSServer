package dao;

import message.ResultMessage;
import po.UserPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by alex on 16-11-6.
 */

public interface UserDao extends Remote{
    public UserPO getUserData(String id) throws  RemoteException;
    public ResultMessage addUser(UserPO po) throws RemoteException,Exception;
    public ResultMessage deleteUser(String id) throws RemoteException,Exception;
    public ResultMessage modifyUser(UserPO po) throws RemoteException,Exception;
    public ResultMessage login(String id, String pwd) throws RemoteException;
    public ResultMessage signup(UserPO po) throws RemoteException,Exception;

}
