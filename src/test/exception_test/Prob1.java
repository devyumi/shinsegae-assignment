package test.exception_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1 {

  //필요할 경우 다음의 메서드 선언부분(메서드 시그너처)을 수정하시기 바랍니다.
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("숫자로 변환할 문자열을 입력바랍니다.");
    String str = br.readLine();
    int result = convert(str);
    System.out.println("변환된 숫자는 " + result + " 입니다.");
  }

  //필요할 경우 다음의 메서드 선언부분(메서드 시그너처)을 수정하시기 바랍니다.
  private static int convert(String str) {
    try {
      return Integer.parseInt(str);
    } catch (ArithmeticException e) {
      System.out.println("예외가 발생되었습니다.");
    } catch (IllegalArgumentException e) {
      System.out.println("예외가 발생되었습니다. 문자열을 입력하지 않고 Enter키를 누르셨습니다.");
    }
    return Integer.parseInt(str);
  }

}