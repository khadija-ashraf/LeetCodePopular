package hashtable.detectDuplicate;

import java.util.*;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	int left = 0;
    	
    	Set<Integer> set = new HashSet<>();
    	
    	for(int right = 0; right < nums.length; right++) {
    		if(set.contains(nums[right])) {
    			return true;
    		}
    		
    		set.add(nums[right]);
    		
    		while(set.size() > k) {
    			set.remove(nums[left]);
    			left++;
    		}
    	}
    	return false;
    }
	public static void main(String a[]) {
//		int[] nums = {1,2,3,1};
//		int k = 3;
//		Output: true
		
//		int[] nums = {1,0,1,1};
//		int k = 1;
//		Output: true
		
		int[] nums = {1,2,3,1,2,3};
		int k = 2;
//		Output: false
				
		ContainsDuplicate2 ob = new ContainsDuplicate2();
		
		System.out.println(ob.containsNearbyDuplicate(nums, k));
	}
}
