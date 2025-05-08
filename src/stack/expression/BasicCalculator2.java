package stack.expression;

import java.util.Stack;

public class BasicCalculator2 {
    public int calculate(String s) {
    	// Intuition: in this approach as soon as we hit an operation '+,-,*,/'
    	// we evaluate the expression value so far. but we evaluate 
    	
    	// start with '+' sign because positive sign is imperative in the
    	// start of every expression. even if an expression starts with a '-'
    	// negative sign can incorporate a positive '+' sign too. 
    	// for example +(-3) = -3.
    	
    	// another intuition is, to process an operation from left to right
    	// we need two numbers. but when we hit an operator we only 
    	// seen the first number. the second number is yet to come.
    	
    	// so, the trick is don't compute an operator until you reach to the 
    	// next operator in the expression. only when we reach to an the next operator 
    	// we see both the numbers involving that operator.
    	// for example, 5 + 9 / 3; until we reach to '/' we don't get to see 5 , and 3.
    	
    	// the next trick is, to prioritize the '*, /' operators over '+,-'
    	// we delay/defer the addition and subtraction by pushing those numbers
    	// involving addition and subtraction. contrary to prioritize '*,/'
    	// we calculate the expression so far as soon as we encounter
    	// the previous sign among '*, or /'.
    	
    	// for an expression starting with a '-' negative sign we push '-num'
    	// that is '-0' in the stack. because, num = 0 at the first iteration.
   
    	Stack<Integer> stack = new Stack<>();
    	int num = 0;
    	int res = 0;
    	char prevSign = '+'; 
    	
        for(int i = 0; i < s.length(); i++) {
        	char cur = s.charAt(i);

        	if(Character.isDigit(cur)) {  // digit
        		num = num * 10 + (cur -'0');
        	} 

        	// process the non-digit, or the last num that does not have any sign after it.
        	if ((!Character.isDigit(cur) && cur != ' ') || i == s.length() - 1){ 

        		if(prevSign == '+') stack.push(num);
        		else if (prevSign == '-') stack.push(-num);
        		else if (prevSign == '*') stack.push(stack.pop() * num);
        		else if (prevSign == '/') stack.push(stack.pop() / num);

        		// we are currently working on the previous sign,
        		// Intuition: When we hit a sign we process the previous sign and 
        		// update previous sign by the current sign.
        		prevSign = cur; // set the current sign as previous sign
        		// since we just processed an operator now set num to zero, 
        		// cause we are going to see a new number after this operator
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
//		String s = "3+2*2";
//		Output: 7
		
		String s = " 3/2 ";
		
		System.out.println(ob.calculate(s));
		
	}
}
