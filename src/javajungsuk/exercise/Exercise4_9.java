package jungol.exercise;

public class Exercise4_9 {

  public static void main(String[] args) {
    int num = 12345;
    int sum = 0;

    int size = 10000;
    for (int i = 0; i < 5; i++) {
      sum += num / size;
      num %= size;
      size /= 10;
    }
    System.out.println("sum = " + sum);
  }
}
