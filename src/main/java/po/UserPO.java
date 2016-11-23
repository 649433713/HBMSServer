package po;
import java.io.Serializable;
/**
 * Created by alex on 16-11-17.
 */
public class UserPO implements Serializable{
    //shared
    String id;
    String password;
    PersonalInfoPO personalInfo;
    //for customers
    CreditPO creditInfo;
    MemberInfoPO memberInfo;
    //for staffs
    String workid;
    String hotelid;
    //for web marketers and web managers: shared ones are enough
    //constructors for allPO
    public UserPO(String id){
        this.id=id;
    }

    //constructors for customerPO
    public UserPO(String id,String pwd,PersonalInfoPO personalInfo,CreditPO creditInfo
            ,MemberInfoPO memberInfo){
        this.id=id;
        this.password=pwd;
        this.personalInfo=personalInfo;
        this.creditInfo=creditInfo;
        this.memberInfo=memberInfo;
    }

    //constructors for StaffPO
    public UserPO(String id,String pwd,PersonalInfoPO personalInfo,CreditPO creditInfo
            ,MemberInfoPO memberInfo,String workid,String hotelid){
        this.id=id;
        this.password=pwd;
        this.personalInfo=personalInfo;
        this.creditInfo=creditInfo;
        this.memberInfo=memberInfo;
        this.workid=workid;
        this.hotelid=hotelid;
    }

    //constructors for WebMarketerPO and WebManagerPO
    public UserPO(String id,String pwd,PersonalInfoPO personalInfo){
        this.id=id;
        this.password=pwd;
        this.personalInfo=personalInfo;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public PersonalInfoPO getPersonalInfo() {
        return personalInfo;
    }

    public CreditPO getCreditInfo() {
        return creditInfo;
    }

    public MemberInfoPO getMemberInfo(){
        return memberInfo;
    }

    public String getWorkid() {
        return workid;
    }

    public String getHotelid() {
        return hotelid;
    }
}
