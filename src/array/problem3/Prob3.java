package array.problem3;

import java.util.ArrayList;
import java.util.List;

public class Prob3 {

  public static void main(String[] args) {
    int[] array = {3, 17, 12, 43, 3, 17, 3, 8, 21, 8};
    System.out.println("<< 중복되지 않은 숫자 >>");
    printUniqueNumber(array);
  }

  private static void printUniqueNumber(int[] array) {
    List<Integer> list = new ArrayList<>();
    List<Integer> notUnique = new ArrayList<>();

    for (Integer i : array) {
      if (list.contains(i) || notUnique.contains(i)) {
        list.remove(i);
        notUnique.add(i);
      } else {
        list.add(i);
      }
    }

    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i));
      if (i != list.size() - 1) {
        System.out.print(", ");
      }
    }
  }
}
