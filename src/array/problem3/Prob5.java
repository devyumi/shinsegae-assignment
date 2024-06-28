package array.problem3;

import java.util.Arrays;

public class Prob5 {
  public static int getValue(int[] values, boolean isMax) {
    if (isMax) {
      return Arrays.stream(values).max().getAsInt();
    } else {
      return Arrays.stream(values).min().getAsInt();
    }
  }

  public static void main(String[] args) {
    int[] values = {57, 3, 43, 5, 39, 23, 55, 2};

    int maxValue = getValue(values, true);
    int minValue = getValue(values, false);

    System.out.println("최대값 = " + maxValue);
    System.out.println("최소값 = " + minValue);

  }
}
