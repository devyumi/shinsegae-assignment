package array.problem3;

public class Prob09 {

  public static void main(String[] args) {
    char[][] alphabet = new char[5][5];
    char start = 'A';

    //1.배열에 알파벳 입력
    for (int i = 0; i < alphabet.length; i++) {
      for (int j = 0; j < alphabet[i].length; j++) {
        alphabet[i][j] = start++;
      }
    }

    //2.원본 배열 출력
    System.out.println("\t\t\t\t원본 배열");
    System.out.println("=============================");
    for (int i = 0; i < alphabet.length; i++) {
      for (int j = 0; j < alphabet[i].length; j++) {
        System.out.printf("%-5c", alphabet[i][j]);
      }
      System.out.println();
    }

    //3. 배열 수정
    for (int i = 0; i < alphabet.length; i++) {
      for (int j = 0; j < alphabet[i].length; j++) {
        if (i == j) {
          alphabet[i][j] = '*';
        }
      }
    }

    //4. 수정된 배열 출력
    System.out.println("\n\t\t\t\t수정된 배열");
    System.out.println("=============================");
    for (int i = 0; i < alphabet.length; i++) {
      for (int j = 0; j < alphabet[i].length; j++) {
        System.out.printf("%-5c", alphabet[i][j]);
      }
      System.out.println();
    }
  }
}

