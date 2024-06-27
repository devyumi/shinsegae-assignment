package test.referece_test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

  public static void main(String[] args) {
    problem9();
  }

  private static void problem7() {
    int[] array = {1, 5, 3, 8, 2};
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
      max = Math.max(max, array[i]);
    }
    System.out.println("max = " + max);
  }

  private static void problem8() {
    int[][] array = {
        {95, 86},
        {83, 92, 96},
        {78, 83, 93, 87, 88}
    };
    int sum = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        sum += array[i][j];
      }
    }
    System.out.println("sum = " + sum);
    System.out.println("avg = " + sum / (double) array.length);
  }

  private static void problem9() {
    Scanner sc = new Scanner(System.in);
    int selectedNumber;
    int student = 0;
    List<Integer> scores = new ArrayList<>();

    while (true) {
      printMenu();
      selectedNumber = sc.nextInt();
      sc.nextLine();

      if (selectedNumber < 1 || selectedNumber > 5) {
        System.out.println("잘못된 접근입니다.");
        continue;
      }

      if (selectedNumber == 5) {
        System.out.print("프로그램 종료");
        break;
      }

      switch (selectedNumber) {
        case 1 -> {
          System.out.print("학생수> ");
          student = sc.nextInt();
        }

        case 2 -> {
          if (student == 0) {
            System.out.println("1명 이상의 학생이 필요합니다.");
            break;
          }

          for (int i = 0; i < student; i++) {
            System.out.print("scores[" + i + "]> ");
            scores.add(sc.nextInt());
            sc.nextLine();
          }
        }

        case 3 -> {
          for (int i = 0; i < scores.size(); i++) {
            System.out.println("scores[" + i + "]: " + scores.get(i));
          }
        }

        case 4 -> {
          if (scores.isEmpty()) {
            System.out.println("학생의 점수를 먼저 입력하세요.");
            break;
          }
          int sum = 0;
          int max = scores.get(0);
          for (int i : scores) {
            max = Math.max(max, i);
            sum += i;
          }
          System.out.println("최고 점수: " + max);
          System.out.println("평균 점수: " + sum / (double) scores.size());
        }
      }
    }
  }

  private static void printMenu() {
    System.out.println("-----------------------------------");
    System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
    System.out.println("-----------------------------------");
    System.out.print("선택> ");
  }
}
