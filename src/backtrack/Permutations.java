package backtrack;
import java.util.*;

public class Permutations {
	private void backtrack(int[] items, 
			boolean[] used,
			List<Integer> currentList, 
			List<List<Integer>> result) {

		if(currentList.size() == items.length) {
			result.add(new ArrayList<Integer>(currentList));
			return;
		}
		
		for(int i = 0; i < items.length; i++) {
			if(used[i]) continue; // avoid using restricted positions
			
			currentList.add(items[i]); // including position i in the current path
			used[i] = true; // restricting i in the upcoming forward steps

			backtrack(items, used, currentList, result); // recurse on the whole input array
			
			currentList.remove(currentList.size() - 1); // exclude index i from the current path
			used[i] = false; // releasing position i to be available in the upcoming forward steps. 
		}
	}
	
	public List<List<Integer>> permute(int[] n){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentList = new ArrayList<>();
		boolean[] used = new boolean[n.length];
		
		backtrack(n, used, currentList, result); 
	    return result;
	}
	
	public static void main(String[] args) {
		Permutations ob = new Permutations();
		int[] n = {1,2,3};
		System.out.println(ob.permute(n));
	}
}
