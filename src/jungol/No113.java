package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken()) + 5;
        int length = Integer.parseInt(st.nextToken()) * 2;

        System.out.println("width = " + width);
        System.out.println("length = " + length);
        System.out.print("area = " + width * length);
        br.close();
    }
}
