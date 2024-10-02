//33.    a
//       B c
//       D e F
//       g H i J
//       k L m N o

package Patterns;

public class Pattern33 {
	
	public static void pattern33(int n) {
		char ch ='a';
		for(int row=1;row<=n;row++) {
			for(int col=1;col<=row;col++) {
				if(ch%2==1) {
					System.out.print((char)ch+" ");
				}else {
					System.out.print((char)(ch-32)+" ");					
				}
				ch+=1;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		pattern33(5);

	}
}
