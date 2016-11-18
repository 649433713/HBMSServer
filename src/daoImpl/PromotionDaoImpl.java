package daoImpl;

import java.util.ArrayList;

import PO.HotelPromotionPO;
import PO.WebPromotionPO;
import dao.PromotionDao;
import message.ResultMessage;

public class PromotionDaoImpl implements PromotionDao{
	
	private static PromotionDaoImpl promotionDaoImpl;
	
	public static PromotionDaoImpl getInstance(){
		if(promotionDaoImpl==null){
			promotionDaoImpl=new PromotionDaoImpl();
		}
		return promotionDaoImpl;
	}
	
	@Override
	public void showPromotion() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void showPromotionList() {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean addPromotion(WebPromotionPO po) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean addPromotion(HotelPromotionPO po) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean deletePromotion(String ID) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean modify(HotelPromotionPO hotelPromotionPO) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean modify(WebPromotionPO webPromotionPO) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public HotelPromotionPO getHotelPromotionPO() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public WebPromotionPO getWebPromotionPO() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public WebPromotionPO showWebPromotion() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<WebPromotionPO> showWebPromotionList() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public HotelPromotionPO showHotelPromotion() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ArrayList<HotelPromotionPO> showHotelPromotionList() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage addHotelPromotion(HotelPromotionPO po) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage modifyHotelPromotion(HotelPromotionPO po) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage addWebPromotion(WebPromotionPO po) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public ResultMessage modifyWebPromotion(WebPromotionPO po) {
		// TODO 自动生成的方法存根
		return null;
	}

}
