//Codeforces 706B

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(a);

        int q = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();

        while (q-- > 0) {
            int x = Integer.parseInt(br.readLine());

            int low = 0, high = n;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (a[mid] <= x)
                    low = mid + 1;
                else
                    high = mid;
            }

            ans.append(low).append('\n');
        }

        System.out.print(ans);
    }
}
