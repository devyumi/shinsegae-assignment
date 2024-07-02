package polymorphism.problem2;

abstract class Beverage {
  private String name;
  private int price;

  public Beverage(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  abstract void calcPrice();

  public void print() {

  }
}
