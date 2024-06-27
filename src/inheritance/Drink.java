package inheritance;

public class Drink {
  String name;
  int price;
  int count;

  public Drink(String name, int price, int count) {
    this.name = name;
    this.price = price;
    this.count = count;
  }

  public int getTotalPrice() {
    return price * count;
  }

  public static void printTitle() {
    System.out.printf("%s%8s%10s%6s\n", "상품명", "단가", "수량", "금액");
  }

  public void printData() {
    System.out.printf("%s%10d%10d%10d\n", name, price, count, price * count);
  }
}
