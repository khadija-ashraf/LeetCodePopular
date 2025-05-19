package hashtable.groupByFrequency;

import java.util.*;

public class SortCharacterByFreq {
    // Approach 1: 
	// HashMap + maxHeap: count frequency and store in a maxheap
	// n -> len(s)
	
	// Step 1: count the frequency by traversing the input array once -> O(n)
	
	// Step 2: put all the elements of the map.keySet() 
	// in a maxHeap by frequency, insertion in a maxHeap = O(log n). 
	// total possible insertions are n, so maxHeap by insertion = O(n log n).
	
	// Step 3: populate the result array by traversing the maxHeap once O(n)
	
	// Total Time: O(n) + O(n log n) + O(n) => O(n log n)
	// Total Space: HashMap O(n) + Heap O(n) + result O(n) = O(n)
	
    public String frequencySortHashMapAndMaxHeap(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	}
    	
    	PriorityQueue<Character> maxHeap = new PriorityQueue<>(
    			(a,b) -> map.get(b) - map.get(a));
    	
    	for(Character c: map.keySet()) {
    		maxHeap.offer(c);
    	}
    	
    	StringBuffer sbuf = new StringBuffer();
    	
    	while(!maxHeap.isEmpty()) {
    		Character c = maxHeap.poll();
    		int count = map.get(c);
    		
    		for(int i = 0; i < count; i++) {
    			sbuf.append(c);
    		}
    	}
    	return sbuf.toString();
    }
    
    //	==============================
	
	// Approach 2 (Optimized):
	
	// HashMap + bucket sort
	
	// Step 1: count the frequency by traversing the input array once -> O(n)
	// Step 2: put the items in buckets[1...n], of frequency group -> O(n)
	// step 3: populate result from the bucket[n..1] -> 0(n)
	// backwards to the result array, since the higher indexed buckets
	// contains higher frequency.
	
	// Total Time:  HashMap O(n) + Bucket O(n) + result O(n) = O(n)
	// Total Space: HashMap O(n) + Bucket O(n) + result O(n) = O(n)

    public String frequencySortHashMapAndBucketSort(String s) {
    	Map<Character, Integer> map = new HashMap<>();
    	
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	}
    	
    	List<Character>[] buckets = new List[s.length() + 1];
    	
    	for(Map.Entry<Character, Integer> entry: map.entrySet()) {
    		
    		char c = entry.getKey();
    		int freq = entry.getValue();
    		
    		if(buckets[freq] == null) {
    			buckets[freq] = new ArrayList<>();
    		}
    		buckets[freq].add(c);
    	}
    	
    	StringBuffer sbuf = new StringBuffer();
    	
    	for(int i = buckets.length - 1; i >= 0; i--) {
    		List<Character> charList = buckets[i];
    		
    		if(charList == null) {
    			continue;
    		}
    		
    		int freq = i;
    		for(char c: charList) {
        		for(int j = 0; j < freq; j++) {
        			sbuf.append(c);
        		}
    		}
    	}
    	return sbuf.toString();
    }
    
	public static void main(String[] args) {
		SortCharacterByFreq ob = new SortCharacterByFreq();
		
		String s = "tree";
//		Output: "eert"
		
		System.out.println(ob.frequencySortHashMapAndMaxHeap(s));
		System.out.println(ob.frequencySortHashMapAndBucketSort(s));
	}

}
