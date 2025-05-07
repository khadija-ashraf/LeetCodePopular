package stack;

import java.util.*;

public class DailyTemparature {
    public int[] dailyTemperatures(int[] temperatures) {
    	
        Stack<Integer> stack = new Stack<>(); // stores indices
        int[] answer = new int[temperatures.length];
        
        stack.push(0);
        
        for(int i = 1; i < temperatures.length; i++) {
        	while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
        		int poppedIdx = stack.pop();
        		answer[poppedIdx] = i - poppedIdx;
        	}
        	stack.push(i);
        }
        return answer;
        		
    }
	public static void main(String[] args) {
		DailyTemparature ob = new DailyTemparature();
		
//		int[] temperatures = {73,74,75,71,69,72,76,73};
//		Output: [1,1,4,2,1,1,0,0]
		
//		int[] temperatures = {30,40,50,60};
//		Output: [1,1,1,0]
		
		int[] temperatures = {30,60,90};
//		Output: [1,1,0]
						
		int[] answer = ob.dailyTemperatures(temperatures);

		for(int n: answer) {
			System.out.println(n);
		}
	}

}
