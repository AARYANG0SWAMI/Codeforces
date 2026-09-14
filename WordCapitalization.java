//Codeforces 281A
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.print(Character.toUpperCase(s.charAt(0)));
        System.out.print(s.substring(1));
    }
}
