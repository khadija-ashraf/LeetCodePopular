package slidingwindow.atmost;

public class CountNoOfNiceSubArr {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }
    
    private int atMost(int[] nums, int k) {
    	if(k < 0) return 0;
        int left = 0;
        int right = 0;
        int count = 0;
        
        while(right < nums.length) {
        	// expand toward right
        	if(nums[right] % 2 == 1) {
        		k--;
        	}
        	//shrink the window from the left until invalid
        	while(k < 0) {
        		if(nums[left] % 2 == 1) {
        			k++;
        		}
        		left++;
        	}
        	//update result
        	count += right - left + 1;
        	right++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		CountNoOfNiceSubArr ob = new CountNoOfNiceSubArr();
		int[] nums = {1,1,2,1,1};
		int k = 3;
//		Output: 2
		
		System.out.println(ob.numberOfSubarrays(nums, k));

	}

}
