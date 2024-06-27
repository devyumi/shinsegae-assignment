package test.class_test;

public class Account {

  private String accountN;
  private String name;
  private int balance;
  private static final int MIN_BALANCE = 0;
  private static final int MAX_BALANCE = 1000000;

  public Account() {
  }

  public Account(String accountN, String name, int balance) {
    this.accountN = accountN;
    this.name = name;
    this.balance = balance;
  }

  public String getAccountN() {
    return accountN;
  }

  public String getName() {
    return name;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int money) {
    if (money >= MIN_BALANCE && money < MAX_BALANCE) {
      balance = money;
    }
  }

  public boolean deposit(int money) {
    if (money <= 0) {
      System.out.println("0원 이하는 입금할 수 없습니다.");
      return false;
    }
    balance += money;
    return true;
  }

  public boolean withdraw(int money) {
    if (money <= 0) {
      System.out.println("0원 이하는 출금할 수 없습니다.");
      return false;
    }
    if (balance - money < 0) {
      System.out.println("출금할 수 없습니다.");
      return false;
    }
    balance -= money;
    return true;
  }
}
