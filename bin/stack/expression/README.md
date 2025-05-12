### [150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/description/)

   You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

   Evaluate the expression. Return an integer that represents the value of the expression.

   Note that:

    The valid operators are '+', '-', '*', and '/'.
    Each operand may be an integer or another expression.
    The division between two integers always truncates toward zero.
    There will not be any division by zero.
    The input represents a valid arithmetic expression in a reverse polish notation.
    The answer and all the intermediate calculations can be represented in a 32-bit integer.

 

   Example 1:

   Input: tokens = ["2","1","+","3","*"]
   Output: 9
   Explanation: ((2 + 1) * 3) = 9

   Example 2:
   
   Input: tokens = ["4","13","5","/","+"]
   Output: 6
   Explanation: (4 + (13 / 5)) = 6

   Example 3:

      Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
      Output: 22
      Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
      = ((10 * (6 / (12 * -11))) + 17) + 5
      = ((10 * (6 / -132)) + 17) + 5
      = ((10 * 0) + 17) + 5
      = (0 + 17) + 5
      = 17 + 5
      = 22

   ### Solution

   Intuition (Reverse Polish Notation):
   * Postfix notation: Operator comes after its operands.
   * "2 1 +" → 2 + 1 = 3
   * "3 *" → 3 * 3 = 9
   * Use a stack:
   * Push numbers
   * On operator, pop two values → apply operator → push result

```java

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

```
Example Walkthrough:

   tokens = ["2", "1", "+", "3", "*"]
   
   Stack Trace:
   
      push 2        → [2]
      push 1        → [2, 1]
      apply +       → [3]      (2+1)
      push 3        → [3, 3]
      apply *       → [9]      (3*3)

      Output: 9

Time & Space:
   * Time: O(n)
   * Space: O(n)
---
### [227. Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/description/)
   Given a string s which represents an expression, evaluate this expression and return its value. 

   The integer division should truncate toward zero.

   You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

   Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

   Example 1:
   Input: s = "3+2*2"  Output: 7
   
   Example 2:
   Input: s = " 3/2 "
   Output: 1
   
   Example 3:
   Input: s = " 3+5 / 2 "
   Output: 5
   
    Constraints:

    - 1 <= s.length <= 3 * 105
    - s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
    - s represents a valid expression.
    - All the integers in the expression are non-negative integers in the range [0, 231 - 1].
    - The answer is guaranteed to fit in a 32-bit integer.

### Solution
   Any char is either a digit, empty space, or an operator. To convert a string digit or set of consecuting digits multiply the number so far by the current digit in the index i;
   
```java
if(Character.isDigit(cur)) {  // digit
  num = num * 10 + (cur -'0');
} 
        	
```
   Intuition: in this approach as soon as we hit an operation '+,-,*,/' or the last number in the input array we evaluate the expression value so far. 
   
   ```java 
     if (!Character.isDigit(cur) || i == s.length() - 1){
   ```  
   
   Another intuition is, to process an operation from left to right we need two numbers. but when we hit an operator we only seen the first number. the second number is yet to come. So, the trick is don't compute an operator until you reach to the next operator in the expression. Only when we reach to an the next operator  we see both the numbers involving that operator. For example, 5 + 9 / 3; until we reach to '/' we don't get to see 5 , and 3.

```java
      public int calculate(String s) {
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
```
  We evaluate starting with '+' sign because positive sign is imperative in the start of every expression. Even if an expression starts with a negative (-) sign it can incorporate a positive '+' sign by multiplying (+1). For example (+1) * (-3) = -3.

  The next trick is, to prioritize the ' * , /' operators over '+,-' we delay/defer the addition and subtraction by pushing those numbers involving addition and subtraction. Contrarily, we calculate the expression so far as soon as we encounter the previous sign among ' *, or /'.

  For an expression starting with a '-' negative sign we push '-num' that is '-0' in the stack. because, num = 0 at the first iteration.

Time & Space:
   * Time: O(n)
   * Space: O(n)
---

