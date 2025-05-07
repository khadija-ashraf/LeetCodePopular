package slidingwindow;

import java.util.*;

public class FruitIntoBasket {
    public int totalFruit(int[] fruits) {
        
    	if(fruits == null) return 0;
    	if(fruits.length <= 1) return fruits.length;
    	
    	int k = 2;
    	int maxLen = Integer.MIN_VALUE;
    	Map<Integer, Integer> freqMap = new HashMap<>();
    	
    	int left = 0;
    	int right = 0;
    	
    	while(right < fruits.length) {
    		freqMap.put(fruits[right], freqMap.getOrDefault(fruits[right], 0) + 1);
    		
    		// reached window size, update result
    		if(freqMap.size() <= k){
    			maxLen = Math.max(maxLen, right - left + 1);
    		}
    		// shrink window from the left
    		while(freqMap.size() > k) {
    			freqMap.put(fruits[left], freqMap.getOrDefault(fruits[left], 0) - 1);
    			
    			if(freqMap.get(fruits[left]) == 0) {
    				freqMap.remove(fruits[left]);
    			}
    			left++;
    		}
    		right++;
    	}
    	return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
    
    public static void main(String a[]) {
    	FruitIntoBasket ob = new FruitIntoBasket();
    	
//    	int[] fruits = {1,2,1};
//		Output: 3
    	
//    	int[] fruits = {0,1,2,2};
//		Output: 3
    	
//    	int[] fruits = {1,2,3,2,2};
//		Output: 4
    	
//    	int[] fruits = {0};
//    	Output: 1
    	
    	int[] fruits = {1,1};
//    	Output: 2

    	System.out.println(ob.totalFruit(fruits));
    }
}
