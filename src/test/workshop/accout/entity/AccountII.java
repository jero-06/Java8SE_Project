package test.workshop.accout.entity;

public class AccountII {
	private String custId;
	private String acctId;
	private int balance;
	
	//값을 조회하는 메서드
	public String getCustId() {
		return this.custId;
	}
	
	//값을 변경하는 메서드
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
	public String getAcctId() {
		return this.acctId;
	}
	
	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	//입금만큼 증가하는 balance 메서드
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	//출금만큼 감소하는 balance 메서드
	public void withdraw(int amount) {
		this.balance -= amount;
	}

}
