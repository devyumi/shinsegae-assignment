package string.problem3;

public class FindCharacters {


  public static void main(String[] args) {
    FindCharacters fc = new FindCharacters();
    int count = fc.countChar("Boys, be ambitious", 'b');
    System.out.println(count);
  }

  public int countChar(String str, char c) {
    int answer = 0;

    for (char ch : str.toCharArray()) {
      if (ch == c) {
        answer++;
      }
    }

    return answer;
  }
}
