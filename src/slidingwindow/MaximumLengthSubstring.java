package slidingwindow;

import java.util.*;

public class MaximumLengthSubstring {
    public int maximumLengthSubstring(String s) {
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int[] freq = new int[26];
        
        while(right < s.length()) {
        	char c = s.charAt(right);
        	
        	freq[c-'a'] += 1;

        	while(freq[c-'a'] > 2) {
    			// shrink the window from the left until the 'c' count 
    			// becomes <= 2.
    			char lChar = s.charAt(left);
    			freq[lChar-'a'] -= 1;
    			left++;
    		}
    		// update the result
    		max = Math.max(max, right - left + 1);
    		right++;
        }
        return max;
    }
	public static void main(String[] args) {
		MaximumLengthSubstring ob = new MaximumLengthSubstring();
		
		String s = "bcbbbcba";
//		Output: 4
		
//		String  s = "aaaa";
//		Output: 2
		System.out.println(ob.maximumLengthSubstring(s));

	}

}
