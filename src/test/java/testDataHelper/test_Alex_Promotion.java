package testDataHelper;

import dao.PromotionDao;
import daoImpl.PromotionDaoImpl;
import dataHelperImpl.DBUtil_Alex;
import model.DiscountTypeHelper;
import model.PromotionType;
import po.PromotionPO;

import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alex on 12/13/16.
 */
public class test_Alex_Promotion {

    static void reestablishment()throws Exception{
        Connection connection= DBUtil_Alex.getConnection();
        Statement statement=connection.createStatement();
        ///*
        statement.execute("DELETE FROM hbmsdatabase.promotion");
        //*/
        statement.execute("ALTER TABLE hbmsdatabase.promotion AUTO_INCREMENT = 1");
        //*/
    }

    static void addPromotion(PromotionPO po)throws Exception{
        PromotionDao promotionDao=new PromotionDaoImpl();
        System.out.println(promotionDao.addPromotion(po));
    }

    public static void main(String args[])throws Exception{
        reestablishment();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        DiscountTypeHelper discountTypeHelper=new DiscountTypeHelper();
        Date date1=simpleDateFormat.parse("2017-11-11");
        Date date2=simpleDateFormat.parse("2017-11-15");
        PromotionPO po1=new PromotionPO(0,PromotionType.HotelPromotion,2,"double 11 promotion","all 50% off!!!",date1,date2,1,10,discountTypeHelper.getDiscountType(1),0,50);
        date1=simpleDateFormat.parse("2017-12-10");
        date2=simpleDateFormat.parse("2017-12-14");
        PromotionPO po2=new PromotionPO(0,PromotionType.HotelPromotion,3,"双十二慢减特惠","满500减１５０",date1,date2,3,10,discountTypeHelper.getDiscountType(0),500,150);
        addPromotion(po1);
        //addPromotion(po2);
    }
}
