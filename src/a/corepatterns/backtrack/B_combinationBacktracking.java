package a.corepatterns.backtrack;
import java.util.*;;

public class B_combinationBacktracking {
	
	private void combinations(int[] n, int k, int currentIdx, 
			List<Integer> currentList, List<List<Integer>> result){
		
		if(k > n.length) return; 
		
		if(currentList.size() == k) {
			result.add(new ArrayList<Integer>(currentList));
			return;
		}
		
		for(int i = currentIdx; i < n.length; i++) {
			currentList.add(n[i]);
			combinations(n, k, i + 1,  currentList, result);
			currentList.remove(currentList.size() - 1); // removing the latest added item, that is last item in the list
		}
	}
	
	public List<List<Integer>> backtrack(int[] n, int k){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> currentList = new ArrayList<Integer>();
		int currentIdx = 0;
		
		combinations(n, k, currentIdx, currentList, result); 
	    return result;
	}
	
	// Progression 2:
	//=================
	// 'n Choose k' = !n / ((!n - !k) * !k)
	// n = {1,2,3};  k = 2;  Output: [[1, 2], [1, 3], [2, 3]]
	// *** combination is a special kind of all-subset that has a size restriction.
	// any subset in a combination list must be of size-k
	
	public static void main(String[] args) {
		B_combinationBacktracking ob = new B_combinationBacktracking();
		
		int[] n = {1,2,3};
		int k = 2;
		// 'n Choose k' = !n / ((!n - !k) * !k) , 
		// for k = 2, !4 / (!4 - !2)	* !2 = 4*3*!2 / !2 *!2 = 4*3/!2 = 2*3 = 6	
		System.out.println(ob.backtrack(n, k));
	}


}
