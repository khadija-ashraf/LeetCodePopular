package a.corepatterns.backtrack;
import java.util.*;;

public class A_subSetsBacktracking {
	
	private void subsets(int[] n, int currentIdx, 
			List<Integer> currentList, List<List<Integer>> result) {

		result.add(new ArrayList<Integer>(currentList));
		
		for(int i = currentIdx; i < n.length; i++) {
			currentList.add(n[i]);
			subsets(n, i + 1, currentList, result);
			currentList.remove(currentList.size() - 1); // removing the last item
		}
	}
	
	public List<List<Integer>> backtrack(int[] n){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> currentList = new ArrayList<Integer>();
		int currentIdx = 0;
		
		subsets(n, currentIdx, currentList, result); 
	    return result;
	}
	
	// Progression 1:
	//=================
	// output: [[], [3], [2], [2, 3], [1], [1, 3], [1, 2], [1, 2, 3]]
	
	//	Input: [1, 2]
		
	//	           []
	//	       /       \
	//	     [1]       [2]
	//	    /   \     /   \
	//	 [1,2] [1] [2,1] [2]

	public static void main(String[] args) {
		A_subSetsBacktracking ob = new A_subSetsBacktracking();
		
//		int[] n = {1,2,3};
		int[] n = {2,3,5};
		System.out.println(ob.backtrack(n));
	}

}
