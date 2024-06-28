package inheritance.exercise;

public class CheckingAccount extends Account {
  private String cardNo;

  public CheckingAccount(String accId, String ownerName, long balance, String cardNo) {
    super(accId, ownerName, balance);
    this.cardNo = cardNo;
  }

  public String getCardNo() {
    return cardNo;
  }

  public void setCardNo(String cardNo) {
    this.cardNo = cardNo;
  }

  //클래스 다이어그램을 만족하는 메서드 (하지만 매개변수 순서가 달라서 TestAccount에서 사용하지 않음)
  public void pay(long amount, String cardNo) {

  }

  //TestAccount에서 실제로 사용하는 메서드
  public void pay(String cardNo, long amount) {
    if (this.cardNo == cardNo) {
      if (amount < getBalance()) {
        setBalance(getBalance() - amount);
        return;
      }
    }
    System.out.println("지불이 불가능합니다.");
  }

  @Override
  public void calcRate() {

  }
}
