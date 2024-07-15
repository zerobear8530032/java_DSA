//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//Increment the large integer by one and return the resulting array of digits.
//Example 1:
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
//Example 2:
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].
//Example 3:
//Input: digits = [9]
//Output: [1,0]
//Explanation: The array represents the integer 9.
//Incrementing by one gives 9 + 1 = 10.
//Thus, the result should be [1,0].
//Constraints:
//1 <= digits.length <= 100
//0 <= digits[i] <= 9
//digits does not contain any leading 0's
package leetcode_Easy;
public class PlusOne {
//	approch simple : just create a variable which will keep the sum of 1+ num[i] here its k 
// and create a array of length same as input array 
// now we iterate the loop from l to 0 index by adding the num[i[ to k and add the k%10 to the result array at the end of the array 	
//	now the above will be good when the number of digit does not change but that not the case every time so we need to make sure we have a way to increase the array length if the digit got increased 
//	so we create another function which will create a new array with l+1 of input array and add than element at the head or first as a linked list
//	now we can handdle the last carry over left with  this method by creating a loop k>0 and add the k%10 in the res array and k/10 will make sure the k will get 0 eventually:
//	the time complexity :
//	O(n*n+1)
//	time complexity will be the o(n+1)
public	static 	int [] addfirst(int arr[],int e){
        int l =arr.length;
        int iarr[] = new int [l+1];
        for(int i =l-1;i>=0;i--){
            iarr[i]=arr[i];
        }
        iarr[0]=e;
        return iarr;
    }
public static int[] plusOne(int[] digits) {
        int k =1;
        int l =digits.length;
        int res [] = new int [l];        
        for(int i =l-1;i>=0;i--){
            k=k+digits[i];
            res[i]=k%10;
            k=k/10;
        }
        while(k>0){
            res=addfirst(res,(k%10));
            k=k/10;
        }
            return res;
    }

static boolean check(int [] ans ,int out[]) {
	if(ans.length!=out.length) {
		return false;
	}
	for(int i =0;i<ans.length;i++) {
		if(!(ans[i]==out[i])) {
			return false;
		}
	}
	
	return true;
}
public static void main(String args[]) {
	int n1[]= {1,2,3};
	int o1[]= {1,2,4};
	int n2[]= {4,3,2,1};
	int o2[]= {4,3,2,2};
	int n3[]= {9};
	int o3[]= {1,0};
	
	int []case1=plusOne(n1);
	int []case2=plusOne(n2);
	int []case3=plusOne(n3);
	
	if(check(case1,o1)) {
		System.out.println("Case 1 Passed");
	}else {
		System.out.println("Case 1 Failed");
	}
	
	if(check(case2,o2)) {
		System.out.println("Case 2 Passed");
	}else {
		System.out.println("Case 2 Failed");
	}
	
	if(check(case1,o1)) {
		System.out.println("Case 3 Passed");
	}else {
		System.out.println("Case 3 Failed");
	}
	
}
}
