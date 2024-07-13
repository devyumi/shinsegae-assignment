package board.exec;

import board.connection.BoardDB;
import board.dto.Board;
import board.dto.BoardEditDto;
import board.dto.BoardSaveDto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardExample {

  private static final BoardDB boardDB = new BoardDB();
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    BoardExample boardExample = new BoardExample();

    Loop:
    while (true) {
      boardExample.list();
      String input = br.readLine();

      switch (input) {
        case "1" -> create();

        case "2" -> read();

        case "3" -> clear();

        case "4" -> {
          System.out.println("** 게시판 종료 **");
          br.close();
          break Loop;
        }

        default -> System.out.println("\n** 다시 입력해주세요.**\n");
      }
    }
  }

  /**
   * 게시물 목록 출력 메서드
   */
  private void list() {
    System.out.println("\n[게시물 목록]");
    System.out.println("-".repeat(50));
    System.out.printf("%-5s %-15s %-15s %-15s\n", "no", "writer", "date", "title");
    System.out.println("-".repeat(50));

    for (Board board : boardDB.findAllBoard()) {
      System.out.printf("%-5d %-15s %-15s %-15s\n", board.getBNo(), board.getBWriter(),
          board.getBDate().toString(), board.getBTitle());
    }
    mainMenu();
  }

  /**
   * 메인 메뉴 출력 메서드
   */
  private static void mainMenu() {
    System.out.println("-".repeat(50));
    System.out.println("메인 메뉴: 1. Create | 2. Read | 3. Clear | 4. Exit");
    System.out.print("메뉴 선택: ");
  }

  /**
   * 서브 메뉴 출력 메서드. 게시물 조회 시 사용한다.
   */
  private static void subMenu() {
    System.out.println("-".repeat(50));
    System.out.println("보조 메뉴: 1. Update | 2. Delete | 3. List");
    System.out.print("메뉴 선택: ");
  }

  /**
   * 확인 메뉴 출력 메서드. 게시물 생성, 수정, 삭제 시 사용한다.
   */
  private static void checkMenu() {
    System.out.println("-".repeat(50));
    System.out.println("보조 메뉴: 1. OK | 2. Cancel");
    System.out.print("메뉴 선택: ");
  }

  /**
   * 게시물 생성 메서드
   *
   * @throws IOException
   */
  private static void create() throws IOException {
    System.out.println("\n[새 게시물 입력]");
    System.out.print("제목: ");
    String title = br.readLine();

    System.out.print("내용: ");
    String content = br.readLine();

    System.out.print("작성자: ");
    String writer = br.readLine();

    Loop:
    while (true) {
      checkMenu();
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

  /**
   * 특정 게시물 조회 메서드
   *
   * @throws IOException
   */
  private static void read() throws IOException {
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
      subMenu();
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

  /**
   * 게시물 수정 메서드
   *
   * @param board
   * @throws IOException
   */
  private static void update(Board board) throws IOException {
    System.out.println("\n[수정 내용 입력]");
    System.out.print("제목: ");
    String title = br.readLine();

    System.out.print("내용: ");
    String content = br.readLine();

    System.out.print("작성자: ");
    String writer = br.readLine();

    Loop:
    while (true) {
      checkMenu();
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

  /**
   * 게시물 삭제 메서드
   *
   * @param board
   */
  private static void delete(Board board) {
    boardDB.deleteBoard(board);
  }

  /**
   * 모든 게시물 삭제 메서드
   *
   * @throws IOException
   */
  private static void clear() throws IOException {
    System.out.println("\n[게시물 전체 삭제]");

    Loop:
    while (true) {
      checkMenu();
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
