package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No534 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = br.readLine().charAt(0);

        switch (c) {
            case 'A':
                System.out.print("Excellent");
                break;
            case 'B':
                System.out.print("Good");
                break;
            case 'C':
                System.out.print("Usually");
                break;
            case 'D':
                System.out.print("Effort");
                break;
            case 'E':
                System.out.print("error");
                break;
            case 'F':
                System.out.print("Failure");
                break;
        }
        br.close();
    }
}
