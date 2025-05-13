package hashtable.frequencyCounting;
import java.util.*;

public class FirstUniqueChar {
	public int firstUniqChar(String s) {
		if(s.length() <= 0) {
        	return -1;
        }
		
		if(s.length() == 1) {
        	return 0;
        }
        
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
        char[] sArr = s.toCharArray();
        
        for(int i = 0; i < sArr.length; i++) {
        	if(map.containsKey(sArr[i])) {
        		map.put(sArr[i], map.get(sArr[i]) + 1);
        	} else {
            	map.putIfAbsent(sArr[i], 1);
        	}
        	
        }
        for(int i = 0; i < sArr.length; i++) {
        	if(map.get(sArr[i]) == 1) return i;
        }
        return -1;
    }
	public static void main(String[] args) {
		FirstUniqueChar ob = new FirstUniqueChar();
//		String s = "leetcode";
//		Output: 0
		String s = "loveleetcode";
//		Output: 2
		System.out.println(ob.firstUniqChar(s));

	}

}
