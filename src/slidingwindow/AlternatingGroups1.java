package slidingwindow;

public class AlternatingGroups1 {
	
    public int numberOfAlternatingGroups(int[] colors) {
    	int k = 3; // window size, alternating group size in this context
    	
    	int left = 0;
    	int right = 0;
    	int n = colors.length;
    	int groupCnt = 0;
    	
    	while(right < n) {
    		// right = middle, l = left, r = right
    		
    		int l = ((right - 1) + n) % n;
    		int r = ((right + 1) + n) % n;
    		if(colors[l] == colors[r] && colors[right] != colors[l]) {
    			groupCnt++;
    		}
    		right++;
    	}
    	return groupCnt;
    }
	public static void main(String[] args) {
		AlternatingGroups1 ob = new AlternatingGroups1();
//		int[] colors = {1,1,1};
//		Output: 0
		
		int[] colors = {0,1,0,0,1};
//		Output: 3
		
		System.out.println(ob.numberOfAlternatingGroups(colors));
	}

}
