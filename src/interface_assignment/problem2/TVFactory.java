package interface_assignment.problem2;

public class TVFactory extends Factory implements IWorkingTogether {

  public TVFactory(String name, int openHour, int closeHour) {
    super(name, openHour, closeHour);
  }

  @Override
  public int makeProducts(char skill) {
    int skillTime = 1;

    switch (skill) {
      case 'A' -> {
        skillTime = 8;
      }

      case 'B' -> {
        skillTime = 5;
      }

      case 'C' -> {
        skillTime = 3;
      }
    }
    return getWorkingTime() * skillTime;
  }

  @Override
  public int workTogether(IWorkingTogether partner) {
    return ((Factory) partner).makeProducts('C');
  }
}
