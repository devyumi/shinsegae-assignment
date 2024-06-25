package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No536 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 15; i++) {
            System.out.print(i);
            if (i != 15) {
                System.out.print(" ");
            }
        }
        br.close();
    }
}
