package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelFilter {

	public List<Map<String, Object>> filter = new ArrayList<>();
	
	/*
	 * 
	 * Filter �е� param ��name key���洢ɸѡ���ֶΣ�name,address,region,star,score)
	 */
	public void add(String name ,String relation,Object value) {
		Map<String, Object> param = new HashMap<>();
		param.put("name", name);
		param.put("relation", relation);
		param.put("value", value);
		
		filter.add(param);
	}
	public void del(String name) {
		for (int i = 0; i < filter.size(); i++) {
			Map<String, Object> param = filter.get(i);
			if (param.get("name").equals(name)) {
				filter.remove(i);
			}
		}
	}
}
