package create_class;

public class Teacher {

  private String name;
  private int age;
  private String subject;

  public void print() {
    System.out.printf("이  름 : %s\t\t나 이 : %d\t\t\t담당과목 : %s\n", this.name, this.age, this.subject);
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

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }
}
