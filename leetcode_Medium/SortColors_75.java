//75. Sort Colors
//Solved
//Medium
//Topics
//Companies
//Hint
//Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//You must solve this problem without using the library's sort function.
//Example 1:
//Input: nums = [2,0,2,1,1,0]
//Output: [0,0,1,1,2,2]
//Example 2:
//Input: nums = [2,0,1]
//Output: [0,1,2]
//Constraints:
//n == nums.length
//1 <= n <= 300
//nums[i] is either 0, 1, or 2.
//Follow up: Could you come up with a one-pass algorithm using only constant extra space?

package leetcode_Medium;
public class SortColors_75 {
//	brute force approch- this approch dones the job but contrain allow us to solve it better way
//	approch : here we use bubble sort to sort the element to make them all to be sorted in ascending order.
// time complexity = O(n*n)
// space complexity =O(1)

	public static void sortColorsBrute(int[] nums) {
	        for(int i=0;i<nums.length;i++){
	         for(int j=i;j<nums.length;j++){
	            if(nums[i]>nums[j]){
	                int t=nums[i];
	                nums[i]=nums[j];
	                nums[j]=t;
	            }
	          }
	    }
	           
	    }
//	Optimal approch:
//	here we find the count of 0,1,2 
//	so we created 3 var (c0,c1,c2) these keep count of 0,1,2 now we will start first pass and increment the var every time we encounter variable
//	now once first pass complete we will have the count of 0,1,2 of c0,c1,c2
//	nnow we will start second pass on entire array 
//	and assign the 0 in c0 on index i<c0 
//	assign the 1 in c1 on index i<c1
//	assign the 2 in c2 on index i<c2
//	on the second pass we would completed the task 
//	 dry run :
//	 [2,0,2,1,1,0]
//	c0,c1,c2=0;
//	first pass :for(i=0;i<nums.length;i++)
//	nums[0]=2 then c2=c2+1; 
//	nums[1]=0 then c0=c0+1;
//	nums[2]=2 then c2=c2+1;
//	nums[3]=1 then c1=c0+1;
//	nums[4]=1 then c1=c1+1;
//	nums[5]=0 then c0=c0+1;
	
//	once this pass is done c0=2, c1=2,c3=2
//	now we will start the second pass:
//	second pass :for(i=0;i<nums.length;i++)	
//	if(i<c0) then nums[i]=0;
//	else if(i<(c1+c0)) then nums[i]=1;
//	else(i<c2) then nums[i]=2;
	
//	i=0
//	if block(0<c0) so then (nums[0]=0);
//	if block(1<c0) so then (nums[1]=0);
//	else if block(2<(c0+c1)) so then (nums[2]=1);
//	else if block(3<(c0+c1)) so then (nums[3]=1);	
//	else block so then (nums[4]=2);
//	else block so then (nums[5]=2);
	
	
	public static void sortColorsOptimal(int[] nums) {
        int c0=0;
        int c1=0;
        int c2=0;
        int l =nums.length;
        // first pass count number of occurence of every color:
        for(int i =0;i<l;i++){
            if(nums[i]==0){
                c0++;
            }
            if(nums[i]==1){
                c1++;
            }
            if(nums[i]==2){
                c2++;
            }

        }
        // second pass fill the colors in the array :
        for(int i =0;i<l;i++){
            if(i<c0){
                nums[i]=0;
            }else if(i<(c0+c1)){
                nums[i]=1;
            }else{
                nums[i]=2;
            }
        }
    }
	
	static boolean check(int [] ans ,int [] out) {
		if(ans.length!=out.length) {
			return false;
		}
		for(int i =0;i<ans.length;i++) {
			if((ans[i]!=out[i])) {
				return false;
			}
		}
		return true;
	}
public static void main(String args[]) {
	//Example 1:
	int []nums1 = {2,0,2,1,1,0};
	int []output1={0,0,1,1,2,2};
	//Example 2:
	int []nums2 = {2,0,1};
	int []output2={0,1,2};
	
	sortColorsOptimal(nums1);
	sortColorsOptimal(nums2);
	
	if(check(nums1,output1)) {
		System.out.println("Case 1 Passed ");
	}else {
		System.out.println("Case 1 Failed");
	}
	if(check(nums2,output2)) {
		System.out.println("Case 2 Passed ");
	}else {
		System.out.println("Case 2 Failed");
	}
		
		
		
	
}
}
