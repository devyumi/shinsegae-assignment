package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(br.readLine());
        if (n <= 50.8) {
            System.out.print("Flyweight");
        } else if (n > 50.8 && n <= 61.23) {
            System.out.print("Lightweight");
        } else if (n > 61.23 && n <= 72.57) {
            System.out.print("Middleweight");
        } else if (n > 72.57 && n <= 88.45) {
            System.out.print("Cruiserweight");
        } else {
            System.out.print("Heavyweight");
        }
        br.close();
    }
}
