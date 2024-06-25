package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No126 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int odd = 0;
        int even = 0;

        while (true) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) {
                break;
            }
            if (n % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        System.out.println("odd : " + odd);
        System.out.print("even : " + even);
        br.close();
    }
}
