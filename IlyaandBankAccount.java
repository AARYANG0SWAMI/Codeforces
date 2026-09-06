import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n >= 0) {
            System.out.println(n);
        } else {
            n = -n;

            int option1 = n / 10;                    // remove last digit
            int option2 = (n / 100) * 10 + n % 10; // remove second-last digit

            System.out.println(-Math.min(option1, option2));
        }
    }
}
