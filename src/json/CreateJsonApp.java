package json;

public class CreateJsonApp {

  public static void main(String[] args) {
    String jsonObject = UtilJson.createJsonData();
    UtilJson.parseJsonData(jsonObject);
  }
}
