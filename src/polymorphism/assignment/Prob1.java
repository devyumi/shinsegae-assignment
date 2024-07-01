package polymorphism.assignment;

public class Prob1 {

  public static void main(String[] args) {
    Truck truck = new Truck(100, "트럭", 4);
    Bike bike = new Bike(25, "자전거", 2);

    System.out.println(truck.getCarName() + ": 바퀴 " + truck.getWheelNumber() + "개입니다.");
    System.out.println(bike.getCarName() + ": 바퀴 " + bike.getWheelNumber() + "개입니다.");
    System.out.println(truck.getCarName() + "의 현재 속도는 " + truck.getVelocity() + " 입니다.");
    System.out.println(bike.getCarName() + "의 현재 속도는 " + bike.getVelocity() + " 입니다.");
    truck.speedDown(100);
    bike.speedDown(25);
    truck.stop();
    bike.stop();
    truck.speedUp(10);
  }
}
