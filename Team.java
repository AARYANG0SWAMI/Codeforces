// Codeforces 231A
import java.util.Scanner;
public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int implement=0;
		for(int i =0;i<n;i++){
			int count = 0;
			for(int j = 0 ;j<3;j++){
				   int temp  = sc.nextInt();
				if(temp == 1){
					count++;
		 			}
				}
				 if(count>=2)
                                        implement++; 
		}
		System.out.println(implement);
	}
}
