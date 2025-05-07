package slidingwindow;

public class NoOfSubStrContainingAllThreeChar {
	
	// TODO: 
	// We want substrings that contain all 3 characters 
	// → this becomes a sliding window with atMost trick:

	// Trick: Let’s count the number of substrings with 
	// at most 2 characters, and subtract from total substrings.
	// result = total substrings - atMost(2)
//	Because:
//		•	All substrings = n * (n + 1) / 2
//		•	The rest (that don’t have all 3 chars) have at most 2 distinct chars


    public int numberOfSubstrings(String s) {
    	long allCount = totalNoOfSubString(s.length());
    	int atMostCnt = atMost(s, 2);
    	return (int) (allCount - atMostCnt);
    }
    
    private long totalNoOfSubString(long n) {
    	long cnt = n * (n+1)/2;
    	return cnt;
    }
	
    public int atMost(String s, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        
        int[] freq = new int[3];
        
        while(right < s.length()) {
        	// expand
        	char c = s.charAt(right);
        	freq[c-'a'] += 1;
        	
        	if(freq[c-'a'] == 1) { // unique char
            	k--;
        	}
        	
        	while(k < 0) {
        		char lChar = s.charAt(left);
        		freq[lChar - 'a'] -= 1;
        		
        		if(freq[lChar - 'a'] == 0) {
        			k++;
        		}
        		left++;
        	}
        	count += right - left + 1;
        	right++;
        }
        return count;
    }
    
	public static void main(String[] args) {
		NoOfSubStrContainingAllThreeChar ob = new NoOfSubStrContainingAllThreeChar();
		String s = "abcabc";
//		Output: 10
		
//		Explanation: The substrings containing at least one occurrence 
		// of the characters a, b and c are "abc", "abca", "abcab", 
		// "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again)
		
		System.out.println(ob.numberOfSubstrings(s));
		System.out.println(ob.totalNoOfSubString(49901));
		
	}
}
