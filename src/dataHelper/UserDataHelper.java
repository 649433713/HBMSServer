package dataHelper;
import java.util.Map;

import PO.CustomerPO;
import PO.StaffPO;
import PO.WebManagerPO;
import PO.WebMarketerPO;

/**
 * Created by alex on 16-11-6.
 */
public interface UserDataHelper {
    public Map<Integer, Object> getUserData();
    public void updateUserData(Map<Integer,Object> map);
}
