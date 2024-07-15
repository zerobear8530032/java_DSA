package day2_assignment;
import java.util.Scanner;
public class ElectricityBill {
public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Previous month reading :");
	float prev=sc.nextFloat();
	System.out.println("Enter the current month reading :");
	float curr=sc.nextFloat();
	float energyconsume=curr-prev;
	System.out.println("Enter the tariff rate:");
	float tariff=sc.nextFloat();
	float totalenergyconsume=tariff*energyconsume;
	System.out.println("total energy consume :"+totalenergyconsume);
	
	
	
	
}
}
