package inheritance;

public class Alcohol extends Drink {
  private double alcper;

  public Alcohol(String name, int price, int count, double alcper) {
    super(name, price, count);
    this.alcper = alcper;
  }

  public static void printTitle() {
    System.out.printf("%s(도수[%%])%4s%10s%8s\n", "상품명", "단가", "수량", "금액");
  }

  @Override
  public void printData() {
    System.out.printf("%s(%.1f)%10d%10d%10d\n", name, alcper, price, count, price * count);
  }
}
