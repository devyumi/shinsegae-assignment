package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No539 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        double cnt = 0;

        while (true) {
            int n = Integer.parseInt(st.nextToken());
            sum += n;
            cnt++;

            if (n >= 100) {
                break;
            }
        }
        System.out.println(sum);
        System.out.printf("%.1f", sum / cnt);
        br.close();
    }
}
