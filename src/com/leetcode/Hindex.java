package com.leetcode;

import java.util.Arrays;

public class Hindex {
	// approach1: 1. sort, 2. traverse reversely 3. if citations[i] >= i
	public int hIndex(int[] citations) {
		Arrays.sort(citations);
 		
		// step1: Sort citation count increasing order
		// step2: traversing from back, starting atleast the paper has the highest citation
		// last two papers has atleas citation[n-2] citations.
		// if citations[i] >= i return. for example, atleast 3 papers has 3 citations, i = 3.
		
		Arrays.sort(citations);
		
//		for(int n: citations) {
//			System.out.println(n);
//		}
		int paperSeq = 0;
		for(int i = citations.length; i >= 1; i--) {
			if(citations[i-1] > paperSeq) {
				paperSeq++;
			}
		}
		return paperSeq;
    }
	public static void main(String a[]) {
		Hindex ob = new Hindex();
		
		int[] citations = {1,3,1};
//		int[] citations = {3,0,6,1,5};
		System.out.println(ob.hIndex(citations));
	}
}
