package lambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEx {

  public static void main(String[] args) {
    Predicate<Integer> isPositive = n -> n > 0;
    System.out.println(isPositive.test(5));
    System.out.println(isPositive.test(-1));

    List<Integer> numbers = Arrays.asList(-3, -2, -1, 0, 1, 2, 3);
    List<Integer> positiveNumber = filter(numbers, isPositive);

    positiveNumber.stream().forEach(System.out::println);
  }

  public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
    List<T> filterList = new ArrayList<>();
    for (T item : list) {
      if (predicate.test(item)) {
        filterList.add(item);
      }
    }
    return filterList;
  }
}

/**
 * Predicate Ex.
 */
