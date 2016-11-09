package dao;

import message.ResultMessage;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by alex on 16-11-6.
 */

public interface UserDao extends Remote{
    public ArrayList<Object> getUserList() throws  RemoteException;
    public ResultMessage add(Object po) throws RemoteException;
    public Object find(String id) throws RemoteException;
    public ResultMessage delete(Object po) throws RemoteException;
    public ResultMessage update(Object po) throws RemoteException;
    public ResultMessage login(String id, String pwd) throws RemoteException;
    public ResultMessage signup(Object po) throws RemoteException;
}
