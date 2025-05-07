package com.leetcode;

import java.util.List;
import java.util.ArrayList;

public class FizzBuzz {
	public List<String> fizzBuzz(int n) {
		if(n <= 0) return null;
				
		List<String> res = new ArrayList<String>();
		
        for(int i = 1; i <= n; i++) {
        	if(i%3 == 0 && i%5 == 0) {
        		res.add("FizzBuzz");
        	} 

        	else if(i%3 == 0) {
        		res.add("Fizz");
        	}
        	
        	else if(i%5 == 0) {
        		res.add("Buzz");
        	}
        	
        	else {
        		res.add(String.valueOf(i));
        	}
        }
        return res;
    }
	
	public static void main(String a[]) {
		FizzBuzz ob = new FizzBuzz();
		
		System.out.println(ob.fizzBuzz(3));
	}
}
