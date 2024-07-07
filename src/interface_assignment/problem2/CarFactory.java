package interface_assignment.problem2;

public class CarFactory extends Factory implements IWorkingTogether {

  public CarFactory(String name, int openHour, int closeHour) {
    super(name, openHour, closeHour);
  }

  @Override
  public int makeProducts(char skill) {
    int skillTime = 0;

    switch (skill) {
      case 'A' -> {
        skillTime = 3;
      }

      case 'B' -> {
        skillTime = 2;
      }

      case 'C' -> {
        skillTime = 1;
      }
    }
    return getWorkingTime() * skillTime;
  }

  @Override
  public int workTogether(IWorkingTogether partner) {
    return ((Factory) partner).makeProducts('B');
  }
}
