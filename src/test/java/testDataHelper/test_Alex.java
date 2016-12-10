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
    private static SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
    public static void main(String args[]) throws Exception{
        Connection connection= DBUtil_Alex.getConnection();
        Statement statement=connection.createStatement();
        statement.execute("ALTER TABLE hbmsdatabase.user AUTO_INCREMENT = 1");
        //deleteUser(2);
        addUser();
    }

    static void addUser()throws Exception{
        File image=new File("/home/alex/Pictures/test2.png");
        Date date=format1.parse("1996-09-30");
        UserPO userPOTest=new UserPO(0, UserType.Customer,"alex2097","123","Alex Yu","13818052097",image,100, MemberType.Person,format1.format(date),0,null,0);
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
}
