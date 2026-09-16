//1030A
import java.io.*;
class main{
	public static void main(String[] args) throws Exception{
	BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	String ans = "Easy";
	for(int i =0;i<n;i++){
		int num = Integer.parseInt(br.readLine());
		if(num == 1){
			ans = "Hard";
			}
		}
		System.out.println(ans);
	}
}
