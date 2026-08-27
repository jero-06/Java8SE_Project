package mylab.bank.entity;

// 저축 계좌
public class SavingsAccount extends Account {
    private double interestRate; // 이자율 (%)

    public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
        super(accountNumber, ownerName, balance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    // 이자 적용 메서드
    public void applyInterest() {
        double interest = balance * (interestRate / 100.0);
        balance += interest;
        System.out.println(String.format("이자 %.1f원이 적용되었습니다. 현재 잔액: %.1f원", interest, balance));
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", 이자율: %.1f%%", interestRate);
    }
}