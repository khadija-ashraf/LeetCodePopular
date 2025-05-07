package slidingwindow;

public class StringContainsBinaryCodeK {
    public boolean hasAllCodes(String s, int k) {
        int hash = 0;
        int need = 1 << k;
        boolean[] seen = new boolean[need];
        int allOnes = (1 << k) - 1;
        
        for(int right = 0; right < s.length(); right++) {
        	hash = ((hash << 1) & allOnes) | (s.charAt(right) - '0');
        	
        	if(right >= k - 1 && !seen[hash]) {
        		seen[hash] = true;
        		need--;
            	if(need == 0) return true;
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		StringContainsBinaryCodeK ob = new StringContainsBinaryCodeK();
		
		String s = "00110110";
		int k = 2;
//		Output: true
		
		System.out.println(ob.hasAllCodes(s, k));
	}

}
