package dataHelper;
import java.util.Map;

import po.CustomerPO;
import po.StaffPO;
import po.WebManagerPO;
import po.WebMarketerPO;

/**
 * Created by alex on 16-11-6.
 */
public interface UserDataHelper {
    public Map<Integer, Object> getUserData();
    public void updateUserData(Map<Integer,Object> map);
}
