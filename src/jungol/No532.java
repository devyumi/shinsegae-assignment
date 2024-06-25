package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double n = Double.parseDouble(st.nextToken());
        double m = Double.parseDouble(st.nextToken());

        if (n >= 4.0 && m >= 4.0) {
            System.out.print("A");
        } else if (n >= 3.0 && m >= 3.0) {
            System.out.print("B");
        } else {
            System.out.print("C");
        }
        br.close();
    }
}
