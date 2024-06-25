package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double a = Double.parseDouble(br.readLine());

        if (a >= 4.0) {
            System.out.print("scholarship");
        } else if (a < 4.0 && a >= 3.0) {
            System.out.print("next semester");
        } else if (a < 3.0 && a >= 2.0) {
            System.out.print("seasonal semester");
        } else {
            System.out.print("retake");
        }
        br.close();
    }
}
