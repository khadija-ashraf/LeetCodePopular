package backtrack;

import java.util.*;

// TODO: To avoid duplicate combinations
//•	Sort the array first: ensures consistent order
//•	Use backtracking to build combinations
//•	Always explore candidates starting from current index i or later (not earlier)
//•	This guarantees non-decreasing order within each combination (e.g., [2,2,3], never [3,2,2])

//TODO: Runtime: 2ms, Beats 83.25%

public class CombinationSum {
	
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> currentList = new ArrayList<Integer>();
    	int currentIdx = 0;
    	Arrays.sort(candidates);
    	backtrac(candidates, target, result, currentList, currentIdx);
    		
    	return result;
    }
    
    private void backtrac(int[] candidates, int target,
				    		List<List<Integer>> result,
				    		List<Integer> currentList,
				    		int currentIdx) {
    	
    	if(target < 0) return;
    	
    	if(target == 0) {
    		result.add(new ArrayList<Integer>(currentList));
    		return;
    	}
    	
    	for(int i = currentIdx; i < candidates.length; i++) {
    		int num = candidates[currentIdx];
    		if(num > target) continue;
    		currentList.add(num);
    		backtrac(candidates, target - num, result, currentList, currentIdx); // exploring current index
    		currentIdx++; // when current Index element summation reached >= target, then go to next element
    		currentList.remove(currentList.size() - 1);
    	}
    }
    
	public static void main(String args[]) {
		CombinationSum obj = new CombinationSum();
		
		int[] c = {2, 3, 5};
		int target = 8;
//		
//		System.out.println(obj.comBSum(c, target));
		
//		int[] c = {2, 3, 6, 7};
//		int target = 7;
		
		System.out.println(obj.combinationSum(c, target));
	}
	
}
