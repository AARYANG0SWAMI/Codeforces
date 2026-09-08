//Codeforces 2182B
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            int ans1 = solve(a, b);
            int ans2 = solve(b, a);

            System.out.println(Math.max(ans1, ans2));
        }
    }

    static int solve(int a, int b) {
        int layers = 0;
        int size = 1;

        while (true) {
            if (layers % 2 == 0) {
                if (a < size) break;
                a -= size;
            } else {
                if (b < size) break;
                b -= size;
            }

            layers++;
            size *= 2;
        }

        return layers;
    }
}
