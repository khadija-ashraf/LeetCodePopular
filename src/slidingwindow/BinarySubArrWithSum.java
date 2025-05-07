package slidingwindow;

public class BinarySubArrWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubArr(nums, goal) - countSubArr(nums,  goal - 1);
    }
    
    private int countSubArr(int[] nums, int goal) {
    	if(goal < 0) return 0;
    	int left = 0;
    	int right = 0;
    	int count = 0;
    	
    	int sum = 0;
    	
    	while(right < nums.length) {
    		sum += nums[right];
    		
    		while(sum > goal) {
    			sum -= nums[left];
    			left++;
    		}
			count += right - left + 1;
    		right++;
    	}
    	return count;
    }
    
	public static void main(String a[]) {
		BinarySubArrWithSum ob = new BinarySubArrWithSum();
		
		int[] nums = {1,0,1,0,1};
		int goal = 2;
//		Output: 4
		
		System.out.println(ob.numSubarraysWithSum(nums, goal));
	}
}
