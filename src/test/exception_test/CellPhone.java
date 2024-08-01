package test.exception_test;

public class CellPhone {
  private String model;
  private double battery;

  public double getBattery() {
    return battery;
  }

  public CellPhone(String model) {
    this.model = model;
  }

  /**
   * 통화로 인한 감소되는 배터리 양 계산 method
   * @param time
   */
  public void call(int time) {
    try {
      if (time < 0) {
        throw new IllegalArgumentException();
      }

      System.out.println("통화 시간 : " + time + "분");
      this.battery -= time * 0.5;

      if (getBattery() < 0) {
        this.battery = 0;
      }

    } catch (IllegalArgumentException e) {
      System.out.println("통화시간입력오류");
    }
  }

  /**
   * 충전 시 추가되는 배터리 양 계산 method
   * @param time
   */
  public void charge(int time) {
    try {
      if (time < 0) {
        throw new IllegalArgumentException();
      }

      System.out.println("충전 시간 : " + time + "분");
      this.battery += time * 3.0;

      if (getBattery() > 100) {
        this.battery = 100;
      }

    } catch (IllegalArgumentException e) {
      System.out.println("충전시간입력오류");
    }

  }

  public void printBattery() {
    System.out.println("남은 배터리 양 : " + getBattery());
  }
}
