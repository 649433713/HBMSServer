package driver;

import java.util.Date;

import PO.HotelPromotionPO;
import PO.WebPromotionPO;
import dao.PromotionDao;

public class PromotionDataService_Driver {
	Date startdate=new Date();
	Date enddate=new Date();
	private WebPromotionPO webPromotionPO=new WebPromotionPO("discount", "Singles'Day", null, startdate, enddate, null, null);
	
	public void driver(PromotionDao promotionDao){
		promotionDao.showPromotion();
		promotionDao.showPromotionList();
		promotionDao.addPromotion(webPromotionPO);
		promotionDao.addHotelPromotion(new HotelPromotionPO("xianlin hotel", null, new Date(), new Date(), null));
		promotionDao.deletePromotion("0001");
		promotionDao.modify(new HotelPromotionPO("xianlin hotel", null, new Date(), new Date(), null));
		promotionDao.modify(webPromotionPO);
		promotionDao.getHotelPromotionPO();
		promotionDao.getWebPromotionPO();
		promotionDao.showWebPromotion();
		promotionDao.showWebPromotionList();
		promotionDao.showHotelPromotion();
		promotionDao.showHotelPromotionList();
		promotionDao.addHotelPromotion(new HotelPromotionPO("xianlin hotel", null, new Date(), new Date(), null));
		promotionDao.modifyHotelPromotion(new HotelPromotionPO("xianlin hotel", null, new Date(), new Date(), null));
		promotionDao.addWebPromotion(webPromotionPO);
		promotionDao.modify(webPromotionPO);
	}
}
