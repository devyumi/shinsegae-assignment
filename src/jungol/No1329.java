package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1329 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        if (n < 1 || n > 100 || n % 2 == 0) {
            sb.append("INPUT ERROR! ");
        } else {
            int blank = 0;
            for (int i = 1; i <= n / 2 + 1; i++) {
                for (int j = 0; j < blank; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j < 2 * i - 1; j++) {
                    sb.append("*");
                }
                blank++;
                sb.append("\n");
            }

            blank -= 2;
            for (int i = n / 2; i >= 1; i--) {
                for (int j = 0; j < blank; j++) {
                    sb.append(" ");
                }
                for (int j = 0; j < 2 * i - 1; j++) {
                    sb.append("*");
                }
                blank--;
                sb.append("\n");
            }
        }
        System.out.print(sb.deleteCharAt(sb.length() - 1));
        br.close();
    }
}
