import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int last = 0;
        int max = -1;

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int candies = Integer.parseInt(st.nextToken());

            int rounds = (candies + m - 1) / m;

            if (rounds >= max) {
                max = rounds;
                last = i;
            }
        }

        System.out.println(last);
    }
}
