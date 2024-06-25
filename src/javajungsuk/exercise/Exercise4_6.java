package jungol.exercise;

public class Exercise4_6 {

  public static void main(String[] args) {
    int cnt = 0;
    for (int i = 1; i <= 5; i++) {
      for (int j = 1; j <= 5; j++) {
        if (i + j == 6) {
          cnt++;
          break;
        }
      }
    }
    System.out.println("눈의 합이 6이 되는 경우의 수는 " + cnt + "개입니다.");
  }

}
