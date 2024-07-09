package string.problem3;

public class FindNumbers {

  public static void main(String[] args) {
    FindNumbers fn = new FindNumbers();

    long number = 228754462;
    System.out.println("입력 숫자 = " + number);
    System.out.println("2 횟수 => " + fn.countNumber(number, 2));//3을 리턴
    System.out.println("4 횟수 => " + fn.countNumber(number, 4));//2를 리턴
  }

  public int countNumber(long number, int i) {
    int div = 1;
    int answer = 0;

    //number 자리수 만큼 계산
    do {
      div *= 10;
    } while (number / div > 0);

    //number / 자리수의 값이 i이면 i의 개수를 추가한다.
    while (div >= 1) {
      if (number / div == i) {
        answer++;
      }
      number %= div;
      div /= 10;
    }

    return answer;
  }
}