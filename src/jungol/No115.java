package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height1 = Integer.parseInt(st.nextToken());
        int weight1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int height2 = Integer.parseInt(st.nextToken());
        int weight2 = Integer.parseInt(st.nextToken());

        if (height1 > height2 && weight1 > weight2) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
        br.close();
    }
}
