package polymorphism.problem2;

public class Tea extends Beverage {
  private static int amount;

  public Tea(String name) {
    super(name);
    Tea.amount++;
  }

  public static int getAmount() {
    return Tea.amount;
  }

  public static void setAmount(int amount) {
    Tea.amount = amount;
  }

  @Override
  void calcPrice() {
    if(getName().equals("lemonTea")) {
      setPrice(1500);
    } else if(getName().equals("ginsengTea")) {
      setPrice(2000);
    } else if (getName().equals("redginsengTea")) {
      setPrice(2500);
    }
  }
}
