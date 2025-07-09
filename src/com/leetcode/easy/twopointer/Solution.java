package com.leetcode.easy.twopointer;
import java.util.*;


public class Solution {
	
	public int calculate(String s) {
        char prevOperand = '+';
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' ') continue;

            int num = 0;
            
            while("0123456789".indexOf(c) != -1) {
            	int n = Character.getNumericValue(c);
            	num = (num * 10) + n;
            	i++;
            	c = s.charAt(i);
            }
            
            if("+-*/".indexOf(c) != -1) {
            	if(prevOperand == '/' || prevOperand == '*'){
                	apply(stack);
                } else {
                    stack.push(String.valueOf(c));
                }

            } else {
                stack.push(String.valueOf(num));
            }
            
            // check if the previous Operand was a division or multiplication
            // if yes, the immediately 
            if(prevOperand == '/' || prevOperand == '*'){
            	apply(stack);
            }

            if("+-*/".indexOf(c) != -1){
                prevOperand = c;
            }
        }
        while(stack.size() > 1){
        	apply(stack);
        }
        return stack.isEmpty() ? -1 : Integer.parseInt(stack.pop());
    }
	
	private void apply(Stack<String> stack) {
        String b = stack.pop();
        String op = stack.pop();
        String a = stack.pop();
        if(op.equals("/")) {
            int res = Integer.parseInt(a) / Integer.parseInt(b); 
            stack.push(String.valueOf(res)) ;        
        } else if(op.equals("*")) {
            int res = Integer.parseInt(a) * Integer.parseInt(b); 
            stack.push(String.valueOf(res)) ; 
        }  else if(op.equals("+")) {
            int res = Integer.parseInt(a) + Integer.parseInt(b); 
            stack.push(String.valueOf(res)) ;        
        }  else if(op.equals("-")) {
            int res = Integer.parseInt(a) - Integer.parseInt(b); 
            stack.push(String.valueOf(res)) ;        
        }  
	}
    public boolean backspaceCompare(String s, String t) {
        StringBuffer str1 = implementBackspace(s);
        StringBuffer str2 = implementBackspace(t);
        
        int i = str1.length()-1;
        int j = str2.length()-1;
        

        if(i != j) return false;
        
        while(i >= 0 && j >= 0) {
        	if(str1.charAt(i) != str2.charAt(j)) {
        		return false;
        	}
        	i--;
        	j--;
        }
        return true;
    }
    
    private StringBuffer implementBackspace(String s) {
    	
    	int i = s.length() - 1;
    	
    	StringBuffer sb = new StringBuffer();
    	
    	while(i >= 0) {
        	int countBackSpace = 0;
        	
        	if(s.charAt(i) != '#') {
        		sb.append(s.charAt(i));
        		i--;
        	} else {
        		while(i >= 0 && s.charAt(i) == '#') {
        			i--;
        			countBackSpace++;
        		}
        		i = i - countBackSpace;
        	}
    	}
    	return sb;
    }
	public static void main(String[] args) {
		Solution ob = new Solution();
//		String s = "ab#c";
//		String t = "ad#c";
		
//		String s = "a#c";
//		String t = "b";
		
		String s = "bxj##tw";
		String t = "bxo#j##tw";
		
//		System.out.println(ob.backspaceCompare(s, t));
		System.out.println(ob.calculate(" 30/2 "));
		
	}

}

//public int[] shortestToChar(String s, char c) {
//int n = s.length();
//int[] answer = new int[s.length()];
//Arrays.fill(answer, n);
//
//// setting the 'c' porsition to zero
//for(int i = 0; i < s.length(); i++) {
//	if(s.charAt(i) == c) {
//		answer[i] = 0;
//	}
//}
//
//int k = 0;
//
//while(k < s.length()) {
//	if(answer[k] == 0) {
//		int left = k - 1;
//		int right = k + 1;
//
//		// expand towards left
//		int diff = 1;
//		while(left >= 0 && diff < answer[left]) {
//			answer[left] = diff;
//			diff++;
//			left--;
//		}
//		
//		// expand towards right
//		diff = 1;
//		while(right < n && diff < answer[right]) {
//			answer[right] = diff;
//			diff++;
//			right++;
//		}
//	}
//	k++;
//}
//return answer;
//}


//public int countBinarySubstrings(String s) {
//int count = 0;
//for(int i = 0 ; i < s.length() - 1; i++) {
//	// j increments 2 because because every substring will have group of
//	// 1's and 0's. so any substring will be of even length
//	for(int j = i+1; j < s.length(); j+=2) { 
//		String sub = s.substring(i, j+1);
//		if(isGrouped(sub)) {
//			System.out.println(sub);
//			count++;
//		}
//		
//	}
//}
//return count;
//}
//private boolean isGrouped(String sub) {
//int count = 0;
//char candidate = ' ';
//int transition = 0;
//for (int i = 0; i < sub.length(); i++) {
//	char c = sub.charAt(i);
//	
//	if(i > 0 && sub.charAt(i) != sub.charAt(i-1)) {
//		transition++;
//	}
//	
//	if(count == 0) {
//		candidate = c;
//	}
//	
//	if(candidate == c) {
//		count++;
//	} else {
//		count--;
//	}
//}
//return count == 0 && transition < 2;
//}

