package array.problem3;

import java.util.Arrays;

public class Prob6 {

  public static void main(String[] args) {
    Prob6 median = new Prob6();

    int[] values1 = {10, 4, 53, 63, 17, 37, 52, 16, 33, 65};
    System.out.println("input : " + Arrays.toString(values1));
    System.out.println("median : " + median.findMedian(values1));
    System.out.println("=================================================");

    int[] values2 = {32, 53, 52, 76, 15, 98, 76, 65, 36, 10};
    System.out.println("input : " + Arrays.toString(values2));
    System.out.println("median : " + median.findMedian(values2));
  }

  public int findMedian(int[] values) {
    double[] median = new double[values.length];
    int sum = 0;

    for (int i : values) {
      sum += i;
    }

    double avg = sum / (double) values.length;
    for (int i = 0; i < median.length; i++) {
      median[i] = Math.abs(values[i] - avg);
    }

    double min = median[0];
    int minIndex = 0;
    for (int i = 1; i < median.length; i++) {
      if (min > median[i]) {
        min = median[i];
        minIndex = i;
      } else if (min == median[i]) {
        if (values[minIndex] > values[i]) {
          minIndex = i;
        }
      }
    }
    return values[minIndex];
  }
}
