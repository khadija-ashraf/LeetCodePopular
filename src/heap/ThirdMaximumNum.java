package heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ThirdMaximumNum {
	
    public int thirdMax(int[] nums) {
    	if(nums.length <= 0) return -1;
    	
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    	
    	Set<Integer> set = new HashSet<>();
    	
    	for(int n: nums) {
    		if(set.contains(n)) continue;
    		
    		set.add(n);
    		
    		if(minHeap.size() > 3) {
    			minHeap.poll();
    		}
    		minHeap.offer(n);
    	}
    	
    	if(minHeap.size() < 3) {
    		while(minHeap.size() > 1) {
    			minHeap.poll();
    		}
    	}
    	return minHeap.peek();
    }
	public static void main(String[] args) {
		ThirdMaximumNum ob = new ThirdMaximumNum();
    	int[] nums = {3,2,1,1,1,1};
    	System.out.println(ob.thirdMax(nums));

	}

}
