import java.util.*;

public class Main {

    static final long MOD = 998244353;

    static long count(String s, int start) {
        long ways = 0;

        // Pattern starting with 0
        boolean possible0 = true;

        // Pattern starting with 1
        boolean possible1 = true;

        int expected0 = 0;
        int expected1 = 1;

        for (int i = start; i < s.length(); i += 2) {

            char c = s.charAt(i);

            if (c != '?' && c - '0' != expected0) {
                possible0 = false;
            }

            if (c != '?' && c - '0' != expected1) {
                possible1 = false;
            }

            expected0 ^= 1;
            expected1 ^= 1;
        }

        if (possible0) ways++;
        if (possible1) ways++;

        return ways;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            String s = sc.next();

            long evenWays = count(s, 0);
            long oddWays = count(s, 1);

            long answer = (evenWays * oddWays) % MOD;

            System.out.println(answer);
        }

        sc.close();
    }
}
