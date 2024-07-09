package create_class;

/**
 * Account Exception 클래스
 * 잔고가 부족할 경우 예외를 발생한다.
 */
public class InsufficientException extends RuntimeException {
  public InsufficientException() {
    System.out.println("\n" + "*".repeat(40));
    System.out.println("잔고가 부족합니다.");
    System.out.println("*".repeat(40) + "\n");
  }
}
