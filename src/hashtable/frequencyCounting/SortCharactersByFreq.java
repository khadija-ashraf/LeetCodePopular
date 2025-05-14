package hashtable.frequencyCounting;

import java.util.*;

public class SortCharactersByFreq {
	
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        // count the char frequency
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if(map.containsKey(c)) {
        		map.put(c, map.get(c) + 1);
        	} else {
        		map.put(c, 1);
        	}
        }
        
        // sort the characters of s by their frequency counted in the map
        // sorting in descending order with a max-heap
        PriorityQueue<Character> maxHeap = new PriorityQueue<Character>(
        		(a,b) -> map.get(b) - map.get(a)
		);
        	
        // all the chars are arranged in descending order by frequency. 
        maxHeap.addAll(map.keySet());
        
        StringBuffer sbuff = new StringBuffer();
        
        while(!maxHeap.isEmpty()) {
        	char c = maxHeap.poll();
        	int count = map.get(c);
        	
        	for(int i = 0; i < count; i++) {
    			sbuff.append(c);
        	}
        }
        return sbuff.toString();
    }
    
    
	public static void main(String[] args) {
		SortCharactersByFreq ob = new SortCharactersByFreq();
		
//		String s = "tree";
//		Output: "eert"

		String s = "cccaaa";
//		Output: "aaaccc"
		System.out.println(ob.frequencySort(s));
	}

}
