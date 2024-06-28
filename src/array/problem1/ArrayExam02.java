package array.problem1;

import java.util.Random;

public class ArrayExam02 {

  public static void main(String[] args) {
    int[] arr = new int[5];
    Random random = new Random();
    for (int i = 0; i < arr.length; i++) {
      arr[i] = random.nextInt(100) + 1;
      System.out.print(arr[i] + " ");
    }
  }
}

