package hashtable.frequencyCounting;

import java.util.*;

public class RansomeNote {
    public boolean canConstruct(String ransomNote, String magazine) {
    	
    	if(ransomNote.length() > magazine.length()) 
    		return false;
    	
    	Map<Character, Integer> map = new HashMap<>();
    	for(int i = 0; i < magazine.length(); i++) {
    		char c = magazine.charAt(i);
    		map.put(c, map.getOrDefault(c, 0) + 1);
    	}
    	
    	for(int i = 0; i < ransomNote.length(); i++) {
    		char c = ransomNote.charAt(i);
    		
    		if(map.containsKey(c)) {
    			map.put(c, map.get(c) - 1);
    			if(map.get(c) < 0) return false;
    			
    		} else {
    			return false;
    		}
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		RansomeNote ob = new RansomeNote();
		
//		String ransomNote = "a";
//		String magazine = "b";
//		Output: false
		String ransomNote = "a";
		String magazine = "b";
//		Output: false
		
		System.out.println(ob.canConstruct(ransomNote, magazine));

	}

}
