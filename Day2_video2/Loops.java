package Day2_video2;
import java.util.Scanner;
public class Loops {
	public static void main(String args[]) {
//		print table :
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number");
		int x =sc.nextInt();
		for(int i =1;i<11;i++) {
			System.out.println(x+" * "+i+" = "+(x*i));
		}
	}
}
