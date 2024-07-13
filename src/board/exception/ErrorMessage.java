package board.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {

  INVALID_INPUT_STRING("유효하지 않은 문자입니다.", "S001"),
  JDBC_SELECT_FAIL("게시물을 조회할 수 없습니다.", "F001"),
  JDBC_INSERT_FAIL("게시물을 추가할 수 없습니다.", "F002"),
  JDBC_UPDATE_FAIL("게시물을 수정할 수 없습니다.", "F003"),
  JDBC_DELETE_FAIL("게시물을 삭제할 수 없습니다.", "F004"),
  JDBC_CLOSE_FAIL("연결 종료에 실패했습니다.", "F005"),
  JDBC_SELECT_ID_FAIL("게시물 번호를 조회할 수 없습니다.", "F006");

  private final String message;
  private final String code;
}
