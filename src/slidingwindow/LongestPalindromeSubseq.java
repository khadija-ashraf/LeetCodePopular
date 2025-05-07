package slidingwindow;

public class LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
    	int[][] memo = new int[s.length()][s.length()];
    	return findLen(s, 0, s.length() - 1, memo);
    }
    
    private int findLen(String s, int left, int right, int[][] memo){
    	if(left > right) return 0;
    	
    	if(left == right) return 1;
    	
    	if(memo[left][right] != 0) {
    		return memo[left][right];
    	}

    	if(s.charAt(left) == s.charAt(right)) {
    		memo[left][right] += 2 + findLen(s, left + 1, right - 1, memo);
    	} else {
    		memo[left][right] = Math.max(findLen(s, left+1, right, memo), 
    				findLen(s, left, right - 1, memo));
    	}
    	
    	return memo[left][right];
    }
    public static void main(String a[]) {
    	LongestPalindromeSubseq ob = new LongestPalindromeSubseq();
    	
//    	String s = "bbbab";
    	
//		Output: 4
    	
    	String s = "cbbd";
//		Output: 2
    			
		System.out.println(ob.longestPalindromeSubseq(s));
		
    }
}
