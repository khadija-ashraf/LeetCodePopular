package hashtable.detectDuplicate;

import java.util.*;

public class ContainsDuplicate {
	
    public boolean containsDuplicate(int[] nums) {
    	Set<Integer> set = new HashSet<>();
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(set.contains(nums[i])) {
    			return true;
    		} else {
    			set.add(nums[i]);
    		}
    	}
    	return !(set.size() == nums.length);
    }
    
    public static void main(String a[]) {
    	ContainsDuplicate ob = new ContainsDuplicate();
//    	int[] nums = {1,2,3,1};
//    	Output: true
    	
    	
    	int[] nums = {1,2,3,4};
    	System.out.println(ob.containsDuplicate(nums));
    	
    }
}
