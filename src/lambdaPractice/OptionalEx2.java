package lambdaPractice;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalEx2 {
  public static void main(String[] args) {
    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //1. isPresent()
    OptionalDouble optional1 = list.stream().mapToInt(Integer::intValue).average();
    if (optional1.isPresent()) {
      System.out.println("avg = " + optional1.getAsDouble());
    } else {
      System.out.println("0.0");
    }

    //2. orElse()
    double avg = list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    System.out.println("avg = " + avg);

    //3. ifPresent()
    list.stream().mapToInt(Integer::intValue).average().ifPresent(n -> System.out.println(n));
  }
}
