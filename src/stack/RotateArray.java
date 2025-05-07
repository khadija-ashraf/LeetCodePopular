package stack;

import java.awt.Dialog;

public class RotateArray {
    public void rotate(int[] nums, int k) {
    	
    	
    	int n = nums.length;
    	int start = 0;
    	int last = n - k;
    	
        divNcon(nums, k, start, last);
    }
    
    
    private void swap(int[] nums, int k, int start, int last) {
    	int len = start + k;
    	int last = nums.length - k;

    	while(start < len && start < nums.length && last < nums.length) {
    		int temp = nums[start];
    		nums[start] = nums[last];
    		nums[last] = temp;
    		start++;
    		last++;
    	}
    }
	public static void main(String[] args) {
		RotateArray ob = new RotateArray();
		
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
//		Output: [5,6,7,1,2,3,4]

		ob.rotate(nums, k);
	}

}
