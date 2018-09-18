import java.util.*;
public class PrimeTester{    
	public static void main(String args[]){
		int num = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("Enter a integer:");
		num  = input.nextInt();
		isPrime(num);
	}
	
	public static void isPrime(int n){
		int count = 0;
		for(int i = 2;i < n;i++){
			if (n % i == 0){
				count ++;
			}
		}
		if (count != 0){
			System.out.println("Not Prime");
		}
		else{
			System.out.println("Prime");
		}
	}
}
