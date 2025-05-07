package slidingwindow;

public class NumberSubarrSizeK1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        
        double sum = 0;
        double avg = 0.0;
        int count = 0;
        
        for(int i = 0; i < k; i++) {
        	sum += arr[i];
        }
        for(int right = k; right <= arr.length; right++){
            avg = sum / k;

        	if(avg >= (double) threshold) {
        		count += 1;
        	}
        	
        	if(right < arr.length) {
            	sum += arr[right];
            	sum -= arr[left];
        	}
        	left++;
        }
        return count;
    }
	public static void main(String[] args) {
		NumberSubarrSizeK1343 ob = new NumberSubarrSizeK1343();
		
//		int[] arr = {2,2,2,2,5,5,5,8};
//		int k = 3;
//		int threshold = 4;
//		Output: 3
		
		int[] arr = {11,13,17,23,29,31,7,5,2,3};
		int k = 3;
		int threshold = 5;
//		Output: 6

		System.out.println(ob.numOfSubarrays(arr, k, threshold));
	}

}
