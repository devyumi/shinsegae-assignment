package array.problem1;
public class Prob1 {

  public static void main(String[] args) {

    int[] ia = new int[]{3, 7, 1, 8, 10, 2, 15, 2, 10};
    int[] ib = new int[]{1, 2, 3, 4, 5};
    System.out.println("( 배열 ia )");
    calSum(ia);

    System.out.println("( 배열 ib )");
    calSum(ib);
  }

  private static void calSum(int[] arr) {
    int oddSum = 0;
    int evenSum = 0;

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 == 0) {
        evenSum += arr[i];
      } else {
        oddSum += arr[i];
      }
    }
    System.out.println("홀수의 합: " + oddSum);
    System.out.println("짝수의 합: " + evenSum);
  }
}

