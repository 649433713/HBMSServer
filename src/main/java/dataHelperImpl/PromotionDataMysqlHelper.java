package dataHelperImpl;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

import dataHelper.PromotionDataHelper;
import message.ResultMessage;
import model.DiscountTypeHelper;
import model.PromotionFilter;
import model.PromotionTypeHelper;
import po.PromotionPO;

public class PromotionDataMysqlHelper implements PromotionDataHelper{
	Connection connection;

	public PromotionDataMysqlHelper(){
		connection=DBUtil_Alex.getConnection();
	}

	@Override
	public Map<Integer, PromotionPO> getPromotionList(PromotionFilter promotionFilter)throws Exception {
		StringBuffer stringBuffer = new StringBuffer("select * from promotion where 1=1");
		//transfer filter to stringBuffer
		if(promotionFilter!=null&&promotionFilter.filter.size()>0){
			for(int i=0;i<promotionFilter.filter.size();i++){
				Map<String,Object> map=promotionFilter.filter.get(i);
				if(map.get("name").equals("startDate")){
					if(map.get("relation").equals("<")){
					    stringBuffer.append(" and DATEDIFF(startDate,'"+map.get("value")+"')<0");
                    }else{
                        stringBuffer.append(" and DATEDIFF(startDate,'"+map.get("value")+"')>0");
                    }
				}else if(map.get("name").equals("endDate")){
				    if(map.get("relation").equals("<")){
                        stringBuffer.append(" and DATEDIFF(endDate,'"+map.get("value")+"')<0");
                    }else{
                        stringBuffer.append(" and DATEDIFF(endDate,'"+map.get("value")+"')>0");
                    }

				}else{
					stringBuffer.append(" and "+map.get("name")+" "+map.get("relation"+" "+map.get("value")));
				}
			}
		}

		Map<Integer,PromotionPO> map=new LinkedHashMap<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(stringBuffer.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            PromotionTypeHelper promotionTypeHelper=new PromotionTypeHelper();
            DiscountTypeHelper discountTypeHelper=new DiscountTypeHelper();

            PromotionPO promotionPO;
            while (resultSet.next()){
                promotionPO=new PromotionPO(resultSet.getInt("promotionID")
                        ,promotionTypeHelper.getPromotionType(resultSet.getInt("promotionType"))
                        ,resultSet.getInt("region"),resultSet.getString("name")
                        ,resultSet.getString("content"),resultSet.getDate("startDate")
                        ,resultSet.getDate("endDate"),resultSet.getInt("minRankAvailable")
                        ,resultSet.getInt("maxRankAvailable")
                        ,discountTypeHelper.getDiscountType(resultSet.getInt("type"))
                        ,resultSet.getInt("condition")
                        ,resultSet.getInt("discount"));
                map.put(promotionPO.getPromotionID(),promotionPO);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
		return map;
	}

	@Override
	public ResultMessage addPromotion(PromotionPO po) throws Exception{
        Statement statement=connection.createStatement();



		return ResultMessage.success;
	}

	@Override
	public ResultMessage updatePromotion(PromotionPO po) throws Exception{
        Statement statement=connection.createStatement();



		return ResultMessage.success;
	}
}
