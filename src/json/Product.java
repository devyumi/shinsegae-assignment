package json;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
  private int productNo;
  private String productName;
  private ProductInfo extraProductInfo;
  private List<String> itemList;
}
