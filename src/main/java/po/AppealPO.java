package po;

import java.io.Serializable;
import java.util.Date;

public class AppealPO implements Serializable{
	Date time;
	WebMarketerAccountPO webMarketerAccountPO;
	String explanation;
	String state;
	OrderPO order;
	
	public AppealPO(Date t,WebMarketerAccountPO wMA,String e,
			String s,OrderPO o){
		time=t;
		webMarketerAccountPO=wMA;
		explanation=e;
		state=s;
		order=o;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public WebMarketerAccountPO getWebMarketerAccountPO() {
		return webMarketerAccountPO;
	}

	public void setWebMarketerAccountPO(WebMarketerAccountPO webMarketerAccountPO) {
		this.webMarketerAccountPO = webMarketerAccountPO;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public OrderPO getOrder() {
		return order;
	}

	public void setOrder(OrderPO order) {
		this.order = order;
	}

	
}
