package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class No633 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Seoul");
        map.put(2, "Washington");
        map.put(3, "Tokyo");
        map.put(4, "Beijing");

        while (true) {
            System.out.println("1. Korea");
            System.out.println("2. USA");
            System.out.println("3. Japan");
            System.out.println("4. China");
            System.out.print("number? ");
            int n = Integer.parseInt(br.readLine());
            System.out.println();

            if (n < 1 || n > 4) {
                System.out.print("none");
                break;
            } else {
                System.out.println(map.get(n));
                System.out.println();
            }
        }
        br.close();
    }
}
