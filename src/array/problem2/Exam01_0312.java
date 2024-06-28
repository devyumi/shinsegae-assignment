package array.problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exam01_0312 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] arr = new int[5];
    double[] doubleArr = new double[5];
    double sum = 0;

    for (int i = 0; i < arr.length; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      sum += arr[i];
    }

    for (int i = 0; i < arr.length; i++) {
      doubleArr[i] = arr[i] / sum * 100;
      for (int j = 0; j < Math.floor(doubleArr[i]); j++) {
        System.out.print("*");
      }
      System.out.println("(" + doubleArr[i] + "%)");
    }
    br.close();
  }
}
