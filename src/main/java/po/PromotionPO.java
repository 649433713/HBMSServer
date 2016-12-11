package po;
import model.PromotionType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * Created by alex on 16-11-17.
 */
public class PromotionPO implements Serializable{
    //shared
    int promotionID;
    PromotionType promotionType;
    String name;
    String type;
    String content;
    Date startDate;
    Date endDate;
    List<Integer> rankAvailable;
    //for hotel promotion
    List<String> regionAvailable;
    //for web promotion


    //constructors for all PromotionPO
    public PromotionPO(String id){
        this.id=id;
    }

    //constructors for hotel promotions
    public PromotionPO(String id,String hotelPromotionName,String type,String content,
                       Date startDate,Date endDate,List<Integer> ranks){
        this.id=id;
        this.name=hotelPromotionName;
        this.type=type;
        this.content=content;
        this.startDate=startDate;
        this.endDate=endDate;
        this.rankAvailable=ranks;
    }

    public PromotionPO(String hotelName,String content){
        this.name=hotelName;
        this.content=content;
    }

    //constructors for web promotions
    public PromotionPO(String id,String webPromotionName,String type,String content,
                       Date startDate,Date endDate,List<Integer> ranks,List<String> regionAvailable){
        this.id=id;
        this.name=webPromotionName;
        this.type=type;
        this.content=content;
        this.startDate=startDate;
        this.endDate=endDate;
        this.rankAvailable=ranks;
        this.regionAvailable=regionAvailable;
    }


}
