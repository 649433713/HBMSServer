package daoImpl;

import java.rmi.RemoteException;

import PO.CreditPO;
import dao.CreditDao;

public class CreditDaoImpl_Stub implements CreditDao{
	private int creditValue;
	@Override
	public void showCredit() throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("Show Credit Success");
	}

	@Override
	public void showCreditRecord() throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("Show CreditRecord Success");
	}

	@Override
	public boolean addCredit(int creditValue) throws RemoteException {
		// TODO 自动生成的方法存根
		this.creditValue=this.creditValue+creditValue;
		System.out.println("Add creditValue Success");
		return true;
	}

	@Override
	public boolean resumeCredit(CreditPO credit) throws RemoteException {
		// TODO 自动生成的方法存根
		System.out.println("Resume Credit Success");
		return false;
	}

	@Override
	public int getCreditValue(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		if(id=="0001"){
			System.out.println("Get CreditValue Success");
			return creditValue;
		}
		return 0;
	}

	@Override
	public int setCreditValue(String id, int value) throws RemoteException {
		// TODO 自动生成的方法存根
		this.creditValue=value;
		System.out.println("Set CreditValue Success");
		return creditValue;
	}

	@Override
	public String getChangeType(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		if(id=="0001"){
			System.out.println("Get ChangeType Success");
		}
		return null;
	}

	@Override
	public String getReasonType(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		if(id=="0001"){
			System.out.println("Get ReasonType Success");
		}
		return null;
	}

	@Override
	public String getAccount(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		if(id=="0001"){
			System.out.println("Get Account Success");
		}
		return null;
	}

}
