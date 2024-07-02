package polymorphism.problem2;

public class CoffeeShop {

  public static void main(String[] args) {
    System.out.println("****java nara CoffeeShop 영업개시****");
    Beverage[] beverage = new Beverage[5];
    beverage[0] = new Coffee("Cappuccino");
    beverage[1] = new Coffee("CafeLatte");
    beverage[2] = new Tea("ginsengTea");
    beverage[3] = new Coffee("CafeLatte");
    beverage[4] = new Tea("redginsengTea");
    getSalesInfo(beverage);

    System.out.println("총 판매 금액=>" + getTotalPrice(beverage));
    System.out.println("Coffee의 판매 개수=>" + Coffee.getAmount() + "잔");
    System.out.println("Tea의 판매 개수=>" + Tea.getAmount() + "잔");
  }

  private static int getTotalPrice(Beverage[] beverages) {
    int sum = 0;
    for (Beverage beverage : beverages) {
      sum += beverage.getPrice();
    }
    return sum;
  }

  private static void getSalesInfo(Beverage[] beverages) {
    for (int i = 0; i < beverages.length; i++) {
      beverages[i].calcPrice();
      System.out.printf("%d번째 판매음료는 %s이며, 가격은 %d\n", i + 1, beverages[i].getName(),
          beverages[i].getPrice());
    }
  }
}
