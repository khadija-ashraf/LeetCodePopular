package stack.expression;

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
    	
    	int num = 0;
    	int res = 0;
    	Stack<Integer> stack = new Stack<>();
    	char sign = '+';
    	
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	
        	if (c == ' ') continue;
        	
        	if(Character.isDigit(c)) {  // digit
        		num = num * 10 + (c -'0');
        	} 
        	
        	if (!Character.isDigit(c) || i == s.length() - 1){
        		if(sign == '+') stack.push(num);
        		else if (sign == '-') stack.push(-num);
        		else if (sign == '*') stack.push(stack.pop() * num);
        		else if (sign == '/') stack.push(stack.pop() / num);
        		
        		sign = c;
        		num = 0;
        	}
        }
        for(int n: stack) {
        	res += n;
        }
        return res;
    }
	public static void main(String a[]) {
		BasicCalculator2 ob = new BasicCalculator2();
		String s = "3+2*2";
//		Output: 7
		
		System.out.println(ob.calculate(s));
		
	}
}
