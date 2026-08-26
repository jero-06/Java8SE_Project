package test.workshop.account.control;

import test.workshop.accout.entity.AccountII;

public class AccountTestII {
	public static void main(String[] args) {
		AccountII accountII1 = new AccountII();
		
		
		accountII1.setCustId("A1100");
		accountII1.setAcctId("221-22-3477");
		accountII1.deposit(100000);
		
		System.out.println("고객번호="+ accountII1.getCustId());
		System.out.println("계좌번호="+ accountII1.getAcctId());
		System.out.println("잔액="+ accountII1.getBalance());
		
		AccountII accountII2 = new AccountII();
		accountII2.withdraw(1000);
		System.out.println(accountII2.toString());
	}
	

}
