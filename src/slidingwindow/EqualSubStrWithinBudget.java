package slidingwindow;

public class EqualSubStrWithinBudget {
	
    public int equalSubstring(String s, String t, int maxCost) {
        
    	if(s.length() == 0 || t.length() == 0) return 0;
    	if(s.length() != t.length()) return 0;
    	
    	int[] diff = new int[s.length()];
        
        for(int i = 0; i < s.length() && i < t.length(); i++) {
        	char sChar = s.charAt(i);
        	char tChar = t.charAt(i);
        	
        	diff[i] = Math.abs((sChar - 'a') - (tChar - 'a'));
        }
        int left = 0;
        int right = 0;
        
        int maxLen = Integer.MIN_VALUE;

        int sum = 0;

        while(right < diff.length) {
        	sum += diff[right];
        	
        	while(sum > maxCost) {
        		sum -= diff[left];
        		left++;
        	}
        	
        	maxLen = Math.max(maxLen, right - left + 1);
        	right++;
        }
        return maxLen;
    }
    
    private void print(int[] diff) {
    	for(int n: diff) {
    		System.out.print(n + ", ");
    	}
    	System.out.println();
    }
    
	public static void main(String a[]) {
		EqualSubStrWithinBudget ob = new EqualSubStrWithinBudget();
		
//		String s = "abcd";
//		String t = "bcdf";
//		int maxCost = 3;
//		Output: 3
		
//		String s = "abcd";
//		String t = "cdef";
//		int maxCost = 3;
//		Output: 1
		
		String s = "abcd";
		String t = "acde";
		int maxCost = 0;
//		Output: 1
				
		System.out.println(ob.equalSubstring(s, t, maxCost));
		
	}
}
