package board.exec;

import board.service.BoardService;
import board.service.PrintService;
import board.service.impl.BoardServiceImpl;
import board.service.impl.PrintServiceImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BoardExample {

  private static final BoardService boardService = new BoardServiceImpl();
  private static final PrintService printService = new PrintServiceImpl();
  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    Loop:
    while (true) {
      printService.list();
      String input = br.readLine();

      switch (input) {
        case "1" -> boardService.create();

        case "2" -> boardService.read();

        case "3" -> boardService.clear();

        case "4" -> {
          System.out.println("** 게시판 종료 **");
          br.close();
          break Loop;
        }

        default -> System.out.println("\n** 다시 입력해주세요.**\n");
      }
    }
  }
}
