package leetcode_Easy;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.HashMap;
import java.util.Set;

public class LCM {
	public static  int lcm(int n) {
		HashMap<Integer,Integer> map= new HashMap();
		int res=1;
		int i =2;
		int c =i;
		while(n>1) {
			if(n%i==0) {
				n=n/i;
				res=res*i;
				if(map.containsKey(i)) {
					map.put(i, map.get(i)+1);
				}else {
					map.put(i, 1);					
				}
			}else {
				i++;
			}
		}
		int lcm=1;
		System.out.print(map);
		for(Entry<Integer, Integer> e: map.entrySet()) {
			lcm=lcm*e.getKey()*(e.getValue()/2);
		}
		return lcm;
	}
	
public static void main(String[] args) {
	System.out.println(lcm(5));
	
}
}
