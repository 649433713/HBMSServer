package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class WebPromotionPO implements Serializable{
	String type;
	String name;
	String content;
	Date startDate;
	Date endDate;
	List<Integer> rankAvailableList;
	List<String> regionAvailableList;
	
	public WebPromotionPO(String p,String n,String c,
			Date s,Date e,List<Integer> rA,List<String> rAL){
		type=p;
		name=n;
		content=c;
		startDate=s;
		endDate=e;
		rankAvailableList=rA;
		regionAvailableList=rAL;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Integer> getRankAvailableList() {
		return rankAvailableList;
	}

	public void setRankAvailableList(List<Integer> rankAvailableList) {
		this.rankAvailableList = rankAvailableList;
	}

	public List<String> getRegionAvailableList() {
		return regionAvailableList;
	}

	public void setRegionAvailableList(List<String> regionAvailableList) {
		this.regionAvailableList = regionAvailableList;
	}

	
	
}
