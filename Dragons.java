//Codeforces 230A
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] d = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            d[i][0] = Integer.parseInt(st.nextToken());
            d[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(d, Comparator.comparingInt(a -> a[0]));

        for (int[] dragon : d) {
            if (s <= dragon[0]) {
                System.out.println("NO");
                return;
            }
            s += dragon[1];
        }

        System.out.println("YES");
    }
}
