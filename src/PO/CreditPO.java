package PO;

import java.io.Serializable;

public class CreditPO implements Serializable{
	long value;
	CreditRecordPO creditRecord;
	
	
	public CreditPO(int v,CreditRecordPO cR){
		value=v;
		creditRecord=cR;
	}


	public long getValue() {
		return value;
	}


	public void setValue(long value) {
		this.value = value;
	}


	public CreditRecordPO getCreditRecord() {
		return creditRecord;
	}


	public void setCreditRecord(CreditRecordPO creditRecord) {
		this.creditRecord = creditRecord;
	}

	
	
}
