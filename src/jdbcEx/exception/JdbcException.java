package jdbcEx.exception;

/**
 * JDBC Exception 클래스
 */
public class JdbcException extends RuntimeException {

  public JdbcException(ErrorMessage errorMessage) {
    System.out.println("\n" + "*".repeat(40));
    System.out.println(errorMessage.getMessage() + " | " + errorMessage.getCode());
    System.out.println("*".repeat(40));
  }
}
