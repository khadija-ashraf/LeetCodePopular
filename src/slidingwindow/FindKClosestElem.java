package slidingwindow;

import java.util.*;

public class FindKClosestElem {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //TODO: step1:find the diff array, |arr[i] - x|
    	// the diffArr will be of input arr size.
    	// step2: run a sliding window over the diffArr, of size k
    	// keep a sum o window elements, 
    	// Step3: when a new element comes,
    	// add to the sum and the left element gets subtracted from the sum.
    	// return the minimum sum consisting window. when there is a tie,
    	// return the sum that has lower input values.
    	
    	List<Integer> res = new ArrayList<Integer>();
    	
    	int[] diff = new int[arr.length];
    	for(int i = 0; i < arr.length; i++) {
    		diff[i] = Math.abs(arr[i] - x);
    	}
    	
    	int left = 0;
    	int right = 0;
    	int sum = 0;
    	int start = 0;
    	int minSum = Integer.MAX_VALUE;
    	
    	while(right < diff.length) {
    		// expand
    		sum += diff[right];
    		if(right - left + 1 == k) {
    			if(sum < minSum) {
    				minSum = sum;
    				start = left;
    			}
    			// shrink window from left 
    			sum -= diff[left];

    			left++;
    		}
    		right++;
    	}
    	for(int i = start; i < start + k; i++) {
    		res.add(arr[i]);
    	}
    	return res;
    }
    
	public static void main(String[] args) {
		FindKClosestElem ob = new FindKClosestElem();
		int[] arr = {1,2,3,4,5};
		int k = 4;
		int x = 3;
//		Output: [1,2,3,4]

//		int[] arr = {1,1,2,3,4,5};
//		int k = 4;
//		int x = -1;
//		Output: [1,1,2,3]
		
//		int[] arr = {1,1,1,10,10,10};
//		int k = 1;
//		int x = 9;
//		Output: [10]

//		8,8,8,1,1,1
		
		System.out.println(ob.findClosestElements(arr, k, x));
	}

}
