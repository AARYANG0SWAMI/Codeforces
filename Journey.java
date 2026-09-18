//Codeforces 2051B
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String[] s = br.readLine().split(" ");

            long n = Long.parseLong(s[0]);
            long a = Long.parseLong(s[1]);
            long b = Long.parseLong(s[2]);
            long c = Long.parseLong(s[3]);

            long sum = a + b + c;

            long days = (n / sum) * 3;
            long remaining = n % sum;

            if (remaining == 0) {
                System.out.println(days);
            } else if (remaining <= a) {
                System.out.println(days + 1);
            } else if (remaining <= a + b) {
                System.out.println(days + 2);
            } else {
                System.out.println(days + 3);
            }
        }
    }
}
