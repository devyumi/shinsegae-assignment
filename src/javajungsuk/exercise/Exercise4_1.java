package jungol.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise4_1 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("integer형 정수를 입력하시오: ");
    int x = Integer.parseInt(br.readLine());

    System.out.print("character형 문자를 입력하시오: ");
    char ch = br.readLine().charAt(0);

    System.out.print("원하는 연도를 입력하시오: ");
    int year = Integer.parseInt(br.readLine());

    System.out.print("true와 false 중 하나를 선택하여 입력하시오: ");
    boolean powerOn = false;
    String s = br.readLine();
    if (s.equals("true")) {
      powerOn = true;
    }

    System.out.print("yes와 no 중 하나를 선택하여 입력하시오: ");
    String str = br.readLine();

    System.out.println("1: " + exercise1(x));
    System.out.println("2: " + exercise2(ch));
    System.out.println("3: " + exercise3(ch));
    System.out.println("4: " + exercise4(ch));
    System.out.println("5: " + exercise5(ch));
    System.out.println("6: " + exercise6(year));
    System.out.println("7: " + exercise7(powerOn));
    System.out.println("8: " + exercise8(str));
  }

  private static boolean exercise1(int x) {
    return x > 10 && x < 20;
  }

  private static boolean exercise2(char ch) {
    return ch != ' ' && ch != '\t';
  }

  private static boolean exercise3(char ch) {
    return ch == 'x' || ch == 'X';
  }

  private static boolean exercise4(char ch) {
    return ch >= 48 && ch <= 57;
  }

  private static boolean exercise5(char ch) {
    return (ch >= 65 && ch < 91) || (ch >= 97 && ch < 123);
  }

  private static boolean exercise6(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
  }

  private static boolean exercise7(boolean powerOn) {
    return !powerOn;
  }

  private static boolean exercise8(String str) {
    return str.equals("yes");
  }
}
