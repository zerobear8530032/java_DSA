//15. 3Sum
//Attempted
//Medium
//Topics
//Companies
//Hint
//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
//
// 
//
//Example 1:
//
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation: 
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
//Example 2:
//
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//Example 3:
//
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
// 
//
//Constraints:
//
//3 <= nums.length <= 3000
//-105 <= nums[i] <= 105
package BinarySearchQuestions;
import java.util.*;
public class ThreeSum_15 {
//	Brute force approch uses every single possible combination to find the output :
//	time complexity : O(n*n*n)
//	space complexity :O(n^3)
	public static List<List<Integer>> threeSumBruteForce(int[] nums) {
	    List<List<Integer>> ans = new ArrayList();
	        HashSet<ArrayList<Integer>> set = new HashSet();
	        for(int i =0;i<nums.length;i++){
	            for(int j =i+1;j<nums.length;j++){
	                for(int k =j+1;k<nums.length;k++){
	                    if(nums[i]+nums[j]+nums[k]==0){
	                       ArrayList<Integer> list = new ArrayList();
	                       list.add(nums[i]);
	                       list.add(nums[j]);
	                       list.add(nums[k]);
	                       Collections.sort(list); 
	                       set.add(list);
	                    }
	                }
	            }
	        }
	        for(ArrayList<Integer> l:set){
	            ans.add(l);
	        }

	        return ans;
	}
	    
	public  static boolean check (List<List<Integer>> ans,List<List<Integer>> output  ) {
		if(ans.size()!=output.size()) {
			return false;
		}
		if(ans.size()==0 && output.size()==0) {
			return true;
		}
		for(int i =0;i<output.size();i++) {
			Collections.sort(output.get(i));
		}
		
		for(int i =0;i<ans.size();i++) {
			for(int j =0;j<ans.get(i).size();j++) {
				if(ans.get(i).get(j)!=output.get(i).get(j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
//	Binary search approch:
//	 here we loop like brute force approch but with 2 elemet and search third one by sorting the array and search
//	using binary search :
	    
//	timecomplexity O(n^2 lon n)
//	space complexity = O(1)
	
	public static List<List<Integer>> threeSumBinarySearch(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for(int i =0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1]){continue;}
            for(int j =i+1;j<nums.length;j++){
                 if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int target= 0-(nums[i]+nums[j]);
                int k = BinarySearch(nums,j+1,nums.length-1,target);
                if(k>j){
                    ans.add( Arrays.asList(nums[i],nums[j],nums[k]));
                }
            }
        }
        return ans;
    }

    public static int BinarySearch(int[]nums,int start,int end,int target){
        while(start<=end){
            int mid = start+(end-start)/2;
        if(target==nums[mid]){
            return mid;
        }else if(nums[mid]<target){
            start=mid+1;
        }else{
            end=mid-1;
        }
        }
    return -1;
    }
    
//    Extra space approch :
//    here we store the element in a hash set each time we see a triplet and this allow to remove 1 loop completelu
//   time complexity : O(n^2) 
//   space complexity : O(n^2) 
    
        public static List<List<Integer>> threeSumExtraSpace(int[] nums) {
            HashSet<ArrayList<Integer>> setoftriplets = new HashSet();
            List<List <Integer>> ans = new ArrayList();
         for(int i =0;i<nums.length;i++){
            HashSet <Integer> temp= new HashSet();
            for(int j = i+1;j<nums.length;j++){
                int target =-(nums[i]+nums[j]);
                if(temp.contains(target)){
                    ArrayList<Integer> triplets=new ArrayList();
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(target);
                    Collections.sort(triplets);
                setoftriplets.add(triplets);
                }
                temp.add(nums[j]);
            }
         }
         for(ArrayList<Integer> list:setoftriplets){
            ans.add(list);
         }
         return ans;   
        }
// mutiple pointer:
//        here we have 3 pointer 
//        we first sort array
//        1 -> at start
//        2 -> start+1
//        3-> at end
//        now we check is sum of all is 0
//        if yes add to the ans
//        else if sum is smaller then we will increment second pointer untill its  equal to its prevoius element 
//        same if the sum if greater we will decrement the end with 1 and we keep decreemnenting them
//        until we see ists prevoius element equal to new element 
//        at last we return answer 
//        time complexity : O(n^2)
//        space complexity :O(n^2)
        
            public static List<List<Integer>> threeSumOptimize(int[] nums) {
//                sort
            	Arrays.sort(nums);
//                ans list
                List<List<Integer>> ans = new ArrayList();
//               i will increment each iteration
                for(int i =0;i<nums.length;i++){
//                	if next element is equal to privous we skip it 
                    if(i>0 && nums[i]== nums[i-1]){continue;}
//                    initialize start and end pointer
                    int j = i+1;
                    int k = nums.length-1;
//                    loop
                while(j<k){
//                	target calculation
                    int sum=nums[i]+nums[j]+nums[k];
//                    if target > sum we incremnet start 
                    if(sum<0){
                        j++;
//                        if target< sum we decrement start

                    }else if(sum>0){
                        k--;
//                        else means we find our triplets
                    }else{
                        ArrayList<Integer> triplets = new ArrayList();
                        triplets.add(nums[i]);
                        triplets.add(nums[j]);
                        triplets.add(nums[k]);
                        ans.add(triplets);
                        j++;
                        k--;
                        while(j<k && nums[j]==nums[j-1]){j++;}
                        while(j<k && nums[k]==nums[k+1]){k--;}
                    }
                }
                }
                return ans;
            }
        
	
	public static void main(String[] args) {
		System.out.println("Brute Force approch ");
		//Example 1:
		//
		int [] nums1 = {-1,0,1,2,-1,-4};
		List<List<Integer>> output1 = new ArrayList<>(Arrays.asList(new  ArrayList(Arrays.asList(-1,-1,2)),new  ArrayList(Arrays.asList(-1,0,1))));
		List<List<Integer>> ans1= threeSumBruteForce(nums1); 
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		 
		 
		//Explanation: 
		//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
		//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
		//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
		//The distinct triplets are [-1,0,1] and [-1,-1,2].
		//Notice that the order of the output and the order of the triplets does not matter.
		//Example 2:
		//
		int [] nums2 = {0,1,1};
		List<List<Integer> > output2 = new ArrayList<>();
		List<List<Integer> > ans2=threeSumBruteForce(nums2);
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		
		//Explanation: The only possible triplet does not sum up to 0.
		//Example 3:
		
		int [] nums3 = {0,0,0};
		List<List<Integer> > output3 = new ArrayList<>(Arrays.asList(new  ArrayList(Arrays.asList(0,0,0))));
		//Explanation: The only possible triplet sums up to 0.
		List<List<Integer> > ans3=threeSumBruteForce(nums3);
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
//		Binary search approch:
		
		System.out.println("Binary search approch ");
		
		ans1=threeSumBinarySearch(nums3);
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		
		
		ans2=threeSumBinarySearch(nums2);
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}
		
		ans3=threeSumBinarySearch(nums3);
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
		
		
//		Extra space approch:
		
		System.out.println("Extra Space approch ");
		
		ans1=threeSumExtraSpace(nums1);
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		ans2=threeSumExtraSpace(nums2);
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}		
		ans3=threeSumExtraSpace(nums3);
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}
		
		
//		Optimal approch:
		
		System.out.println("Optimal approch ");
		
		ans1=threeSumOptimize(nums1);
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");			
		}
		ans2=threeSumOptimize(nums2);
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");			
		}		
		ans3=threeSumOptimize(nums3);
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");			
		}

	}

}
