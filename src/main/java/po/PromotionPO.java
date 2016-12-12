package po;
import model.DiscountType;
import model.PromotionType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * Created by alex on 16-11-17.
 */
public class PromotionPO implements Serializable{

    private static final long serialVersionUID = -9141885023401470037L;
    int promotionID;
    PromotionType promotionType;
    int region;
    String name;
    String content;
    Date startDate;
    Date endDate;
    int minRankAvailable;
    int maxRankAvailable;
    DiscountType type;
    int condition;
    int discount;


    public PromotionPO(int promotionID, PromotionType promotionType, int region, String name, String content, Date startDate, Date endDate, int minRankAvailable, int maxRankAvailable, DiscountType type, int condition, int discount) {
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.region = region;
        this.name = name;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minRankAvailable = minRankAvailable;
        this.maxRankAvailable = maxRankAvailable;
        this.type = type;
        this.condition = condition;
        this.discount = discount;
    }

    public int getPromotionID() {
        return promotionID;
    }

    public PromotionType getPromotionType() {
        return promotionType;
    }

    public int getRegion() {
        return region;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getMinRankAvailable() {
        return minRankAvailable;
    }

    public int getMaxRankAvailable() {
        return maxRankAvailable;
    }

    public DiscountType getType() {
        return type;
    }

    public int getCondition() {
        return condition;
    }

    public int getDiscount() {
        return discount;
    }
}
