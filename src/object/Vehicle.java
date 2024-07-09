package object;

import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Vehicle {

  private Owner owner;
  private int price;

  @Override
  public boolean equals(Object o) {
    Vehicle vehicle = (Vehicle) o;
    return Objects.equals(owner, vehicle.owner);
  }

  @Override
  public int hashCode() {
    return 0;
  }

  @Override
  public String toString() {
    return "소유주정보 : " + owner.toString() + "차량정보 : 가격은 " + price + " 입니다.";
  }
}
