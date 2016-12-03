package dao;

import message.ResultMessage;
import po.UserPO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by alex on 16-11-6.
 */

public interface UserDao extends Remote{
    public ArrayList<UserPO> getUserList() throws  RemoteException;
    
    public ResultMessage add(UserPO po) throws RemoteException;
    
    public UserPO find(String id) throws RemoteException;
    
    public ResultMessage delete(String id) throws RemoteException;
    
    public ResultMessage update(UserPO po) throws RemoteException;
    
    public ResultMessage login(String id, String pwd) throws RemoteException;
    
    public ResultMessage signup(UserPO po) throws RemoteException;
}
