package jungol.assignment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No533 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char c = st.nextToken().charAt(0);
        int n = Integer.parseInt(st.nextToken());

        if (c == 'M') {
            if (n >= 18) {
                System.out.print("MAN");
            } else {
                System.out.print("BOY");
            }
        } else {
            if (n >= 18) {
                System.out.print("WOMAN");
            } else {
                System.out.print("GIRL");
            }
        }
        br.close();
    }
}
