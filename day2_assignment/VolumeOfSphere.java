package day2_assignment;
import java.util.Scanner;
public class VolumeOfSphere {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the Radius: ");
	double r=sc.nextDouble();
	double volume=(4.f/3.f)*Math.PI*Math.pow(r, 3);
	System.out.println("Perimeter : "+volume);
}

}
