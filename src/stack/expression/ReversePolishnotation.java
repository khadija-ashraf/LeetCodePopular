package stack.expression;

import java.util.*;

public class ReversePolishnotation {
    public int evalRPN(String[] tokens) {
    	if(tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        
        
        for(int i = 0; i < tokens.length; i++) {
        	String cur = tokens[i];
        	if(isOperator(cur)) {
        		int b = stack.pop();
        		int a = stack.pop();
        		stack.push(applyOperator(a,b, cur));
        	} else {
        		stack.push(Integer.parseInt(cur));
        	}
        }
        return stack.pop();
    }
    
    private boolean isOperator(String op) {
    	return "+-*/".contains(op);
    }
    
    private int applyOperator(int a, int b, String op) {
    	switch(op) {
    		case "+": return a + b;
    		case "-": return a - b;
    		case "*": return a * b;
    		case "/": return a/b;
    	}
    	return 0;
    }
    
	public static void main(String[] args) {
		ReversePolishnotation ob = new ReversePolishnotation();
//		String[] tokens = {"2","1","+","3","*"};
//		Output: 9
		
		String[] tokens = {"4","13","5","/","+"};
//		Output: 6

		System.out.println(ob.evalRPN(tokens));
	}

}
