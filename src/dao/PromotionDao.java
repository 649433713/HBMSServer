package dao;

import java.rmi.Remote;
import java.util.ArrayList;

import PO.HotelPromotionPO;
import PO.WebPromotionPO;
import message.ResultMessage;



public interface PromotionDao extends Remote{
	public void showPromotion();
	
	public void showPromotionList();
	
	public boolean addPromotion(WebPromotionPO po);
	
	public boolean addPromotion(HotelPromotionPO po);
	
	public boolean deletePromotion(String ID);
	
	public boolean modify(HotelPromotionPO hotelPromotionPO);
	 
	public boolean modify(WebPromotionPO webPromotionPO);
	
	public HotelPromotionPO getHotelPromotionPO();
	 
	public WebPromotionPO getWebPromotionPO();
	 
	public WebPromotionPO showWebPromotion();
	
	public ArrayList<WebPromotionPO> showWebPromotionList();
	 
	public HotelPromotionPO showHotelPromotion();
	 
	public ArrayList<HotelPromotionPO> showHotelPromotionList();
	 
	public ResultMessage addHotelPromotion(HotelPromotionPO po);
	 
	public ResultMessage modifyHotelPromotion(HotelPromotionPO po);
	 
	public ResultMessage addWebPromotion(WebPromotionPO po);
	 
	public ResultMessage modifyWebPromotion(WebPromotionPO po);
	
}
