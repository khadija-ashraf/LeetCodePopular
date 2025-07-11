package a.corepatterns.backtrack;
import java.util.*;;

public class A_subSetsBacktracking {
	
	private void backtrack(int[] items, int currentIdx, 
			List<Integer> currentList, List<List<Integer>> result) {

		result.add(new ArrayList<Integer>(currentList));
		for(int i = currentIdx; i < items.length; i++) {
			currentList.add(items[i]);
			backtrack(items, i + 1, currentList, result);
			currentList.remove(currentList.size() - 1); // removing the last item
		}
	}
	
	public List<List<Integer>> subsets(int[] n){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> currentList = new ArrayList<Integer>();
		int currentIdx = 0;
		
		backtrack(n, currentIdx, currentList, result); 
	    return result;
	}
	// Progression 1:
	public static void main(String[] args) {
		A_subSetsBacktracking ob = new A_subSetsBacktracking();
		int[] n = {1,2,3};
		System.out.println(ob.subsets(n));
	}
}
