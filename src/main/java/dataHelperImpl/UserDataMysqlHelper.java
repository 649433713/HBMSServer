package dataHelperImpl;

import dataHelper.UserDataHelper;
import message.ResultMessage;
import model.ImageHelper;
import model.MemberTypeHelper;
import model.UserType;
import model.UserTypeHelper;
import po.UserPO;

import java.io.File;
import java.sql.*;

/**
 * Created by alex on 12/4/16.
 */
public class UserDataMysqlHelper implements UserDataHelper {
    Connection connection;
    public UserDataMysqlHelper(){
        connection=DBUtil_Alex.getConnection();
    }

    @Override
    public UserPO getUserData(int id)throws Exception {
        ResultSet resultSet;
        UserTypeHelper userTypeHelper=new UserTypeHelper();
        MemberTypeHelper memberTypeHelper=new MemberTypeHelper();
        ImageHelper imageHelper=new ImageHelper();

        String sentence="select userID,userType," +
                "AES_DECRYPT(accountName,'innovator')," +
                "AES_DECRYPT(password,'innovator')," +
                "AES_DECRYPT(name,'innovator')," +
                "AES_DECRYPT(contact,'innovator')," +
                "portrait,creditValue,memberType,memberInfo," +
                "rank,workID,hotelID from user where userID='"+id+"'";
        PreparedStatement preparedStatement;
        UserPO userPO=null;
        try{
            preparedStatement = connection.prepareStatement(sentence);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            try {
                userPO = new UserPO(resultSet.getInt("userID")
                        , userTypeHelper.getUserType(resultSet.getInt("userType"))
                        , resultSet.getString("AES_DECRYPT(accountName,'innovator')")
                        , resultSet.getString("AES_DECRYPT(password,'innovator')")
                        , resultSet.getString("AES_DECRYPT(name,'innovator')")
                        , resultSet.getString("AES_DECRYPT(contact,'innovator')")
                        , new File(resultSet.getString("portrait"))
                        , resultSet.getLong("creditValue")
                        , memberTypeHelper.getMemberType(resultSet.getInt("memberType"))
                        , resultSet.getString("memberInfo")
                        , (resultSet.getInt("rank"))
                        , resultSet.getString("workID")
                        , resultSet.getInt("hotelID")
                );
            }catch(NullPointerException ne){
                userPO = new UserPO(resultSet.getInt("userID")
                        , userTypeHelper.getUserType(resultSet.getInt("userType"))
                        , resultSet.getString("AES_DECRYPT(accountName,'innovator')")
                        , resultSet.getString("AES_DECRYPT(password,'innovator')")
                        , resultSet.getString("AES_DECRYPT(name,'innovator')")
                        , resultSet.getString("AES_DECRYPT(contact,'innovator')")
                        , new File(imageHelper.getProjectPath()+"/res/0/admin.jpg")
                        , resultSet.getLong("creditValue")
                        , memberTypeHelper.getMemberType(resultSet.getInt("memberType"))
                        , resultSet.getString("memberInfo")
                        , 0
                        , resultSet.getString("workID")
                        , resultSet.getInt("hotelID")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return userPO;
    }

    @Override
    public UserPO getUserData(String accountName) throws Exception{
        UserTypeHelper userTypeHelper=new UserTypeHelper();
        MemberTypeHelper memberTypeHelper=new MemberTypeHelper();
        String sentence="select * from user where accountName='"+accountName+"'";
        PreparedStatement preparedStatement;
        UserPO userPO=null;
        try{
            preparedStatement = connection.prepareStatement(sentence);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            userPO=new UserPO(resultSet.getInt("userID")
                    ,userTypeHelper.getUserType(resultSet.getInt("userType"))
                    ,resultSet.getString("AES_DECRYPT(accountName,'innovator')")
                    ,resultSet.getString("AES_DECRYPT(password,'innovator')")
                    ,resultSet.getString("AES_DECRYPT(name,'innovator')")
                    ,resultSet.getString("AES_DECRYPT(contact,'innovator')")
                    ,new File(resultSet.getString("portrait"))
                    ,resultSet.getLong("creditValue")
                    ,memberTypeHelper.getMemberType(resultSet.getInt("memberType"))
                    ,resultSet.getString("memberInfo")
                    ,resultSet.getInt("rank")
                    ,resultSet.getString("workID")
                    ,resultSet.getInt("hotelID")
            );
        }catch(SQLException e){
            e.printStackTrace();
        }
        return userPO;


    }

    @Override
    public ResultMessage addUser(UserPO userPO) throws Exception{
        ImageHelper imageHelper=new ImageHelper();
        Statement statement=connection.createStatement();
        PreparedStatement preparedStatement;
        String key="innovator";
        String sql0="INSERT into user(userType,accountName,password,name,contact,creditValue,memberType,memberInfo,workID,hotelID)" +
                "VALUES ("  +userPO.getUserType().ordinal()+
                ","         +"AES_ENCRYPT('"+userPO.getAccountName()+"','"+key+"')"+
                ","         +"AES_ENCRYPT('"+userPO.getPassword()+"','"+key+"')"+
                ","         +"AES_ENCRYPT('"+userPO.getName()+"','"+key+"')"+
                ","         +"AES_ENCRYPT('"+userPO.getContact()+"','"+key+"')"+
                ","          +userPO.getCreditValue()+
                ","          +userPO.getMemberType().ordinal()+
                ","          +userPO.getMemberInfo()+
                ","          +userPO.getWorkid()+
                ","          +userPO.getHotelid()+
                ")";
        try{
            statement.execute(sql0);
        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.failure;
        }
        String sql2="select * from user where AES_DECRYPT(accountName,'"+key+"')='"+userPO.getAccountName()+"'";
        String sql3=""+
                " update user"+
                " set portrait=?"+
                " where userID=?";
        try{
            preparedStatement=connection.prepareStatement(sql2);
            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();
            int userID=resultSet.getInt("userID");
            //get the auto-created userID and create the folder to hold the portrait
            String portraitPath=imageHelper.makedir(userID)+"/portrait"+userID+".jpg";
            File image=userPO.getPortrait();
            imageHelper.saveImage(image,portraitPath);
            //add portrait path into usertable
            preparedStatement=connection.prepareStatement(sql3);
            preparedStatement.setString(1,portraitPath);
            preparedStatement.setInt(2,userID);
            preparedStatement.execute();
        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.failure;
        }

        return ResultMessage.success;
    }

    @Override
    public ResultMessage deleteUser(int id) throws Exception{
        ImageHelper imageHelper=new ImageHelper();
        //remind that when deleting a user, the portrait info(both image and its path) should be deleted
        String sql="" + " Select * from user" + " where userID =? ";
        String sql2 = "" + "delete from user where userID = ?";
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                return ResultMessage.notexist;
            }
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            imageHelper.deldir(imageHelper.getdir(id));
            //delete the image folder

        }catch(SQLException e){
            e.printStackTrace();
            return ResultMessage.failure;
        }
        return ResultMessage.success;
    }

    @Override
    public ResultMessage modifyUser(UserPO userPO) throws Exception{
        ImageHelper imageHelper=new ImageHelper();
        int userID=userPO.getUserID();
        String sql = ""+
                " update user"+
                " set userID=?,userType=?,accountName=AES_ENCRYPT(?,'innovator'),password=AES_ENCRYPT(?,'innovator'),name=AES_ENCRYPT(?,'innovator'),"+
                " contact=AES_ENCRYPT(?,'innovator'),portrait=?,creditValue=?,memberType=?," +
                "memberInfo=?,hotelID=?,workID=?"+
                " where userID=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,userID);
            preparedStatement.setInt(2,userPO.getUserType().ordinal());
            preparedStatement.setString(3,userPO.getAccountName());
            preparedStatement.setString(4,userPO.getPassword());
            preparedStatement.setString(5,userPO.getName());
            preparedStatement.setString(6,userPO.getContact());
            String portraitPath=imageHelper.makedir(userID)+"/portrait"+userID+".jpg";
            preparedStatement.setString(7,portraitPath);
            preparedStatement.setLong(8,userPO.getCreditValue());
            preparedStatement.setInt(9,userPO.getMemberType().ordinal());
            preparedStatement.setString(10,userPO.getMemberInfo());
            preparedStatement.setInt(11,userPO.getHotelid());
            preparedStatement.setString(12,userPO.getWorkid());
            preparedStatement.setInt(13,userID);
            preparedStatement.execute();
            File image=userPO.getPortrait();
            imageHelper.saveImage(image,portraitPath);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return ResultMessage.failure;
        }
        return ResultMessage.success;
    }
}
