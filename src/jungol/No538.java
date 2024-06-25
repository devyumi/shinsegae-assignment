package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No538 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("number? ");
            int a = Integer.parseInt(br.readLine());

            if (a == 0) {
                break;
            }

            if (a > 0) {
                System.out.println("positive integer");
            } else {
                System.out.println("negative number");
            }
        }
        br.close();
    }
}
