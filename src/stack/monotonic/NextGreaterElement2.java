package stack.monotonic;

import java.util.*;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        int len = nums.length;
        for(int i = len*2 - 1; i >= 0; i--) {
        	int n = nums[i % len];
        	
        	while(!stack.isEmpty() && stack.peek() <= n) {
        		stack.pop();
        	}
        	
        	map.put(n, stack.isEmpty() ? -1 : stack.peek());
        	stack.push(n);
        }
        
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
        	res[i] = map.get(nums[i]);
        }
        return res;
    }
	public static void main(String[] args) {
		NextGreaterElement2 ob = new NextGreaterElement2();
		
//		int[] nums = {1,2,1};
//		Output: [2,-1,2]

		int[] nums = {5,4,3,2,1};
//		Output: [-1,5,5,5,5]
						
		int[] res = ob.nextGreaterElements(nums);
		
		for(int n: res) {
			System.out.println(n);
		}
	}

}
