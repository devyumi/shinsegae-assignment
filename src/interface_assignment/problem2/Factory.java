package interface_assignment.problem2;

public abstract class Factory {
  private int openHour;
  private int closeHour;
  private String name;

  public Factory (String name, int openHour, int closeHour) {
    this.name = name;
    this.openHour = openHour;
    this.closeHour = closeHour;
  }

  public String getFactoryName() {
    return name;
  }

  public int getWorkingTime() {
    return closeHour - openHour;
  }

  public abstract int makeProducts(char skill);
}
