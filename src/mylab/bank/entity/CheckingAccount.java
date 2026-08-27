package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

// 체킹
public class CheckingAccount extends Account {
    private double withdrawalLimit; // 출금 한도

    public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
        super(accountNumber, ownerName, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public double getWithdrawalLimit() {
        return withdrawalLimit;
    }

    // 출금 메서드 재정의 (한도 초과 검사 추가)
    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > withdrawalLimit) {
            throw new WithdrawalLimitExceededException(
                String.format("출금 한도를 초과했습니다. 한도: %.1f원", withdrawalLimit)
            );
        }
        super.withdraw(amount);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", 출금 한도: %.1f원", withdrawalLimit);
    }
}