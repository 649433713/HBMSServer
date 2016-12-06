package driver;

import dao.CreditDao;

public class CreditDataService_Driver {
	public void driver(CreditDao creditDataService){
		try {
			creditDataService.showCreditRecord();
			creditDataService.showCredit();
			creditDataService.addCredit(1000);
			creditDataService.resumeCredit(new CreditPO(1000,null));
			creditDataService.getCreditValue("0001");
			creditDataService.setCreditValue("0001", 1000);
			creditDataService.getChangeType("0001");
			creditDataService.getReasonType("0001");
			creditDataService.getAccount("0001");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
