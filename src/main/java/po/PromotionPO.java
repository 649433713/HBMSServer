package po;
import model.PromotionType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * Created by alex on 16-11-17.
 */
public class PromotionPO implements Serializable{
    private static final long serialVersionUID = -3063228490603502682L;
    int promotionID;
    PromotionType promotionType;
    int region;
    String name;
    String content;
    Date startDate;
    Date endDate;
    int minRankAvailable;
    int maxRankAvailalbe;

    //two types of promotions share the same member, so one constructor is ok
    public PromotionPO(int promotionID, PromotionType promotionType, int region, String name, String content, Date startDate, Date endDate, int minRankAvailable, int maxRankAvailalbe) {
        this.promotionID = promotionID;
        this.promotionType = promotionType;
        this.region = region;
        this.name = name;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minRankAvailable = minRankAvailable;
        this.maxRankAvailalbe = maxRankAvailalbe;
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

    public int getMaxRankAvailalbe() {
        return maxRankAvailalbe;
    }
}
