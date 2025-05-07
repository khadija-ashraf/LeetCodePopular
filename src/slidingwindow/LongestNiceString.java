package slidingwindow;

import java.util.*;

public class LongestNiceString {
	
	// TODO: NOTE: this sliding window does not work here.
	// becasue  we’d have to recompute all characters in the window anyway.
    public String longestNiceSubstring(String s) {
    	//frequency map for both lower case and uppercase alphabet.
        int[] freq = new int[128];
        
        for(int i = 0; i < s.length(); i++) {
        	freq[s.charAt(i)] += 1;
        }
        
        // initialize left
        int left = 0;
        int right = 0;
    	int startIdx = left;
    	int end = right;
    	int maxLen = Integer.MIN_VALUE;

        while(right < s.length()) {
        	//expand right
        	char c = s.charAt(right);
        	char matchChar = ' ';
        	
        	int charDiff = 'a' - 'A';
        	
        	if(c >= 'A' && c <= 'Z') { // uppercase
        		// corresponding lower case
        		matchChar = (char) ((char) c + charDiff);
        	} else if(c >= 'a' && c <= 'z') { // lowercase
        		// corresponding upper case
        		matchChar = (char) ((char) c - charDiff);
        	}

        	if(freq[matchChar] > 0) {
        		// update window if its longest so far
        		if(right - left + 1 > maxLen) {
        			startIdx = left;
            		end = right;
        			maxLen = right - left + 1;
        		}
        	} else {
        		// shrink the window, start over from where the right is now
        		while(left <= right) {
        			freq[s.charAt(left)] -= 1;
        			left++;
        		}
        	}
    		right++;
        }
        return startIdx < end ? s.substring(startIdx, end+1) : "";
    }
    
    public String longestNiceSubstrRecurs(String s) {
    	if(s.length() < 2) return "";
    	
    	Set<Character> set = new HashSet<Character>();
    	for(int i = 0; i < s.length(); i++) {
    		set.add(s.charAt(i));
    	}
    	
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(set.contains(Character.toUpperCase(c))
    				&& set.contains(Character.toLowerCase(c))){
    			continue;
    		}
    		
    		// Split and recurse on left and right
            String left = longestNiceSubstring(s.substring(0, i));
    		String right = longestNiceSubstring(s.substring(i+1));
    		
    		return left.length() > right.length()? left : right;
    	}
    	return s; // whole string is nice
    }
    public String longestNiceSubstrBitMask(String s) {
    	
    	// this 32 bit variable represent all 26  bits 
    	// lowercase letter present in this input string 's'. 
    	// vice versa for 'upper'.

    	int maxLen = Integer.MIN_VALUE;
    	String niceStr = "";
    	
    	for(int i = 0; i < s.length(); i++) {
        	int lower = 0; 
        	int upper = 0;
    		for(int j = i; j < s.length(); j++) {
    			char c = s.charAt(j);
    			
    			if(Character.isLowerCase(c)){
    				lower = lower | 1 << (c - 'a');
    			} else {
    				upper = upper | 1 << (c - 'A');
    			}
    			
    			if(lower == upper && j - i + 1 > maxLen) {
    				maxLen = j - i + 1;
    				niceStr = s.substring(i, j + 1);
    			}
    		}
    	}
    	return niceStr;
    }
    public static void main(String a[]) {
    	LongestNiceString ob = new LongestNiceString();
//    	String s = "YazaAay";
//		Output: "aAa"
    	
//    	String s = "Bb";
//		Output: "Bb"
    	
//    	String s = "c";
//		Output: ""
    	
    	String s = "ijIJwuUnW";
//    	output: "ijIJ"
    				
    	System.out.println(ob.longestNiceSubstrBitMask(s));
    }
}
