package com.leetcode;

import java.util.Arrays;

public class Hindex {
	// approach1: 1. sort, 2. traverse reversely 3. if citations[i] >= i
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
 		
		for(int i = citations.length - 1; i >= 0; i--) {
			if((citations.length - i) > citations[i]) {
				return i +1;
			}
		}
		return 0;
    }
	public static void main(String a[]) {
		Hindex ob = new Hindex();
		
//		int[] citations = {1,3,1};
		int[] citations = {3,0,6,1,5};
		System.out.println(ob.hIndex(citations));
	}
}
