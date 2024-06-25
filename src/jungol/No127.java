package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No127 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        double cnt = 0;

        while (true) {
            int n = Integer.parseInt(st.nextToken());
            if (n > 100 || n < 0) {
                break;
            }
            sum += n;
            cnt++;
        }
        System.out.println("sum : " + sum);
        System.out.printf("avg : %.1f", sum / cnt);
        br.close();
    }
}
