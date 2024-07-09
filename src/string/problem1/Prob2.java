package string.problem1;

import java.util.Scanner;

public class Prob2 {

  public static void main(String[] args) {
    String inputStr;

    Scanner keyboard = new Scanner(System.in);

    System.out.print("문자열을 입력하세요. : ");
    inputStr = keyboard.nextLine();

    System.out.println(new StringBuilder().append(inputStr.toUpperCase()).reverse());
  }
}
