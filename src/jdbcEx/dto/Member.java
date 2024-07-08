package jdbcEx.dto;

/**
 * Member 클래스
 * id, name, job
 */
public class Member {

  private int id;
  private String name;
  private String job;

  public Member(int id, String name, String job) {
    this.id = id;
    this.name = name;
    this.job = job;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getJob() {
    return job;
  }

  @Override
  public String toString() {
    return new StringBuilder()
        .append("Member: ")
        .append(String.format("id = %-2d  |  ", id))
        .append(String.format("name = %-2s  |  ", name))
        .append(String.format("job = %-2s", job))
        .toString();
  }
}
