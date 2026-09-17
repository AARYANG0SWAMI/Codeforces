import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        String ans = "Easy";

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (num == 1) {
                ans = "Hard";
            }
        }

        System.out.println(ans);
    }
}
