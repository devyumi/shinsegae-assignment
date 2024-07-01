package polymorphism.assignment;

public class Bike extends Wheeler {

  public Bike(int velocity, String carName, int wheelNumber) {
    super(velocity, carName, wheelNumber);
  }

  @Override
  public void speedUp(int speed) {
    velocity += speed;
    if (velocity > 40) {
      velocity = 40;
      System.out.println("자전거의 최고속도위반으로 속도를 40으로 낮춥니다.");
      return;
    }
    System.out.println(getCarName() + "의 현재 속도는 " + velocity + " 입니다.");
  }

  @Override
  public void speedDown(int speed) {
    velocity -= speed;
    if (velocity < 10) {
      velocity = 10;
      System.out.println("자전거의 최저속도위반으로 속도를 10으로 올립니다.");
      return;
    }
    System.out.println(getCarName() + "의 현재 속도는 " + velocity + " 입니다.");
  }
}
