package a.corepatterns.backtrack;
import java.util.*;;

public class C_subArrayBacktracking {
	
	private void subArray(int[] n, int startIndex, int currentIdx,
			List<Integer> currentList, List<List<Integer>> result) {
		
		if(currentIdx >= n.length) return;
		
//		for(int i = currentIdx; i < n.length; i++) {
			currentList.add(n[currentIdx]);
			result.add(new ArrayList<Integer>(currentList));
			subArray(n, startIndex, currentIdx + 1, currentList, result);
			currentList.remove(currentList.size() - 1); // removing the last item
//		}
	}
	// the reason we do not have any for loop inside this method is, 
	// once the entire array is traversed from the 'start' index till the end,
	// we want to backtrack all the way up to the 'start'. if we don't
	// and stop somewhere before and keep exploring further down,
	// then we will skip items in our generated
	// subarrays. Which is not valid to be a subarray.
	
	// thats why we are returning all the way to the 'start' index. Now, we 
	// need a for loop outside this method to start generating subrarray
	// from the next item of the input array, other wise we won't be generating 
	// all possible subarrays. So, we are calling this backtracking method
	// from outside starting from every position of the array.
	// and the for loop is making those call.
	// 		for(int start = 0; start < n.length; start++) {}
	
	public List<List<Integer>> backtrack(int[] n){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> currentList = new ArrayList<Integer>();
		
		for(int start = 0; start < n.length; start++) {
			subArray(n, start, start, currentList, result); 
		}
	    return result;
	}
	
	// Progression 3:
	//=================
	// subarray is a special kind of all-subsets with (1) strict order, (2) no-skipping item
	// [[1], [1, 2], [1, 2, 3], [2], [2, 3], [3]]

	public static void main(String[] args) {
		C_subArrayBacktracking ob = new C_subArrayBacktracking();
		
		int[] n = {1,2,3};
		System.out.println(ob.backtrack(n));
	}

}
