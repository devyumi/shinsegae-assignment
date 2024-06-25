package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1523 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n < 1 || n > 100 || m < 1 || m > 3) {
            sb.append("INPUT ERROR! ");
        } else if (m == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i + 1; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }
        } else if (m == 2) {
            int col = n;
            for (int i = 0; i < n; i++) {
                for (int j = col; j > 0; j--) {
                    sb.append("*");
                }
                col--;
                sb.append("\n");
            }
        } else if (m == 3) {
            int blank = n - 1;
            for (int i = 1; i <= n; i++) {
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
