package create_class;

public class Student {

  private String name;
  private int age;
  private int id;

  public void print() {
    System.out.printf("이  름 : %s\t\t나 이 : %d\t\t\t학   번 : %d\n", this.name, this.age, this.id);
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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
