//Codeforce 4A
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int w = Integer.parseInt(
            new BufferedReader(new InputStreamReader(System.in)).readLine()
        );

        System.out.println(w > 2 && w % 2 == 0 ? "YES" : "NO");
    }
}
