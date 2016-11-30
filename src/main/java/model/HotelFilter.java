package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelFilter {

	List<Map<String, Object>> filter = new ArrayList<>();
	
	/*
	 * 
	 * Filter 中的 param 的name key，存储筛选的字段（name,address,region,star,score)
	 */
	public void add(String name ,String relation,String value) {
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
