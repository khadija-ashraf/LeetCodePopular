package backtrack;
import java.util.*;

public class SubArrays {
	private void backtrack(int[] items, 
			int currentIdx, 
			List<Integer> currentList, 
			List<List<Integer>> result) {

		if(currentIdx >= items.length) {
			return;
		}
		currentList.add(items[currentIdx]);
		result.add(new ArrayList<Integer>(currentList));
		backtrack(items, currentIdx + 1, currentList, result);
		currentList.remove(currentList.size() - 1); 
	}
	
	public List<List<Integer>> subarrays(int[] n){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentList = new ArrayList<>();
		
		for(int start = 0; start < n.length; start++) {
			backtrack(n, start, currentList, result); 
		}
	    return result;
	}
	
	public static void main(String[] args) {
		SubArrays ob = new SubArrays();
		int[] n = {1,2,3};
		System.out.println(ob.subarrays(n));
	}
}



