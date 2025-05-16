package hashtable.twoSum;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
	public int[] twoSum(int[] nums, int target) {
        if(nums.length <= 0) return new int[] {0,0};
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
        	int sum = nums[left] + nums[right];
        	if(sum < target) {
        		left++;
        	} else if (sum > target) {
        		right--;
        	} else {
        		res[0] = left + 1;
        		res[1] = right + 1;
        		return res;
        	}
        }
        return res;
	}
	public static void main(String[] args) {
		TwoSum2 ob = new TwoSum2();
		int[] numbers = {2,7,11,15};
		int target = 9;
//		Output: [1,2]

		ob.twoSum(numbers, target);
	}

}
