package slidingwindow;

public class MinimumSubarrayLength {

    public int minimumSubarrayLength(int[] nums, int k) {
        
        int minLen = Integer.MAX_VALUE;
        
        for(int left = 0; left < nums.length; left++) {
            int orVal = 0;
            for(int right = left; right < nums.length; right++) {
            	orVal = orVal | nums[right];
            	
            	if(orVal >= k) {
            		minLen = Math.min(minLen, right-left + 1);
            		break;
            	}
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
    
	public static void main(String[] args) {
		MinimumSubarrayLength ob = new MinimumSubarrayLength();
		int[] nums = {1,2,3};
		int k = 2;

//		Output: 1
		
		System.out.println(ob.minimumSubarrayLength(nums, k));

	}

}
