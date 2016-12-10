package testDataHelper;

import dao.UserDao;
import daoImpl.UserDaoImpl;
import dataHelperImpl.DBUtil_Alex;
import message.ResultMessage;
import model.MemberType;
import model.UserType;
import po.UserPO;

import java.io.File;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by alex on 12/10/16.
 */
public class test_Alex {
    static void addUser()throws Exception{
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
        String time;
        Date date=simpleDateFormat.parse("1996-9-30");
        time=simpleDateFormat.format(date);
        File image=new File("/home/alex/Pictures/admin.png");
        System.out.println(time);
        UserPO userPOTest=new UserPO(0, UserType.Customer,"alex2097","123","Alex Yu","13818052097",image,100, MemberType.Person,time,0,null,1);
        UserDao userDao=new UserDaoImpl();
        ResultMessage message;
        message=userDao.addUser(userPOTest);
        if(message.equals(ResultMessage.failure))System.out.println("failed to add a user");
        else System.out.println("add a user successfully");
    }

    static void deleteUser(int i) throws Exception{
        UserDao userDao=new UserDaoImpl();
        ResultMessage message=userDao.deleteUser(i);
    }

    static void modifyUser() throws Exception{
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
        String time;
        Date date=simpleDateFormat.parse("1996-9-30");
        time=simpleDateFormat.format(date);
        File image=new File("/home/alex/Pictures/test.jpg");

        UserPO userPOTest=new UserPO(2, UserType.Customer,"alex2097","151250187","Alex Yu","15951923079",image,800, MemberType.Person,time,0,null,3);
        UserDao userDao=new UserDaoImpl();
        ResultMessage message=userDao.modifyUser(userPOTest);
    }

    static void getUser(int id)throws Exception{
        UserDao userDao=new UserDaoImpl();
        UserPO userPO=userDao.getUserData(id);
        System.out.println(userPO.getAccountName());
    }

    static void getUser(String accountName)throws Exception{
        UserDao userDao=new UserDaoImpl();
        UserPO userPO=userDao.getUserData(accountName);
        System.out.println(userPO.getUserID());
    }

    public static void main(String args[]) throws Exception{
        Connection connection= DBUtil_Alex.getConnection();
        Statement statement=connection.createStatement();
        statement.execute("ALTER TABLE hbmsdatabase.user AUTO_INCREMENT = 1");
        //deleteUser(2);
        //addUser();
        getUser(1);
        //getUser("alex2097");
        //modifyUser();
    }
}
