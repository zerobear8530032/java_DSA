package Day2_video2;
import java.util.Scanner;
public class FindNumberOfOccurence {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int c =0;
	System.out.println("Enter the Number :");
	int x =sc.nextInt();
	System.out.println("Enter the Number whose occurence to Find :");
	int f =sc.nextInt();
	while(x>0) {
		if((x%10)==f) {
			c++;
		}
		x=x/10;
	}
	System.out.println("count"+c);
	
}
}
