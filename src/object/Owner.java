package object;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Owner {

  private String name;
  private String cellPhone;

  @Override
  public boolean equals(Object o) {
    Owner owner = (Owner) o;
    return Objects.equals(name, owner.name);
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public String toString() {
    return "이름은 " + name + "이고, 핸드폰 번호는 " + cellPhone + "입니다.\n";
  }
}
