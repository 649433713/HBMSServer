package PO;

import java.io.Serializable;

public class CreditRecordPO implements Serializable{
	String changeType;
	String reasonType;
	Long amount;
	public CreditRecordPO(String cT,String rT,Long a){
		changeType=cT;
		reasonType=rT;
		amount=a;
	}
	public String getChangeType() {
		return changeType;
	}
	public void setChangeType(String changeType) {
		this.changeType = changeType;
	}
	public String getReasonType() {
		return reasonType;
	}
	public void setReasonType(String reasonType) {
		this.reasonType = reasonType;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
}
