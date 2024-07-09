package string.problem1;

public class Prob1 {

  public static void main(String args[]) {

    Prob1 prob1 = new Prob1();

    System.out.println(prob1.leftPad("SSG", 6, '#'));
    System.out.println(prob1.leftPad("SSG", 5, '$'));
    System.out.println(prob1.leftPad("SSG", 2, '&'));

  }

  public String leftPad(String str, int size, char padChar) {

    if (str.length() > size) {
      return str;
    } else {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < size - str.length(); i++) {
        sb.append(padChar);
      }

      return sb.append(str).toString();
    }
  }
}
