package string.problem3;

public class Prob1 {

  public static void main(String[] args) {
    Prob1 p = new Prob1();
    String addr = "서울시,강남구,봉은사로,SSGJavaBackend";
    String[] addrArr = p.split(addr, ',');
    System.out.println("배열 크기 : " + addrArr.length);
    for (int i = 0; i < addrArr.length; i++) {
      System.out.print(addrArr[i] + " ");
    }
  }

  public String[] split(String str, char separator) {
    return str.split(String.valueOf(separator));
  }
}
