package slidingwindow;

public class SubStrSizeThree1876 {
    public int countGoodSubstrings(String s) {
        int left = 0; 
        int[] freq = new int[26];
        int count = 0;
        
        for(int right = 0; right < s.length(); right++) {
        	char c = s.charAt(right);
        	freq[c-'a'] += 1;
        	
        	while(freq[c-'a'] > 1) {
        		char lchar = s.charAt(left);
        		
        		freq[lchar -'a'] -= 1;
        		left++;
        	}
        	if(right - left + 1 == 3) {
        		count++;
        		
        		freq[s.charAt(left) - 'a'] -= 1;
        		left++;
        	}
    	}
        return count;
    }
    
	public static void main(String[] args) {
		SubStrSizeThree1876 ob = new SubStrSizeThree1876();
//		String s = "xyzzaz";
//		Output: 1
		
		String s = "aababcabc";
//		Output: 4
				
		System.out.println(ob.countGoodSubstrings(s));
	}

}
