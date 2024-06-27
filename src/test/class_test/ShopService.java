package test.class_test;

public class ShopService {
  private static ShopService shopService;

  public static ShopService getInstance() {
    if (shopService == null) {
      shopService = new ShopService();
    }
    return shopService;
  }
}
