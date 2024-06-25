package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No124 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());

        switch (a) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.print(31);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.print(30);
                break;
            case 2:
                System.out.print(28);
                break;
        }
        br.close();
    }
}
