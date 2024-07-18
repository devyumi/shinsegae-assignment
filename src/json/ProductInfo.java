package json;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductInfo {
  private int size;
  private String color;
}
