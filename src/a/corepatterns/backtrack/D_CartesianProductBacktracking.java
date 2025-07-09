package a.corepatterns.backtrack;
import java.util.*;;

public class D_CartesianProductBacktracking {
    int minDistinct = Integer.MAX_VALUE;

	private void cartesianProduct(int[] n1, int[] n2, int currentIdx, 
			Set<Integer> currentSet,List<List<Integer>> result) {

		if(currentIdx == n1.length) {
			minDistinct = Math.min(minDistinct, currentSet.size());
			result.add(new ArrayList<Integer>(currentSet));
			return;
		}
		
		// no for loop is needed, because we are going to traverse the input arrays once
		// and for each position we take an element from either n1, or n2
		
		// Choose character from n1
		boolean addedP = currentSet.add(n1[currentIdx]);
		cartesianProduct(n1, n2, currentIdx+1, currentSet, result);
		if (addedP) 
			currentSet.remove(n1[currentIdx]);
		
		// Choose character from n2
		boolean addedQ = currentSet.add(n2[currentIdx]);
		cartesianProduct(n1, n2, currentIdx+1, currentSet, result);
		if (addedQ)
			currentSet.remove(n2[currentIdx]);
	}
	
	public int backtrack(int[] n1, int[] n2){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int currentIdx = 0;
		
	    cartesianProduct(n1, n2, currentIdx, new HashSet<Integer>(), result);
	    System.out.println(result);
	    return minDistinct;
	}
	
	// this is from codility: it as special combination implementation
	// the twist is, the combinations are generated from two different 
	// list of elements. and 

	public static void main(String[] args) {
		D_CartesianProductBacktracking ob = new D_CartesianProductBacktracking();
		
		int[] n1 = {1,2};
		int[] n2 = {3,4};
		
		// 'n Choose k' = !n / ((!n - !k) * !k) , 
		// for k = 2, !4 / (!4 - !2)	* !2 = 4*3*!2 / !2 *!2 = 4*3/!2 = 2*3 = 6	
		System.out.println(ob.backtrack(n1, n2));
	}
}
