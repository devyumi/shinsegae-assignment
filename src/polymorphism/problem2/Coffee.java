package polymorphism.problem2;

public class Coffee extends Beverage {

  private static int amount;

  public Coffee(String name) {
    super(name);
    Coffee.amount++;
  }

  public static int getAmount() {
    return Coffee.amount;
  }

  public static void setAmount(int amount) {
    Coffee.amount = amount;
  }

  @Override
  void calcPrice() {
    if(getName().equals("Americano")) {
      setPrice(1500);
    } else if (getName().equals("CafeLatte")) {
      setPrice(2500);
    } else if (getName().equals("Cappuccino")) {
      setPrice(3000);
    }
  }
}
