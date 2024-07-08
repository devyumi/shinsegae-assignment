package jdbcEx.exception;

/**
 * JDBC 에러 메시지 클래스
 */
public enum ErrorMessage {
  JDBC_SELECT_FAIL("회원 정보를 조회할 수 없습니다.", "F001"),
  JDBC_INSERT_FAIL("회원 정보를 추가할 수 없습니다.", "F002"),
  JDBC_UPDATE_FAIL("회원 정보를 수정할 수 없습니다.", "F003"),
  JDBC_DELETE_FAIL("회원 정보를 삭제할 수 없습니다.", "F004"),
  JDBC_CLOSE_FAIL("연결 종료에 실패했습니다.", "F005");

  private String message;
  private String code;

  ErrorMessage(String message, String code) {
    this.message = message;
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public String getCode() {
    return code;
  }
}
