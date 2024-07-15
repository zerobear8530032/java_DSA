package day2_assignment;
import java.util.Scanner;
public class productsumofdigits {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Number: ");
	int x =sc.nextInt();
	 int sum=0;
	 int pro=1;
	 while(x>0) {
		 int rem =x%10;
		 sum=sum+rem;
		 pro=pro*rem;
		 x=x/10;
	 }
	 System.out.println("sum :"+sum);
	 System.out.println("product :"+pro);
	 System.out.println("difference :"+(pro-sum));
	 
}

}
