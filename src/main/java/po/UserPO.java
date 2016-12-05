package po;
import model.MemberType;

import java.awt.*;
import java.io.Serializable;
/**
 * Created by alex on 16-11-17.
 */
public class UserPO implements Serializable{
    String userID;
    String accountName;
    String password;
    String name;
    String contact;
    Image portrait;
    long creditValue;
    MemberType memberType;
    String memberInfo;
    int rank;
    String workid;
    int hotelid;
    //constructors for allPO
    public UserPO(String id){
        this.userID=id;
    }

    public UserPO(String userID, String accountName, String password, String name
            , String contact, Image portrait, long creditValue
            , MemberType memberType, String memberInfo, int rank
            , String workid, int hotelid) {
        this.userID = userID;
        this.accountName = accountName;
        this.password = password;
        this.name = name;
        this.contact = contact;
        this.portrait = portrait;
        this.creditValue = creditValue;
        this.memberType = memberType;
        this.memberInfo = memberInfo;
        this.rank = rank;
        this.workid = workid;
        this.hotelid = hotelid;
    }

    //constructors for customerPO
    public UserPO(String id,String pwd,String name,String contact,
                  Image image,long creditValue,MemberType memberType,String memberInfo,int rank){
        this.userID=id;
        this.password=pwd;
        this.accountName=name;
        this.contact=contact;
        this.portrait=image;
        this.creditValue=creditValue;
        this.memberInfo=memberInfo;
        this.memberType=memberType;
        this.rank=rank;
    }

    //constructors for StaffPO
    public UserPO(String id,String pwd,String name,String contact,Image image,String workid,int hotelid){
        this.userID=id;
        this.password=pwd;
        this.accountName=name;
        this.contact=contact;
        this.portrait=image;
        this.workid=workid;
        this.hotelid=hotelid;
    }

    //constructors for WebMarketerPO and WebManagerPO
    public UserPO(String id,String pwd,String name,String contact,Image image){
        this.userID=id;
        this.password=pwd;
        this.accountName=name;
        this.contact=contact;
        this.portrait=image;
    }

    //getters
    public String getUserID() {
        return userID;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public Image getPortrait() {
        return portrait;
    }

    public long getCreditValue() {
        return creditValue;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public String getMemberInfo() {
        return memberInfo;
    }

    public int getRank() {
        return rank;
    }

    public String getWorkid() {
        return workid;
    }

    public int getHotelid() {
        return hotelid;
    }
}
