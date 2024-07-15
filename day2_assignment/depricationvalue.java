package day2_assignment;
import java.util.Scanner;
public class depricationvalue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Deprication factor");
		float dp =sc.nextFloat();
		
		System.out.println("Enter the life span in years");
		int years=sc.nextInt();
		System.out.println("Enter the Remaining book value");
		float remaning=sc.nextFloat();
		float depvalue=dp*(1.f/years)*remaning;
		System.out.println("commition :"+depvalue);
	}

}

