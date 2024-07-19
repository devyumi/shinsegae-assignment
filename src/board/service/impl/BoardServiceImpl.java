package board.service.impl;

import board.connection.BoardDB;
import board.dto.Board;
import board.dto.BoardEditDto;
import board.dto.BoardSaveDto;
import board.service.BoardService;
import board.service.PrintService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardServiceImpl implements BoardService {

  private final PrintService printService = new PrintServiceImpl();
  private final BoardDB boardDB = new BoardDB();
  private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  @Override
  public void create() throws IOException {
    System.out.println("\n[새 게시물 입력]");
    System.out.print("제목: ");
    String title = br.readLine();

    System.out.print("내용: ");
    String content = br.readLine();

    System.out.print("작성자: ");
    String writer = br.readLine();

    Loop:
    while (true) {
      printService.checkMenu();
      String input = br.readLine();

      switch (input) {
        case "1" -> {
          boardDB.saveBoard(
              BoardSaveDto.builder()
                  .title(title)
                  .content(content)
                  .writer(writer)
                  .build());
          break Loop;
        }

        case "2" -> {
          break Loop;
        }

        default -> System.out.println("\n** 다시 입력해주세요.**\n");
      }
    }
  }

  @Override
  public void read() throws IOException {
    System.out.println("\n[게시물 읽기]");
    System.out.print("bno: ");
    int inputBno = Integer.parseInt(br.readLine());
    Board board = boardDB.findBoard(inputBno);

    System.out.println("#".repeat(30));
    System.out.println("번호: " + board.getBNo());
    System.out.println("제목: " + board.getBTitle());
    System.out.println("내용: " + board.getBContent());
    System.out.println("작성자: " + board.getBWriter());
    System.out.println("날짜: " + board.getBDate());
    System.out.println("#".repeat(30));

    Loop:
    while (true) {
      printService.subMenu();
      String input = br.readLine();

      switch (input) {
        case "1" -> {
          update(board);
          break Loop;
        }

        case "2" -> {
          delete(board);
          break Loop;
        }

        case "3" -> {
          break Loop;
        }

        default -> System.out.println("\n** 다시 입력해주세요.**\n");
      }
    }
  }

  @Override
  public void update(Board board) throws IOException {
    System.out.println("\n[수정 내용 입력]");
    System.out.print("제목: ");
    String title = br.readLine();

    System.out.print("내용: ");
    String content = br.readLine();

    System.out.print("작성자: ");
    String writer = br.readLine();

    Loop:
    while (true) {
      printService.checkMenu();
      String input = br.readLine();

      switch (input) {
        case "1" -> {
          boardDB.updateBoard(
              BoardEditDto.builder()
                  .no(board.getBNo())
                  .title(title)
                  .content(content)
                  .writer(writer)
                  .build());
          break Loop;
        }

        case "2" -> {
          break Loop;
        }

        default -> System.out.println("\n** 다시 입력해주세요.**\n");
      }
    }
  }

  @Override
  public void delete(Board board) {
    boardDB.deleteBoard(board);
  }

  @Override
  public void clear() throws IOException {
    System.out.println("\n[게시물 전체 삭제]");

    Loop:
    while (true) {
      printService.checkMenu();
      String input = br.readLine();

      switch (input) {
        case "1" -> {
          boardDB.deleteAllBoard();
          break Loop;
        }

        case "2" -> {
          break Loop;
        }

        default -> System.out.println("\n** 다시 입력해주세요.**\n");
      }
    }
  }
}
