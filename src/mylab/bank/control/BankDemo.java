package mylab.bank.control;

import mylab.bank.entity.Account;
import mylab.bank.entity.Bank;
import mylab.bank.entity.SavingsAccount;
import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

public class BankDemo {

    public static void main(String[] args) {
        Bank bank = new Bank();

        // 1. 계좌 생성 테스트
        System.out.println("=== 계좌 생성 ===");
        String acc1 = bank.createSavingsAccount("홍길동", 10000.0, 3.0);
        String acc2 = bank.createCheckingAccount("김철수", 20000.0, 5000.0);
        String acc3 = bank.createSavingsAccount("이영희", 30000.0, 2.0);
        System.out.println();

        // 2. 모든 계좌 목록 출력
        bank.printAllAccounts();
        System.out.println();

        // 3. 입금/출금 테스트
        System.out.println("=== 입금/출금 테스트 ===");
        try {
            bank.deposit(acc1, 5000.0);
            bank.withdraw(acc2, 3000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();

        // 4. 이자 적용 테스트
        System.out.println("=== 이자 적용 테스트 ===");
        try {
            Account account = bank.findAccount(acc1);
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).applyInterest();
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();

        // 5. 계좌 이체 테스트
        System.out.println("=== 계좌 이체 테스트 ===");
        try {
            bank.transfer(acc3, acc2, 5000.0);
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println();

        // 6. 변경된 모든 계좌 목록 출력
        bank.printAllAccounts();

        // 7. 예외 처리 테스트 (출금 한도 초과 및 존재하지 않는 계좌)
        try {
            bank.withdraw(acc2, 6000.0); // 한도(5000원) 초과 출금 시도
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.transfer(acc2, acc3, 6000.0); // 한도(5000원) 초과 이체 시도
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        try {
            bank.findAccount("AC9999"); // 존재하지 않는 계좌 조회
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}