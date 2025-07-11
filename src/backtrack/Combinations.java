package backtrack;
import java.util.*;

public class Combinations {
	
    private void backtrack(int[] items, int k, 
    		int currentIdx, 
    		List<Integer> currentList, 
    		List<List<Integer>> result) {
    	
    	if(k > items.length) return;

    	if(k == currentList.size()) {
    		result.add(new ArrayList<Integer>(currentList));
    		return;
    	}
    	for(int i = currentIdx; i < items.length; i++) {
    		currentList.add(items[i]);
    		backtrack(items, k, i + 1, currentList, result);
    		currentList.remove(currentList.size() - 1);
    	}
    }
    public List<List<Integer>> combine(int[] items, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int currentIdx = 0;
        
        backtrack(items, k, currentIdx, currentList, result);
        return result;
    }
	public static void main(String a[]) {
		Combinations ob = new Combinations();
		int[] n = {1,2,3};
		int k = 2;
		System.out.println(ob.combine(n, k));
	}
}
