package slidingwindow.atmost;


public class BinarySubArrWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
    	return atMost(nums, goal) - atMost(nums, goal - 1);
    }
    
    private int atMost(int[] nums, int goal) {
    	if(goal < 0) return 0;

    	int left = 0;
    	int right = 0;
    	
    	int count = 0;
    	int sum = 0;
    	
    	while(right < nums.length) {
    		sum += nums[right];
    		
    		// shrink window if invalid
    		while(sum > goal) {
    			sum -= nums[left];
    			left++;
    		}
    		count += right-left + 1;
    		right++;
    	}
    	return count;
    }
    
	public static void main(String[] args) {
		BinarySubArrWithSum ob = new BinarySubArrWithSum();
//		int[] nums = {1,0,1,0,1};
//		int goal = 2;
//		Output: 4
		
		int[] nums = {0,0,0,0,0};
		int goal = 0;
//		Output: 15
				
		System.out.println(ob.numSubarraysWithSum(nums, goal));
	}
}
