package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class Bank {
    private List<Account> accounts;
    private int nextAccountNumber;

    public Bank() {
        this.accounts = new ArrayList<>();
        this.nextAccountNumber = 1000; // AC1000부터 시작
    }

    // 저축 계좌 생성
    public String createSavingsAccount(String ownerName, double balance, double interestRate) {
        String accNum = "AC" + nextAccountNumber++;
        SavingsAccount acc = new SavingsAccount(accNum, ownerName, balance, interestRate);
        accounts.add(acc);
        System.out.println("Saving(저축) 계좌가 생성되었습니다: " + acc);
        return accNum;
    }

    // 체킹 계좌 생성
    public String createCheckingAccount(String ownerName, double balance, double withdrawalLimit) {
        String accNum = "AC" + nextAccountNumber++;
        CheckingAccount acc = new CheckingAccount(accNum, ownerName, balance, withdrawalLimit);
        accounts.add(acc);
        System.out.println("체킹 계좌가 생성되었습니다: " + acc);
        return accNum;
    }

    // 계좌 번호로 계좌 검색
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
    }

    // 입금
    public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
        Account acc = findAccount(accountNumber);
        acc.deposit(amount);
    }

    // 출금
    public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
        Account acc = findAccount(accountNumber);
        acc.withdraw(amount);
    }

    // 계좌 간 송금 (이체)
    public void transfer(String fromAccount, String toAccount, double amount) 
            throws AccountNotFoundException, InsufficientBalanceException {
        Account fromAcc = findAccount(fromAccount);
        Account toAcc = findAccount(toAccount);

        fromAcc.withdraw(amount);
        toAcc.deposit(amount);
        System.out.println(String.format("%.1f원이 %s에서 %s로 송금되었습니다.", amount, fromAccount, toAccount));
    }

    // 모든 계좌 정보 출력
    public void printAllAccounts() {
        System.out.println("=== 모든 계좌 목록 ===");
        for (Account acc : accounts) {
            System.out.println(acc);
        }
        System.out.println("===================");
    }
}