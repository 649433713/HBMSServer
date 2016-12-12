package daoImpl;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import dao.PromotionDao;
import dataHelper.DataFactory;
import dataHelper.PromotionDataHelper;
import dataHelperImpl.DBUtil_Alex;
import dataHelperImpl.DataFactoryImpl;
import message.ResultMessage;
import model.PromotionFilter;
import po.PromotionPO;

public class PromotionDaoImpl implements PromotionDao{
	Connection connection;
	private static PromotionPO promotionPO;
	private static PromotionDaoImpl promotionDaoImpl;
	private static DataFactory dataFactory;
	private static PromotionDataHelper promotionDataHelper;

	public PromotionDaoImpl() {
		if(promotionPO==null){
			dataFactory=new DataFactoryImpl();
			promotionDataHelper=dataFactory.getPromotionDataHelper();
			connection= DBUtil_Alex.getConnection();
		}
	}

	public static PromotionDaoImpl getInstance(){
		if(promotionDaoImpl==null){
			promotionDaoImpl=new PromotionDaoImpl();
		}
		return promotionDaoImpl;
	}


	@Override
	public Map<Integer, PromotionPO> getPromotionList(PromotionFilter promotionFilter) throws Exception {
		return promotionDataHelper.getPromotionList(promotionFilter);
	}

	@Override
	public ResultMessage addPromotion(PromotionPO po) throws Exception {
		return promotionDataHelper.addPromotion(po);
	}

	@Override
	public ResultMessage updatePromotion(PromotionPO po) throws Exception {
		return promotionDataHelper.updatePromotion(po);
	}
}
