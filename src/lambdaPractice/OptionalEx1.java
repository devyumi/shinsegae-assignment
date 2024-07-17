package lambdaPractice;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalEx1 {

  public static void main(String[] args) {
    List<String> nameList = Arrays.asList("BBB", "CCC", "AAA", "DDD");

    /**
     * Optional 클래스는 제너릭타입을 사용하여 값의 타입을 지정한다.
     */

    //1. 존재 여부에 따른 처리
    String value = "Hello Optional!";

    //1-1. Optional.of(value): Optional 객체 생성
    Optional<String> optionalS = Optional.of(value);

    //1-2. OptionalS 객체 값의 유무 확인
    optionalS.ifPresent(System.out::println);

    //2. Null 처리 방법
    Optional<String> optionalS1 = Optional.ofNullable(value);

    //2-1. orElse 를 사용하여 null 인 경우 기본값 반환, 아닌 경우 결과값 반환
    String result = optionalS1.orElse("없음");
    System.out.println("result = " + result);
  }
}
