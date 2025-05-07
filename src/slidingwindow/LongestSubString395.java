package slidingwindow;

import java.util.*;

public class LongestSubString395 {

	public int longestSubstring(String s, int k) {
		return divAndConcur(s, k, 0, s.length());
	}
	public int divAndConcur(String s, int k, int start, int end) {
		if(end - start < k) return 0;
		
		if(k == 0) return end - start;
		
		if(k == 1) return end - start;
		
		int[] freq = new int[26];
		for(int i = start; i < end; i++) {
			char c = s.charAt(i);
			freq[c - 'a'] += 1;
		}

		for(int i = start; i < end; i++) {
			char c = s.charAt(i);
			
			if(freq[c-'a'] > 0 && freq[c-'a'] < k) {
				int midNext = i +1;
				
				while(midNext < end && freq[s.charAt(midNext) - 'a'] > 0 
						&& freq[s.charAt(midNext) - 'a'] < k){
							midNext++;
				}
				
				int left = divAndConcur(s, k, start, i);
				int right = divAndConcur(s, k, midNext, end);
				return Math.max(left, right);
			}
		}
		return end - start;
	}
	
    public int longestSubstring1(String s, int k) {
        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        
        int[] freq = new int[26];
        Set<Character> unique = new HashSet<Character>();
        
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	freq[c -'a'] += 1;
        	
        	if(freq[c-'a'] >= k)
        		unique.add(c);
        }
        
        while(right < s.length()) {
        	char c = s.charAt(right);

        	if(unique.contains(c)) {
            	freq[c - 'a'] -= 1;
            	
            	if(freq[c -'a'] <= 0) {
            		unique.remove(c);
            	}
        	} else { // shrink window
        		while(left <= right && left < s.length()) {
        			char lChar = s.charAt(left);
        			
        			freq[lChar-'a'] += 1;
        			left++;
        		}
        		
        	}
        	
        	if(unique.isEmpty()) {
        		maxLen = Math.max(maxLen, right - left + 1);
        	}
        	right++;
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
    
	public static void main(String[] args) {
		LongestSubString395 ob = new LongestSubString395();
//		String s = "aaabb";
//		int k = 3;
//		Output: 3
		
		String s = "ababbc";
		int k = 2;
//		Output: 5
		
//		String s = "ababacb";
//		int k = 3;
//		Output: 0
		
//		String s = "bbaaacbd";
//		int k = 3;
//		Output: 3


		System.out.println(ob.longestSubstring(s, k));
	}

}
