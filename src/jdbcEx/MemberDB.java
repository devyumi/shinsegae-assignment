package jdbcEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbcEx.dto.Member;
import jdbcEx.exception.ErrorMessage;
import jdbcEx.exception.JdbcException;

/**
 * Member JDBC 추상 클래스 select, insert, update, delete 기능
 */
public abstract class MemberDB implements AutoCloseable {

  private static final String url = "jdbc:mysql://localhost:3306/employees?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
  private static final String id = "root";
  private static final String pwd = "0000";

  /**
   * Member Select method
   */
  public static void selectAllMember() {

    String query = new StringBuilder()
        .append("SELECT * ")
        .append("FROM member ").toString();

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery()) {

      System.out.println("*".repeat(60));
      while (rs.next()) {
        Member member = new Member(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("job")
        );
        System.out.println(member);
      }
      System.out.println("*".repeat(60));

    } catch (SQLException e) {
      throw new JdbcException(ErrorMessage.JDBC_SELECT_FAIL);
    }
  }

  /**
   * Member Insert method
   */
  public static void insertMember(String name, String job) {

    String query = new StringBuilder()
        .append("INSERT INTO ")
        .append("member VALUES ")
        .append("(?, ?, ?) ").toString();

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setInt(1, findLastId() + 1);
      pstmt.setString(2, name);
      pstmt.setString(3, job);

      if (pstmt.executeUpdate() == 1) {
        System.out.println("\n추가 완료되었습니다.\n");
      } else {
        throw new JdbcException(ErrorMessage.JDBC_INSERT_FAIL);
      }

    } catch (SQLException e) {
      throw new JdbcException(ErrorMessage.JDBC_INSERT_FAIL);
    }

  }

  /**
   * Member Update method 편의 상 마지막 행만 수정되도록 구현하였다. 편의 상 job만 수정되도록 구현한였다.
   */
  public static void updateMember(String job) {

    String query = new StringBuilder()
        .append("UPDATE member ")
        .append("SET job = ? ")
        .append("WHERE id = ? ").toString();

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setString(1, job);
      pstmt.setInt(2, findLastId());

      if (pstmt.executeUpdate() == 1) {
        System.out.println("\n수정 완료되었습니다.\n");
      } else {
        throw new JdbcException(ErrorMessage.JDBC_UPDATE_FAIL);
      }

    } catch (SQLException e) {
      throw new JdbcException(ErrorMessage.JDBC_UPDATE_FAIL);
    }
  }

  /**
   * Member Delete method 편의 상 마지막 행만 삭제되도록 구현하였다.
   */
  public static void deleteMember() {

    String query = new StringBuilder()
        .append("DELETE FROM ")
        .append("member ")
        .append("WHERE id = ? ").toString();

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setInt(1, findLastId());

      if (pstmt.executeUpdate() == 1) {
        System.out.println("\n삭제 완료되었습니다.\n");
      } else {
        throw new JdbcException(ErrorMessage.JDBC_DELETE_FAIL);
      }

    } catch (SQLException e) {
      throw new JdbcException(ErrorMessage.JDBC_DELETE_FAIL);
    }
  }

  /**
   * 마지막 행의 id를 반환하는 메서드. Insert, Update, Delete 시 사용된다.
   *
   * @return 마지막 행의 id
   */
  private static int findLastId() {

    int row = 0;
    String query = "SELECT * FROM member";

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery()) {

      while (rs.next()) {
        row = Math.max(row, rs.getRow());
      }
      return row;
    } catch (SQLException e) {
      throw new JdbcException(ErrorMessage.JDBC_SELECT_FAIL);
    }
  }

  @Override
  public void close() throws Exception {
    try {
      System.out.println("연결 종료");
    } catch (Exception e) {
      throw new JdbcException(ErrorMessage.JDBC_CLOSE_FAIL);
    }
  }
}
