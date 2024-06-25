package create_class;

public class Employee {

  private String name;
  private int age;
  private String dept;

  public void print() {
    System.out.printf("이  름 : %s\t\t나 이 : %d\t\t\t부   서 : %s\n", this.name, this.age, this.dept);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }
}
