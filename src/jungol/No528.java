package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No528 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        if (a < 0) {
            System.out.println(a);
            System.out.print("minus");
        } else {
            System.out.print(a);
        }
        br.close();
    }
}
