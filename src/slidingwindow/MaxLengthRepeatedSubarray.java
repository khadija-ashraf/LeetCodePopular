package slidingwindow;

public class MaxLengthRepeatedSubarray {

    public int findLength(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        int maxLen = Integer.MIN_VALUE;
        
        for(int i = 1; i <= nums1.length; i++) {
        	
        	int[] tempDp = new int[nums2.length + 1];
        	
        	for(int j = 1; j <= nums2.length; j++) {
        		if(nums1[i-1] == nums2[j-1]) {
        			tempDp[j] = dp[j-1] + 1;
        			if(tempDp[j] > maxLen) {
        				maxLen = tempDp[j];
        			}
        		}
        	}
        	dp = tempDp;
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
    
	public static void main(String[] args) {
		MaxLengthRepeatedSubarray ob = new MaxLengthRepeatedSubarray();
		
//		int[] nums1 = {1,2,3,2,1};
//		int[] nums2 = {3,2,1,4,7};
//		Output: 3
		
		int[] nums1 = {0,0,0,0,0};
		int[] nums2 = {0,0,0,0,0};
//		Output: 5
				
		System.out.println(ob.findLength(nums1, nums2));
	}

}
