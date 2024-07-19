package board.service.impl;

import board.connection.BoardDB;
import board.dto.Board;
import board.service.PrintService;

public class PrintServiceImpl implements PrintService {
  private final BoardDB boardDB = new BoardDB();

  @Override
  public void list() {
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

  @Override
  public void mainMenu() {
    System.out.println("-".repeat(50));
    System.out.println("메인 메뉴: 1. Create | 2. Read | 3. Clear | 4. Exit");
    System.out.print("메뉴 선택: ");
  }

  @Override
  public void subMenu() {
    System.out.println("-".repeat(50));
    System.out.println("보조 메뉴: 1. Update | 2. Delete | 3. List");
    System.out.print("메뉴 선택: ");
  }

  @Override
  public void checkMenu() {
    System.out.println("-".repeat(50));
    System.out.println("보조 메뉴: 1. OK | 2. Cancel");
    System.out.print("메뉴 선택: ");
  }
}
