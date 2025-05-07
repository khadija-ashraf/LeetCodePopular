package slidingwindow;

public class MinimumRecolors {
    public int minimumRecolors(String blocks, int k) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        int minReplacement = blocks.length();
        
        while(right < blocks.length()) {
        	char c = blocks.charAt(right);
        	
        	if(c == 'W') cnt++;
        	
        	if(right - left + 1 == k) {
        		minReplacement = Math.min(minReplacement, cnt);
        		
        		// shrink the window to left by 1
        		if(blocks.charAt(left) == 'W') {
        			cnt--;
        		}
        		left++;
        	}
        	right++;
        }
        return minReplacement;
    }
    
	public static void main(String[] args) {
		MinimumRecolors ob = new MinimumRecolors();
//		String blocks = "WBBWWBBWBW";
//		int k = 7;
//		Output: 3
		
		String blocks = "WBWBBBW";
		int k = 2;
//		Output: 0
				
		System.out.println(ob.minimumRecolors(blocks, k));

	}

}
