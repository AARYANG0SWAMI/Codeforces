// codeforces 155A
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int first = sc.nextInt();

        int min = first;
        int max = first;
        int ans = 0;

        for (int i = 1; i < n; i++) {
            int x = sc.nextInt();

            if (x < min) {
                min = x;
                ans++;
            } else if (x > max) {
                max = x;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
