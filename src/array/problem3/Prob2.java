package array.problem3;

public class Prob2 {

  public static void main(String[] args) {
    System.out.println("<< 생성된 난수 >>");
    int[] arr = generateRandom();
    System.out.println("==========================");
    System.out.println("배열에서 가장 큰 숫자 : " + getMaxNum(arr));
  }

  private static int[] generateRandom() {
    int[] arr = new int[10];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random() * 30) + 1;
      System.out.print(arr[i] + ", ");
    }
    System.out.println();
    return arr;
  }

  private static int getMaxNum(int[] arr) {
    int max = arr[0];
    for (int i : arr) {
      max = Math.max(max, i);
    }
    return max;
  }
}
