package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class morningTest0718 {

  public static void main(String[] args) {

  }

  private static void p1() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    int sum = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    System.out.println(sum);
  }

  private static void p2() {
    Supplier<String> string = () -> "Hello";
    System.out.println(string.get());
  }

  private static void p3() {
    Supplier<Integer> random = () -> new Random().nextInt();
    System.out.println(random.get());
  }

  private static void p4() {
    //txt 내용: 1줄\n2줄\n3줄\n4줄\n5줄

    try (FileInputStream fi = new FileInputStream("C:/Temp/morning_test.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fi))) {
      int cnt = 0;
      while ((br.readLine()) != null) {
        cnt++;
      }

      System.out.println("총 " + cnt + "줄입니다.");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  private static void p5() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    int sum = numbers.stream().mapToInt(Integer::intValue).sum();
    System.out.println(sum);
  }

  private static void p6() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    int sum = numbers.stream().filter(n -> n % 2 != 0).mapToInt(m -> m * m).sum();
    System.out.println(sum);
  }
}
