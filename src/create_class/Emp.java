package create_class;

public class Emp {

  private String id;
  private String name;
  private int baseSalary;

  public double getSalary(double bonus) {
    return this.baseSalary + this.baseSalary * bonus;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(int baseSalary) {
    this.baseSalary = baseSalary;
  }

  @Override
  public String toString() {
    return name + "(" + id + ") 사원의 기본급은 " + baseSalary + "원 입니다.";
  }
}
