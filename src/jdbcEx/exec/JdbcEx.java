package jdbcEx.exec;

import java.sql.SQLException;
import jdbcEx.db.MemberDB;

/**
 * JDBC 실행 클래스
 */
public class JdbcEx extends MemberDB {

  public static void main(String[] args) throws SQLException {

    //회원 정보 출력
    selectAllMember();

    //회원 추가 후 정보 출력 (parameter: name, job)
    insertMember("hi", "singer");
    selectAllMember();

    //회원 수정 후 정보 출력 (parameter: job)
    updateMember("teacher");
    selectAllMember();

    //회원 삭제 후 정보 출력
    deleteMember();
    selectAllMember();
  }
}
