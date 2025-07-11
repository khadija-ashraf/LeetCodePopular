package backtrack;
import java.util.*;

public class CartesianProduct {
	
    private void backtrack(List<List<Integer>> items, 
    		int depth, 
    		List<Integer> currentList, 
    		List<List<Integer>> result) {
    	
    	if(depth == items.size()) {
    		result.add(new ArrayList<Integer>(currentList));
    		return;
    	}
        List<Integer> steppedList = items.get(depth);

    	for(int i = 0; i < steppedList.size(); i++) {
        	Integer everyItem = steppedList.get(i);
        	currentList.add(everyItem);
    		backtrack(items, depth + 1, currentList, result);
    		currentList.remove(currentList.size() - 1);
    	}
    }
    public List<List<Integer>> cartesianProduct(
    		List<List<Integer>> items) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int depth = 0;
        
        backtrack(items, depth, currentList, result);
        return result;
    }
	public static void main(String a[]) {
		CartesianProduct ob = new CartesianProduct();
		
		List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 2, 3));
        input.add(Arrays.asList(4, 5, 6));

        List<List<Integer>> product = ob.cartesianProduct(input);

        for (List<Integer> combo : product) {
            System.out.println(combo);
        }
	}
}
