package daoImpl;
import dataHelper.DataFactory;
import dataHelper.UserDataHelper;
import dataHelperImpl.DataFactoryImpl;
import dao.UserDao;
import dataHelperImpl.UserDataTxtHelper;
import message.ResultMessage;
import model.UserType;
import model.UserTypeHelper;
import po.UserPO;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;
/**
 * Created by alex on 16-11-9.
 */
public class UserDaoImpl implements UserDao {
    private Map<Integer,UserPO> map;

    private static UserDaoImpl userDaoImpl;

    private DataFactory dataFactory;

    private UserDataHelper userDataHelper;

    public UserDaoImpl() {
        if(map==null){
            dataFactory=new DataFactoryImpl();
            userDataHelper=dataFactory.getUserDataHelper();
            map=userDataHelper.getUserData();
        }
    }

    public static UserDaoImpl getInstance(){
        if(userDaoImpl==null){
            userDaoImpl=new UserDaoImpl();
        }
        return userDaoImpl;
    }

    @Override
    public ArrayList<UserPO> getUserList() throws RemoteException {
        ArrayList<UserPO> userlist=new ArrayList<UserPO>();
        userlist.add(new UserPO("0000000000"));
        userlist.add(new UserPO("0100000000"));
        userlist.add(new UserPO("0200000000"));
        userlist.add(new UserPO("0300000000"));
        return userlist;
    }

    @Override
    public ResultMessage add(UserPO po) throws RemoteException {
        return null;
    }

    @Override
    public UserPO find(String id) throws RemoteException {
        return new UserPO(id);
    }

    @Override
    public ResultMessage delete(String id) throws RemoteException {
        UserTypeHelper userTypeHelper=new UserTypeHelper();
        if(userTypeHelper.getUserType(id).equals(UserType.NoSuchUser)){
            return ResultMessage.failure;
        }else{
            return ResultMessage.success;
        }
    }

    @Override
    public ResultMessage update(UserPO po) throws RemoteException {
        return ResultMessage.success;
    }

    @Override
    public ResultMessage login(String id, String pwd) throws RemoteException {
        return ResultMessage.success;
    }

    @Override
    public ResultMessage signup(UserPO po) throws RemoteException {
        return ResultMessage.success;
    }
}
