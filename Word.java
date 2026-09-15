//Codeforces 59A
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int lower = 0;

        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                lower++;

        System.out.println(lower > s.length() / 2
                ? s.toLowerCase()
                : s.toUpperCase());
    }
}
