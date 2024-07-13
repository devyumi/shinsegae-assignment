package board.connection;

import board.dto.Board;
import board.dto.BoardEditDto;
import board.dto.BoardSaveDto;
import board.exception.BoardException;
import board.exception.ErrorMessage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDB implements AutoCloseable {

  private static final String url = "jdbc:mysql://localhost:3306/ssgdatabase?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
  private static final String id = "root";
  private static final String pwd = "0000";

  /**
   * Board Select All method
   *
   * @return Board List
   */
  public List<Board> findAllBoard() {

    String query = new StringBuilder()
        .append("SELECT * ")
        .append("FROM board ").toString();

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery()) {

      List<Board> boards = new ArrayList<>();

      while (rs.next()) {
        boards.add(Board.builder()
            .bNo(rs.getInt("bNo"))
            .bTitle(rs.getString("bTitle"))
            .bContent(rs.getString("bContent"))
            .bWriter(rs.getString("bWriter"))
            .bDate(rs.getDate("bDate"))
            .build());
      }
      return boards;
    } catch (SQLException e) {
      throw new BoardException(ErrorMessage.JDBC_SELECT_FAIL);
    }
  }

  /**
   * Board Select method
   *
   * @param bNo 테이블 번호
   * @return Board
   */
  public Board findBoard(int bNo) {

    String query = new StringBuilder()
        .append("SELECT * ")
        .append("FROM board ")
        .append("WHERE bNo = ? ").toString();

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query)) {
      pstmt.setInt(1, bNo);

      try (ResultSet rs = pstmt.executeQuery()) {
        rs.next();
        return Board.builder()
            .bNo(rs.getInt("bNo"))
            .bTitle(rs.getString("bTitle"))
            .bContent(rs.getString("bContent"))
            .bWriter(rs.getString("bWriter"))
            .bDate(rs.getDate("bDate"))
            .build();
      }
    } catch (SQLException e) {
      throw new BoardException(ErrorMessage.JDBC_SELECT_FAIL);
    }
  }

  /**
   * Board Insert method
   *
   * @param request
   */
  public void saveBoard(BoardSaveDto request) {

    String query = new StringBuilder()
        .append("INSERT INTO ")
        .append("board VALUES ")
        .append("(?, ?, ?, ?, ?) ").toString();

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setInt(1, findLastId() + 1);
      pstmt.setString(2, request.getTitle());
      pstmt.setString(3, request.getContent());
      pstmt.setString(4, request.getWriter());
      pstmt.setDate(5, java.sql.Date.valueOf(java.time.LocalDate.now()));

      if (pstmt.executeUpdate() == 1) {
        System.out.println("\n추가 완료 되었습니다.\n");
      } else {
        //예외 처리
      }

    } catch (SQLException e) {
      throw new BoardException(ErrorMessage.JDBC_INSERT_FAIL);
    }
  }

  /**
   * Board Update method
   *
   * @param request
   */
  public void updateBoard(BoardEditDto request) {

    String query = new StringBuilder()
        .append("UPDATE board ")
        .append("SET bTitle = ? , bContent = ? , bWriter = ?, bDate = ? ")
        .append("WHERE bNo = ? ").toString();

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setString(1, request.getTitle());
      pstmt.setString(2, request.getContent());
      pstmt.setString(3, request.getWriter());
      pstmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
      pstmt.setInt(5, request.getNo());

      if (pstmt.executeUpdate() == 1) {
        System.out.println("\n수정 완료 되었습니다.\n");
      } else {
        //예외 처리
      }

    } catch (SQLException e) {
      throw new BoardException(ErrorMessage.JDBC_UPDATE_FAIL);
    }
  }

  /**
   * Board Delete method
   *
   * @param board
   */
  public void deleteBoard(Board board) {

    String query = new StringBuilder()
        .append("DELETE FROM ")
        .append("board ")
        .append("WHERE bNo = ? ").toString();

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setInt(1, board.getBNo());

      if (pstmt.executeUpdate() == 1) {
        System.out.println("\n삭제 완료 되었습니다.\n");
      } else {
        //예외 처리
      }

    } catch (SQLException e) {
      throw new BoardException(ErrorMessage.JDBC_DELETE_FAIL);
    }
  }

  /**
   * Board Delete All method
   */
  public void deleteAllBoard() {

    String query = new StringBuilder()
        .append("TRUNCATE board ").toString();

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query)) {

      if (pstmt.executeUpdate() == 0) {
        System.out.println("\n모든 데이터를 삭제했습니다.\n");
      } else {
        //예외 처리
      }

    } catch (SQLException e) {
      throw new BoardException(ErrorMessage.JDBC_DELETE_FAIL);
    }
  }

  /**
   * 마지막 행의 id를 반환하는 메서드. Insert 시 사용된다.
   *
   * @return 마지막 행의 id
   */
  private static int findLastId() {

    int row = 0;
    String query = new StringBuilder()
        .append("SELECT bNo ")
        .append("FROM board ").toString();

    try (Connection connection = DriverManager.getConnection(url, id, pwd);
        PreparedStatement pstmt = connection.prepareStatement(query);
        ResultSet rs = pstmt.executeQuery()) {

      while (rs.next()) {
        row = Math.max(row, rs.getInt("bNo"));
      }
      return row;

    } catch (SQLException e) {
      throw new BoardException(ErrorMessage.JDBC_SELECT_ID_FAIL);
    }
  }

  @Override
  public void close() throws Exception {
    try {
      System.out.println("연결 해제");
    } catch (Exception e) {
      throw new BoardException(ErrorMessage.JDBC_CLOSE_FAIL);
    }
  }
}
