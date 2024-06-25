package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Number? ");
        int a = Integer.parseInt(br.readLine());

        if (a == 1) {
            System.out.print("dog");
        } else if (a == 2) {
            System.out.print("cat");
        } else if (a == 3) {
            System.out.print("chick");
        } else {
            System.out.print("I don't know.");
        }
        br.close();
    }
}
