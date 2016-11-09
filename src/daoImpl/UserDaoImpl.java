package daoImpl;
import dataHelper.DataFactory;
import dataHelper.UserDataHelper;
import dataHelperImpl.DataFactoryImpl;
import PO.CustomerPO;
import PO.StaffPO;
import PO.WebMarketerPO;
import PO.WebManagerPO;
import dao.UserDao;
import message.ResultMessage;
import java.rmi.RemoteException;
import java.util.Map;
/**
 * Created by alex on 16-11-9.
 */
public class UserDaoImpl implements UserDao {
    private Map<Integer,Object> map;

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
    public ResultMessage add(Object po) throws RemoteException {
        return null;
    }

    @Override
    public Object find(String id) throws RemoteException {
        return null;
    }

    @Override
    public ResultMessage delete(Object po) throws RemoteException {
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage update(Object po) throws RemoteException {
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage login(String id, String pwd) throws RemoteException {
        return ResultMessage.failure;
    }

    @Override
    public ResultMessage signup(Object po) throws RemoteException {
        return ResultMessage.failure;
    }
}
