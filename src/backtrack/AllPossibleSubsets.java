package backtrack;
import java.util.*;

public class AllPossibleSubsets {

	private void backtrack(int[] items, 
			int currentIdx, 
			List<Integer> currentList, 
			List<List<Integer>> result) {

		result.add(new ArrayList<Integer>(currentList));
		
		for(int i = currentIdx; i < items.length; i++) {
			currentList.add(items[i]);
			backtrack(items, i + 1, currentList, result);
			currentList.remove(currentList.size() - 1); 
		}
	}
	
	public List<List<Integer>> subsets(int[] n){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentList = new ArrayList<>();
		int currentIdx = 0;
		
		backtrack(n, currentIdx, currentList, result); 
	    return result;
	}
	
	public static void main(String[] args) {
		AllPossibleSubsets ob = new AllPossibleSubsets();
		int[] n = {1,2,3};
		System.out.println(ob.subsets(n));
	}
}



