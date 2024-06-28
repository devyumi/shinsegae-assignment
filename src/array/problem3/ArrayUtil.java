package array.problem3;

public class ArrayUtil {

  public static void main(String[] args) {
    char[] s = {'J', 'a', 'v', 'a', 'P', 'r', 'o', 'g', 'r', 'a', 'm'};
    ArrayUtil util = new ArrayUtil();
    util.reverseString(s, 0, 1);
    for (char c : s) {
      System.out.print(c);
    }
  }

  public char[] reverseString(char[] s, int start, int end) {
    char[] arr = new char[end - start + 1];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = s[end--];
    }

    for (int i = 0; i < arr.length; i++) {
      s[start++] = arr[i];
    }
    return s;
  }
}
