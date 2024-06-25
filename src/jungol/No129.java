package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No129 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Base = ");
            int a = Integer.parseInt(br.readLine());
            System.out.print("Height = ");
            int b = Integer.parseInt(br.readLine());
            System.out.println("Triangle width = " + String.format("%.1f", a * b / 2.0));
            System.out.print("Continue? ");
            char c = br.readLine().charAt(0);

            if (!(c == 'Y' || c == 'y')) {
                break;
            }
        }
        br.close();
    }
}
