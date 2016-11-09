package PO;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HotelPromotionPO implements Serializable{
	String name;
	String content;
	Date startDate;
	Date endDate;
	List<Integer> rankAvailable;
	
	public HotelPromotionPO(String hN,String c,
			Date s,Date e,List<Integer> rA){
		name=hN;
		content=c;
		startDate=s;
		endDate=e;
		rankAvailable=rA;
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

	public List<Integer> getRankAvailable() {
		return rankAvailable;
	}

	public void setRankAvailable(List<Integer> rankAvailable) {
		this.rankAvailable = rankAvailable;
	}

	
	
}
