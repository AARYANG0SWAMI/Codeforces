//codeforces 313B
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();

        int[] prefix = new int[n];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];

            if (s.charAt(i) == s.charAt(i - 1)) {
                prefix[i]++;
            }
        }

        int q = Integer.parseInt(br.readLine());

        StringBuilder out = new StringBuilder();

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            out.append(prefix[r - 1] - prefix[l - 1])
               .append('\n');
        }

        System.out.print(out);
    }
}
