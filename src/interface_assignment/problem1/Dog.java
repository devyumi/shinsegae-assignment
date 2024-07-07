package interface_assignment.problem1;

public class Dog extends Animal {

  public Dog(int speed) {
    super(speed);
  }

  @Override
  void run(int hours) {
    setDistance(getSpeed() * (double) hours / 2);
  }
}
