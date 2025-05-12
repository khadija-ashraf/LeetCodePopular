package hashtable.frequencyCounting;

import java.util.*;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
    	if(s.length() != t.length()) return false;
    	
    	Map<Character, Integer> map = new HashMap<>();
    	
    	// counting char frequency of 's'
    	for(int i = 0; i < s.length(); i++) {
    		map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
    	}
    	
    	// matching char frequency of 't'
    	for(int i = 0; i < t.length(); i++) {
    		if(map.containsKey(t.charAt(i))) {
    			map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
    		} else {
    			return false;
    		}
    	}
    	
    	// check if the char frequency count is '0' throughout map
    	for(int val: map.values()) {
    		if(val != 0) {
    			return false;
    		}
    	}
    	return true;
    }
	public static void main(String[] args) {
		ValidAnagram ob = new ValidAnagram();
		
//		String s = "anagram";
//		String t = "nagaram";

//		Output: true
		
		String s = "rat";
		String t = "car";

//		Output: false

		
		System.out.println(ob.isAnagram(s, t));
	}

}
