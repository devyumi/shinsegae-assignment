package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;

public class UtilJson {

  public static String createJsonData() {
    Gson gson = new Gson();
    return gson.toJson(createProduct());
  }

  public static void parseJsonData(String jsonObject) {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    parseJsonDataUseIterator(gson.fromJson(jsonObject, Product.class));
  }

  public static void parseJsonDataUseIterator(Product jsonObject) {
    /**
     * value로 단순 값(string, int)를 가지는 프로퍼티 조회.
     * product_no, product_name
     */
    System.out.println("[product info]");
    System.out.println("product_no: " + jsonObject.getProductNo());
    System.out.println("product_name: " + jsonObject.getProductName());

    /**
     * value로 Json을 가지는 프로퍼티 조회.
     * extra_product_info를 꺼낼 때, JSONObject로 캐스팅.
     */
    System.out.println("\n[shirt info]");
    ProductInfo extraProductInfo = jsonObject.getExtraProductInfo();
    System.out.println("shirt_size: " + extraProductInfo.getSize());
    System.out.println("shirt_color: " + extraProductInfo.getColor());

    /**
     * value로 Array를 가지는 프로퍼티 조회.
     * item_list를 꺼낼 때, JSONArray로 캐스팅.
     */
    System.out.println("\n[brand list]");
    jsonObject.getItemList().stream().forEach(System.out::println);
  }

  private static Product createProduct() {
    return Product.builder()
        .productNo(1)
        .productName("shirt")
        .extraProductInfo(
            ProductInfo.builder()
                .size(90)
                .color("yellow")
                .build())
        .itemList(List.of("NIKE", "ADIDAS", "H&M", "ZARA", "NEW BALANCE"))
        .build();
  }
}
