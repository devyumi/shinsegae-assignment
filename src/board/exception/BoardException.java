package board.exception;

public class BoardException extends RuntimeException {

  public BoardException(ErrorMessage errorMessage) {
    System.out.println("\n" + "*".repeat(40));
    System.out.println(errorMessage.getMessage() + " | " + errorMessage.getCode());
    System.out.println("*".repeat(40) + "\n");
  }
}
