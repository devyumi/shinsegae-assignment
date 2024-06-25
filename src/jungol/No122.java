package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No122 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int year = Integer.parseInt(st.nextToken());
        if (year % 400 == 0) {
            System.out.print("leap year");
        } else if (year % 4 == 0 && year % 100 != 0) {
            System.out.print("leap year");
        } else {
            System.out.print("common year");
        }
        br.close();
    }
}
