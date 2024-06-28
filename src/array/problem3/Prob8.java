package array.problem3;

public class Prob8 {

  public static void main(String[] args) {
    int[][] arr = new int[5][5];
    int n = 1;

    for (int i = 0; i < arr.length; i++) {
      for (int j = arr[i].length - 1; j >= 0; j--) {
        arr[i][j] = n++;
      }
    }

    for (int i = 0; i < arr.length; i++) {
      for (int j : arr[i]) {
        System.out.print(j + " ");
      }
      System.out.println();
    }
  }
}
