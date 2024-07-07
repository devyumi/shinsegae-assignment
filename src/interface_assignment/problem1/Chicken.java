package interface_assignment.problem1;

public class Chicken extends Animal implements Cheatable {

  public Chicken(int speed) {
    super(speed);
  }

  @Override
  void run(int hours) {
    setDistance(this.getSpeed() * hours);
  }

  @Override
  public void fly() {
    setDistance(this.getSpeed() * 2);
  }
}
