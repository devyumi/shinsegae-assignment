package interface_assignment.problem1;

abstract class Animal {
  private int speed;
  private double distance;

  public Animal(int speed) {
    this.speed = speed;
  }

  public int getSpeed() {
    return speed;
  }

  public double getDistance() {
    return distance;
  }

  public void setDistance(double distance) {
    this.distance = distance;
  }

  abstract void run(int hours);
}
