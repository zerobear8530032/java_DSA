package mallicious;
import java.util.*;
public class BurstBallon {
	
	public static int numberofwaystoburstballons(int N, int k) {
		if (k < 1 || k > N) {
			return 0; 
		}
		if (k == 1 || k == N) {
			return 1; 
		}
		int c = N - 1;
		int left = k - 1;
		return nCr(c, left);
	}
	public static int nCr(int n, int r) {
		if (r > n || r < 0) {return 0; }
		int factn = factorial(n);
		int factr = factorial(r);
		int factnr = factorial(n - r);
		return (factn / (factr * factnr)) % 1000000000;
	}
	
	public static int factorial(int n) {
		int fact = 1;
		int mod = 1000000000;
		for (int i = 1; i <= n; i++) {
			fact = (fact * i) % mod;
		}
		return fact;
	}
	
	public static void main(String[] args) {
		System.out.println( numberofwaystoburstballons(3, 2));
		System.out.println( numberofwaystoburstballons(10, 5));
		System.out.println( numberofwaystoburstballons(5, 1));
		
	
		
	}
	

}
