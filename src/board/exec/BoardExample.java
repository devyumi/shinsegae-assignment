package board.exec;

import board.dto.Board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class BoardExample {

  private static final List<Board> boards = new ArrayList<>();
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static int bno = 1;


  public static void main(String[] args) throws IOException {
    BoardExample boardExample = new BoardExample();

    Loop:
    while (true) {
      boardExample.list();
      int input = Integer.parseInt(br.readLine());

      switch (input) {
        case 1 -> create();

        case 2 -> read();

        case 3 -> clear();

        case 4 -> {
          br.close();
          break Loop;
        }

        default -> System.out.println("예외처리");
      }
    }
  }

  private void list() {
    System.out.println("[게시물 목록]");
    System.out.println("-".repeat(50));
    System.out.printf("%-5s %-10s %-20s %-20s\n", "no", "writer", "date", "title");
    System.out.println("-".repeat(50));
    for (Board board : boards) {
      System.out.printf("%-5s %-10s %-20s %-20s\n", board.getBNo(), board.getBWriter(),
          board.getBDate(), board.getBTitle());
    }

    System.out.println("-".repeat(50));
    mainMenu();
  }

  private static void mainMenu() {
    System.out.println("-".repeat(50));
    System.out.println("메인 메뉴: 1. Create | 2. Read | 3. Clear | 4. Exit");
    System.out.print("메뉴 선택: ");
  }

  private static void subMenu() {
    System.out.println("-".repeat(50));
    System.out.println("보조 메뉴: 1. Update | 2. Delete | 3. List");
    System.out.print("메뉴 선택: ");
  }

  private static void checkMenu() {
    System.out.println("-".repeat(50));
    System.out.println("보조 메뉴: 1. OK | 2. Cancel");
    System.out.print("메뉴 선택: ");
  }

  private static void create() throws IOException {
    System.out.println("\n[새 게시물 입력]");
    System.out.print("제목: ");
    String title = br.readLine();

    System.out.print("내용: ");
    String content = br.readLine();

    System.out.print("작성자: ");
    String writer = br.readLine();

    checkMenu();
    int input = Integer.parseInt(br.readLine());

    if (input == 1) {
      boards.add(Board.builder()
          .bNo(bno++)
          .bTitle(title)
          .bContent(content)
          .bWriter(writer)
          .bDate(new Date())
          .build());
    }
  }

  private static void read() throws IOException {
    Loop:
    while (true) {
      System.out.println("\n[게시물 읽기]");
      System.out.print("bno: ");
      int inputBno = Integer.parseInt(br.readLine());
      Board board = boards.get(findBoardIndex(inputBno));

      System.out.println("#".repeat(50));
      System.out.println("번호: " + board.getBNo());
      System.out.println("제목: " + board.getBTitle());
      System.out.println("내용: " + board.getBContent());
      System.out.println("작성자: " + board.getBWriter());
      System.out.println("날짜: " + board.getBDate());
      System.out.println("#".repeat(50));

      subMenu();
      int input = Integer.parseInt(br.readLine());

      switch (input) {
        case 1 -> {
          update(board);
          break Loop;
        }

        case 2 -> {
          delete(board);
          break Loop;
        }

        case 3 -> {
          break Loop;
        }
      }
    }
  }

  private static void update(Board board) throws IOException {
    System.out.println("\n[수정 내용 입력]");
    System.out.print("제목: ");
    String title = br.readLine();

    System.out.print("내용: ");
    String content = br.readLine();

    System.out.print("작성자: ");
    String writer = br.readLine();
    checkMenu();

    int input = Integer.parseInt(br.readLine());

    if (input == 1) {
      delete(board);

      boards.add(Board.builder()
          .bNo(board.getBNo())
          .bTitle(title)
          .bContent(content)
          .bWriter(writer)
          .bDate(new Date())
          .build());

      Collections.sort(boards, (Comparator.comparingInt(Board::getBNo)));
    }
  }

  private static void delete(Board board) {
    boards.remove(board);
  }

  private static void clear() throws IOException {
    System.out.println("\n[게시물 전체 삭제]");
    System.out.println("-".repeat(50));
    checkMenu();

    int input = Integer.parseInt(br.readLine());

    if (input == 1) {
      boards.clear();
    }
  }

  private static int findBoardIndex(int inputBno) {
    for (int i = 0; i < boards.size(); i++) {
      if (boards.get(i).getBNo() == inputBno) {
        return i;
      }
    }
    return -1;
  }
}
