package test.class_test;

import java.util.Scanner;

public class BankApplication {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Account[] accounts = new Account[100];
    int cnt = -1;

    while (true) {
      printMenu("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
      System.out.print("선택> ");
      int selectedNumber = sc.nextInt();
      sc.nextLine();

      if (selectedNumber < 1 || selectedNumber > 5) {
        System.out.println("잘못된 접근입니다.");
        continue;
      }

      if (selectedNumber == 5) {
        System.out.print("프로그램 종료");
        break;
      }

      switch (selectedNumber) {
        case 1 -> {
          if (cnt == accounts.length - 1) {
            System.out.println("더 이상 계좌를 만들 수 없습니다.");
            break;
          }

          printMenu("계좌생성");
          System.out.print("계좌번호: ");
          String accountN = sc.nextLine();

          System.out.print("계좌주: ");
          String name = sc.nextLine();

          System.out.print("초기입금액: ");
          int balance = sc.nextInt();
          sc.nextLine();

          if (balance <= 0) {
            System.out.println("0원 이상 입금해야 합니다.");
          } else {
            System.out.println("결과: 계좌가 생성되었습니다.");
            accounts[++cnt] = new Account(accountN, name, balance);
          }
        }

        case 2 -> {
          printMenu("계좌목록");

          for (int i = 0; i <= cnt; i++) {
            System.out.printf("%s %10s %10d\n", accounts[i].getAccountN(), accounts[i].getName(),
                accounts[i].getBalance());
          }
        }

        case 3 -> {
          printMenu("예금");
          boolean check = false;

          System.out.print("계좌번호: ");
          String accountN = sc.nextLine();
          for (int i = 0; i <= cnt; i++) {
            if (accounts[i].getAccountN().equals(accountN)) {
              System.out.print("예금액: ");
              int money = sc.nextInt();
              sc.nextLine();
              check = accounts[i].deposit(money);
              break;
            }
          }

          if (check) {
            System.out.println("예금 성공");
          } else {
            System.out.println("예금 실패");
          }
        }

        case 4 -> {
          printMenu("출금");
          boolean check = false;

          System.out.print("계좌번호: ");
          String accountN = sc.nextLine();
          for (int i = 0; i <= cnt; i++) {
            if (accounts[i].getAccountN().equals(accountN)) {
              System.out.print("출금액: ");
              int money = sc.nextInt();
              sc.nextLine();
              check = accounts[i].withdraw(money);
              break;
            }
          }

          if (check) {
            System.out.println("출금 성공");
          } else {
            System.out.println("출금 실패");
          }
        }
      }
    }
  }

  private static void printMenu(String menu) {
    System.out.println("----------------------------------------------");
    System.out.println(menu);
    System.out.println("----------------------------------------------");
  }
}
