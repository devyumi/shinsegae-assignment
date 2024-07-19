package board.service;

public interface PrintService {
  /**
   * 게시물 목록 출력 메서드
   */
  void list();

  /**
   * 메인 메뉴 출력 메서드
   */
  void mainMenu();

  /**
   * 서브 메뉴 출력 메서드. 게시물 조회 시 사용한다.
   */
  void subMenu();

  /**
   * 확인 메뉴 출력 메서드. 게시물 생성, 수정, 삭제 시 사용한다.
   */
  void checkMenu();
}
