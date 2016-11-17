package dataHelper;
import po.UserPO;

import java.util.Map;

/**
 * Created by alex on 16-11-6.
 */
public interface UserDataHelper {
    public Map<Integer, UserPO> getUserData();
    public void updateUserData(Map<Integer, UserPO> map);
}
