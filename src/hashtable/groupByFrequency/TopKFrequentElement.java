package hashtable.groupByFrequency;

import java.util.*;
import java.util.Map.Entry;

public class TopKFrequentElement {
	
	public int[] topKFrequent(int[] nums, int k) {

		if(nums.length <= 0) return new int[k];
		int min = nums[0];
		int max = nums[0];
		
		// Time O(n) : finding min,max values from the input list
		// if min,max is known then the range of the input is known to us
		for(int n: nums) {
			if(n > max) {
				max = n;
			} else if(n < min){
				min = n;
			}
		}
		
		// use a frequency counting array like we count frequency 
		// for lower/upper case characters in a given string
		// now define a frequency counting array of range (max-min + 1)
		int[] freq = new int[max-min+1];
		
		// count frequency of the numbers in the input array
		for(int i = 0; i < nums.length; i++) {
			freq[nums[i] - min] += 1;
		}
		
		
		// now we apply Bucket Sort in the frequency array to group the
		// numbers of input into frequency-groups.
		// the idea is "EACH_FREQ_Count" is a bucket.
		
		// for example, 
		// bucket[1] = all elements with frequency 1;
		// bucket[2] = all elements with frequency 2;
		// ...
		// bucket[n] = all elements with frequency n;
		
		// So, there will be len(nums) number of buckets, 
		
		// bucket is an array of lists. Each item in bucket is a
		// list of Integer numbers.
	 	List<Integer>[] bucket = new List[nums.length + 1]; // 1-indexed, because bucket[0] <- invalid
		
		for(int i = 0; i < freq.length; i++) {
			int num = i + min; // reconstructing the original number, similar as (1 + 'a') = b
		
			int freqCount = freq[i];
			
			if(bucket[freqCount] == null) {
				bucket[freqCount] = new ArrayList<>();
			}
			
			bucket[freqCount].add(num); 
		}
		
		int[] res = new int[k];
		// now that we have frequency buckets we can pick the top k freq items
		// by traversing the bucket array backwards by 'k' times.
		
		int idx = 0;
		for(int i = bucket.length - 1; i >= 0; i--) {
			if(bucket[i] != null) {
				for(int n: bucket[i]) {
					res[idx] = n;
					idx++;
					if(idx >= k) {
						break; 
					}
				}
				if(idx >= k) {
					break; 
				}
			}
		}
		return res;
		
	}
	
	public int[] topKFrequentHashMapAndMinHeap(int[] nums, int k) {
		
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
        		(a,b) -> a.getValue() - b.getValue()
        		);
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
        	map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for(Entry<Integer, Integer> anEntry: map.entrySet()) {
        	minHeap.offer(anEntry);
        	
        	while(minHeap.size() > k) {
        		minHeap.poll();
        	}
        }
        
        int[] res = new int[k];
        
        int i = 0;
        while(!minHeap.isEmpty()) {
        	res[i++] = minHeap.poll().getKey();
        }
        
        return res;
    }
	public static void main(String[] args) {
		TopKFrequentElement ob = new TopKFrequentElement();
		
//		int[] nums = {1,1,1,2,2,3};
//		int k = 2;
//		Output: [1,2]
		
//		int[] res = ob.topKFrequentHashMapAndMinHeap(nums, k);
		
//		for(int n: res) {
//			System.out.println(n);
//		}
		
		int[] nums= {1};
		int k = 1;
		
		int[] res = ob.topKFrequent(nums, k);
		
		for(int n: res) {
			System.out.println(n);
		}
	}

}
