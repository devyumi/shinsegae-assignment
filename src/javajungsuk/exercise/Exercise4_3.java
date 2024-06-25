package jungol.exercise;

public class Exercise4_3 {

  public static void main(String[] args) {
    int[] dp = new int[11];
    int sum = 0;

    for (int i = 1; i <= 10; i++) {
      dp[i] = dp[i - 1] + i;
      sum += dp[i];
    }

    /*for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= i; j++) {
        sum += j;
      }
    }*/
    
    System.out.println("sum = " + sum);
  }
}
