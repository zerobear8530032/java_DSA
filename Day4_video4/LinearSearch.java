package Day4_video4;

public class LinearSearch {
	public static int LinearSearch(int [] nums, int target) {
		for(int i =0;i<nums.length;i++) {
			if(nums[i]==target) {
				return i;
			}
		}
		return -1;
	}
public static void main(String[] args) {
	int arr[]= {2,432,4,2,32,1,34,6,43,61,3,79,8};
	int target=6;
	LinearSearch(arr, 6);
}
}
