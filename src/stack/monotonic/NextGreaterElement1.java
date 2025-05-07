package stack.monotonic;

import java.util.*;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> map = new HashMap<>();
    	Stack<Integer> stack = new Stack<>();
    	
    	int[] res = new int[nums1.length];
    	// Step1: build the greater element map for nums2
        for(int i = nums2.length - 1; i >= 0; i--) {
        	int n = nums2[i];
        	
        	while(!stack.isEmpty() && stack.peek() <= n) {
        		stack.pop();
        	}
        	
        	map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
        	stack.push(n);
        	
        }
        // step2: now pick the correct greater element from the map for num1
        for(int i = 0; i < nums1.length; i++) {
        	if(map.containsKey(nums1[i])) {
        		res[i] = map.get(nums1[i]);
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		NextGreaterElement1 ob = new NextGreaterElement1();
		
//		int[] nums1 = {4,1,2};
//		int[] nums2 = {1,3,4,2};
//		Output: [-1,3,-1]
		
//		int[] nums1 = {2,4};
//		int[] nums2 = {1,2,3,4};
//		Output: [3,-1]
		
//		int[] nums1 = {1,3,5,2,4};
//		int[] nums2 = {5,4,3,2,1};
//		Output: [-1,-1,-1,-1,-1]	
		
		int[] nums1 = {1,3,5,2,4};
		int[] nums2 = {6,5,4,3,2,1,7};
//		Output: [7,7,7,7,7]

		int[] res = ob.nextGreaterElement(nums1, nums2);
		
		for(int n: res) {
			System.out.println(n);
		}
	}

}
