package board.service;

import board.dto.Board;
import java.io.IOException;

public interface BoardService {



  /**
   * 게시물 생성 메서드
   */
  void create() throws IOException;

  /**
   * 특정 게시물 조회 메서드
   */
  void read() throws IOException;

  /**
   * 게시물 수정 메서드
   * @param board - no, title, content, writer, date
   */
  void update(Board board) throws IOException;

  /**
   * 게시물 삭제 메서드
   * @param board - no, title, content, writer, date
   */
  void delete(Board board);

  /**
   * 모든 게시물 삭제 메서드
   */
  void clear() throws IOException;
}
