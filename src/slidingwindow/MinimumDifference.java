package slidingwindow;

public class MinimumDifference {
	
	public void sort(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		mergeSort(nums, left, right);
	}

	public void mergeSort(int[] nums, int left, int right) {
		if(left < right) {
	
			int mid = left + (right - left)/2;
			
			mergeSort(nums, left, mid);
			mergeSort(nums, mid+1, right);
			
			merge(nums, left, mid, right);
		}
	}
	
	// 1,2,3,4,5,6,7
	public void merge(int[] nums, int left, int mid, int right) {
		int lArrSize = mid - left + 1;
		int rArrSize = right - mid;
		
		int[] leftTemp = new int[lArrSize];
		int[] rightTemp = new int[rArrSize];
		
		// copying left part to a temp array so that we can change the input array
		int i = left;
		int addIdx = 0;
		while(i <= mid) {
			leftTemp[addIdx] = nums[i];
			addIdx++;
			i++;
		}
		// copying right part to a temp array so that we can change the input array
		int x = mid+1;
		int y = 0;
		while(x <= right) {
			rightTemp[y] = nums[x];
			y++;
			x++;
		}
		
		// now merge both the left and right temp arrays into the result array
		int k = 0;
		int j = 0;
		while(k < lArrSize && j < rArrSize) {
			if(leftTemp[k] < rightTemp[j]) {
				nums[left] = leftTemp[k];
				k++;
			} else {
				nums[left] = rightTemp[j];
				j++;
			}
			left++;
		}
		
		while(k < lArrSize && left <= right) {
			nums[left] = leftTemp[k];
			k++;
			left++;
		}
		
		while(j < rArrSize && left <= right) {
			nums[left] = rightTemp[j];
			j++;
			left++;
		}
	}
	
    public int minimumDifference(int[] nums, int k) {
    	
    	if(nums == null || nums.length == 1 || k == 1) return 0;
    	// Step1: sort 
    	sort(nums);
    	
    	//Step2: run a sliding window of size k on the sorted array
    	// keep track of the minimum difference for each window. The
    	// diff is calculated by subtracting the first element in the window
    	// from the last element of the window. 
    	// because we sorted the array in ascending order already so 
    	// a window retains the increasing order too.
    	// finally return the lowest diff.
    	
    	int left = 0;
    	int right = 0;
    	int minDiff = Integer.MAX_VALUE;
    	
    	while(right < nums.length) {
    		if(right - left + 1 == k) {
    			minDiff = Math.min(nums[right] - nums[left], minDiff);
    			
    			// shrink the window from the left
    			left++;
    		}
    		right++;
    	}
    	
        return minDiff;
    }
	public static void main(String[] args) {
		MinimumDifference ob = new MinimumDifference();
		int[] nums = {90};
		int k = 1;
//		int[] nums = {9,4,1,7};
//		int k = 2;
//		Output: 2
		System.out.println(ob.minimumDifference(nums, k));
		
	}

}
