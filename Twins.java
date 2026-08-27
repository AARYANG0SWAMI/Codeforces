//Codeforces 160A
import java.util.Scanner;
import java.util.Arrays;
public class Main{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int coin[] = new int[n];
	int total = 0;
	for(int i =0;i<n;i++){
		coin[i] = sc.nextInt();
		total += coin[i];
		}
	Arrays.sort(coin);
	int coins =0;
	int sum = 0;
	for(int i =n-1;i>=0;i--){
		sum += coin[i];
		coins++;
		if(sum > (total-sum)){
		System.out.println(coins);
		break;
		}
	}
	sc.close();
	}
}
