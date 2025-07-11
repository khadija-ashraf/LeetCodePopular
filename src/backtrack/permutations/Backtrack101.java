package backtrack.permutations;
import java.util.*;;

public class Backtrack101 {
	
	private void backtrack(int[] items, 
			int currentIdx, 
			List<Integer> currentList) {

		
		System.out.print(currentList+", ");
		for(int i = currentIdx; i < items.length; i++) {
			currentList.add(items[i]);
			backtrack(items, i + 1, currentList);
			currentList.remove(currentList.size() - 1); 
		}
	}
	
	public void subsets(int[] n){
		List<Integer> currentList = new ArrayList<>();
		int currentIdx = 0;
		
		backtrack(n, currentIdx, currentList); 
	}
	
	public static void main(String[] args) {
		Backtrack101 ob = new Backtrack101();
		int[] n = {1,2,3};
		ob.subsets(n);
	}
}






