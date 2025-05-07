package slidingwindow;

public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanKBruteForce(int[] nums, int k) {
    	
    	int count = 0;
        for(int i = 0; i < nums.length; i++) {
        	int product = 1;
        	for(int j = i; j < nums.length; j++) {
        		product *= nums[j];
        		if(product >= k) {
        			break;
        		} else {
        			count++;
        		}
        	}
        }
        return count;
    }
    
public int numSubarrayProductLessThanK(int[] nums, int k) {
//  10,5,2,6
//  l
//         r
//         winlen = r - l + 1 = 4
//         10 
//         10,5 = 2
//         10,5,2
//         10,5,2,6
//
//  5,2,6
//          5
//          5,2 
//          5,2,6 = 3
//  2,6 
//          2
//          2,6 = 2
//  6
//          6 = 1
//          n*(n-1)/2 = (4 * 3)/2 = 6

	
		if(nums == null || nums.length <= 0|| k <= 1) return 0;
    	
    	int count = 0;
    	int left = 0;
    	int right = 0;
    	int product = 1;
    	
    	
    	while(right < nums.length) {
    		product *= nums[right];
    		
    		while(product >= k) {
    			// shrink the window from the left
    			product /= nums[left];
    			left++;
    		} 
    		// Intuition: wheever, we find a window with product < k
    		// we count the window size as number of subarray.
    		//When the window [left, right] is valid (product < k), 
    		// the number of subarrays ending at right is:
    		// you can start a subarray at any index from left to right.
    		// •	All of them will end at right.
    		
    		count += right - left + 1;
    		right++;
    	}
    	return count;
    }
    
	public static void main(String[] args) {
		SubarrayProductLessThanK ob = new SubarrayProductLessThanK();
		
//		int[] nums = {10,5,2,6};
//		int k = 100;
////		Output: 8
		
//		int[] nums = {1,2,3};
//		int k = 0;
//		Output: 0
		
//		int[] nums = {1,1,1};
//		int k = 1;
//		output: 0
		
		int[] nums = {57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
		int k = 18;
//		output: 1
				
		System.out.println(ob.numSubarrayProductLessThanK(nums, k));
	}

}
