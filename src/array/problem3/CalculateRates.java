package array.problem3;

public class CalculateRates {

  public static void main(String[] args) throws Exception {
    CalculateRates calculateRates = new CalculateRates();

    // 비율 결과: 6.0%, 2.0%, 12.0%, 49.0%, 31.0%
    calculateRates.calculate(new int[]{10, 30, 20, 80, 50});

    // 비율 결과: 20.0%, 20.0%, 20.0%, 20.0%, 20.0%
    calculateRates.calculate(new int[]{50, 50, 50, 50, 50});

    // 비율 결과: 7.0%, 13.0%, 20.0%, 27.0%, 33.0%
    calculateRates.calculate(new int[]{1, 2, 3, 4, 5});
  }

  public void calculate(int[] nums) throws Exception {
    double[] doubleArr = new double[5];
    double sum = 0;

    for (int i : nums) {
      sum += i;
    }

    for (int i = 0; i < nums.length; i++) {
      doubleArr[i] = nums[i] / sum * 100;
      doubleArr[i] = (double) Math.round(doubleArr[i]);
      for (int j = 0; j < Math.floor(doubleArr[i]); j++) {
        System.out.print("*");
      }
      System.out.printf(" (%.1f%%)\n", doubleArr[i]);
    }
  }
}
