package com.leetcode.medium;

import java.util.*;

public class Solution {
    public void setZeroes(int[][] matrix) {
    	boolean setFirstRow = false;
    	
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length; j++) {
    			if(matrix[i][j] == 0) {
    				matrix[0][j] = 0;
    				if(i == 0) {
    					setFirstRow = true;
    				} else {
        				matrix[i][0] = 0;
    				}
    			}
    		}
    	}
    	
    	for(int i = 1; i < matrix.length; i++) {
			for(int j = 1; j < matrix[0].length; j++) {
				if(matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}


    	// fill in the first column
    	if(matrix[0][0] == 0) {
    		for(int j = 0; j < matrix.length; j++) {
				matrix[j][0] = 0;
			}
    	}

    	// fill in the first row
    	if(setFirstRow) {
    		for(int j = 0; j < matrix[0].length; j++) {
				matrix[0][j] = 0;
			}
    	}
    }
    
    private void print(int[][] matrix) {
    	int ROW = matrix.length;
    	int COL = matrix[0].length;
    	for(int i = 0; i < ROW; i++) {
    		for(int j = 0; j < COL; j++) {
    			System.out.print(matrix[i][j] +", ");
    		}
    		System.out.println();
    	}
    	System.out.println("====");
    }
    public static void main(String[] args) {
		Solution ob = new Solution();
//		int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
		int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
//		int[][] matrix = {{0},{1}};

		ob.setZeroes(matrix);
	}

}

//public void rotate(int[][] matrix) {
//// transpose, make columns row
////  swap:	matrix[i][j] = matrix[j][i] starting from i = 0, j = i +1
//int ROW = matrix.length;
//int COL = matrix[0].length;
//
//
//for(int i = 0; i < ROW; i++) {
//	for(int j = i+1; j < COL; j++) {
////		swap
//		int temp = matrix[i][j];
//		matrix[i][j] = matrix[j][i];
//		matrix[j][i] = temp;
//	}
//}
//
//// reverse the columns
//
//for(int i = 0; i < ROW; i++) {
//	for(int j = 0; j < COL; j++) {
//		if(j < (COL-1) - j){
//			int temp = matrix[i][j];
//			matrix[i][j] = matrix[i][COL-1-j];
//			matrix[i][COL-1-j] = temp;
//		}
//	}
//}
//
//}


//public boolean isValidSudoku(char[][] board) {
////checking rows
//for(int i = 0; i < board.length; i++) {
//Set<Character> row = new HashSet<>();
//for(int j = 0; j < board[0].length; j++) {
//	if(board[i][j] == '.') continue;
//	if(row.contains(board[i][j])) {
//		return false;
//	} else {
//		row.add(board[i][j]);
//	}
//}
//System.out.println(row);
//
//}
//
////checking cols
//for(int i = 0; i < board[0].length; i++) {
//Set<Character> col = new HashSet<>();
//for(int j = 0; j < board.length; j++) {
//	if(board[j][i] == '.') continue;
//	if(col.contains(board[j][i])) {
//		return false;
//	} else {
//		col.add(board[j][i]);
//	}
//}
//}
//
//
////checking squars'
//Map<Integer, Set<Character>> squares = new HashMap<>();
//
//for(int i = 0; i < 9; i++) {
//squares.put(i, new HashSet<Character>());
//}
//
//for (int row = 0; row < 9; row++) {
//for (int col = 0; col < 9; col++) {
//	int key = (row / 3) * 3 + (col / 3);
//	if(board[row][col] == '.') continue;
//	if(squares.get(key).contains(board[row][col])) {
//		return false;
//	} else {
//		Set<Character> set = squares.get(key);
//		set.add(board[row][col]);
//		squares.put(key, set);
//	}
//}
//} 
//
//return true;
//}


//public List<Integer> spiralOrder(int[][] matrix) {
//int top = 0; // top row
//int bottom = matrix.length; // top row
//int left = 0; // left col
//int right = matrix[0].length; // right col
//
//List<Integer> res = new ArrayList<Integer>();
//
//while(top < bottom && left < right) {
//	// traverse top row from left to right
//	for(int i = left; i < right; i++) {
//		res.add(matrix[top][i]);
//	}
//	top++;
////	System.out.println("top:"+ res);
//
//	// traverse rightmost col from top to bottom
//	
//	for(int i = top; i < bottom; i++) {
//		res.add(matrix[i][right-1]);
//	}
//	right--;
////	System.out.println("right:"+ res);
//
//	if(!(top < bottom && left < right)) {
//		break;
//	}
//	// traverse bottom row from right to left
//	for(int i = right-1; i >= left; i--) {
//		res.add(matrix[bottom-1][i]);
//	}
//	bottom--;
////	System.out.println("bottom:"+ res);
//
//	// traverse left col from bottom to top
//	
//	for(int i = bottom-1; i >= top; i--) {
//		res.add(matrix[i][left]);
//	}
//	left++;
////	System.out.println("left:"+ res);
////	System.out.println("================");
//}
//return res;
//}


//public int lengthOfLongestSubstring(String s) {
//
//	int left = 0;
//	int right = 0;
//	int maxLen = 0;
//	
//	HashSet<Character> set = new HashSet<Character>();
//	
//	while(right < s.length()) {
//		char c = s.charAt(right);
//		
//		if(!set.contains(c)) {
//			set.add(c);
//			maxLen = Math.max(maxLen, right-left+1);
//			right++;
//		} else {
//			set.remove(s.charAt(left));
//			left++;
//		}
//	}
//	return maxLen;
//	
//}


//public int minSubArrayLen(int target, int[] nums) {
//
//if(nums.length == 0) return 0;
////if(nums.length == 1) return nums[0] >= target ? 1: 0;
//
//int left = 0;
//int right = 0;
//int minLen = Integer.MAX_VALUE;
//int sum = nums[left];
//
//while(right < nums.length && left < nums.length && left <= right) {
//	if(sum >= target) {
//		minLen = Math.min(minLen, (right-left+1));
//		sum = sum - nums[left];
//		left++;
//	} else {
//		right++;
//		if(right < nums.length)
//			sum += nums[right];
//	}
//}
//
//return minLen == Integer.MAX_VALUE ? 0: minLen;
//}


//public List<List<Integer>> threeSum(int[] nums) {
//List<List<Integer>> res = new ArrayList<List<Integer>>();
//
////the input array is sorted in ascending order
//Arrays.sort(nums);
//
////[-1,0,1,2,-1,-4]
//
////sorted: {-4, -1, -1, 0, 1, 2}
////sorted: {-4, -1, -1, 0, 1, 2}
//
//for(int i = 0; i < nums.length; i++) {
//	// skipping the duplicates in the sorted array
//	if(i > 0 && nums[i] == nums[i-1]) continue;
//	
//	int left = i+1;
//	int right = nums.length - 1;
//
//	while(left < right) {
//
//		int sum = nums[i] + nums[left] + nums[right];
//
//		if(sum == 0) {
//			List<Integer> tuple = new ArrayList<>();
//			tuple.add(nums[i]);
//			tuple.add(nums[left]);
//			tuple.add(nums[right]);
//			
//			res.add(tuple);
//			
//    		//skipping duplicate
//    		while(left < right
//    				&& nums[left] == nums[left+1]) {
//    			left++;
//    		}
//    		
//    		//skipping duplicate
//    		while(left < right
//    				&& nums[right] == nums[right-1]) {
//    			right--;
//    		}
//
//    		
//			left++;
//			right--;
//			
//		} else if(sum > 0){
//			right--;
//		} else {
//			left++;
//		}
//	}
//}
//return res;
//}


//public int maxArea(int[] height) {
//int max = Integer.MIN_VALUE;
//int left = 0;
//int right = height.length - 1;
//
//while(left < right) {
//	int area = Math.min(height[left], height[right]) 
//			* (right - left);
//	
//	max = Math.max(max, area);
//	
//	if((left + 1 < right - 1) 
//			&& (height[left + 1] > height[right - 1])) {
//		left++;
//	} else {
//		right--;
//	}
//	
//}
//return max;
//}


//public String convert(String s, int numRows) {
//if(numRows == 1) return s;
//
//StringBuffer sb = new StringBuffer();
//int skip = 2 * (numRows - 1);
//
//for(int i = 0; i < numRows; i++) {
//	int k = i;
//	while(k < s.length()) {
//		sb.append(s.charAt(k));
//		
//		if(i > 0 && i < numRows - 1) {
//			int additionalCharIdx = k + skip - 2 * i;
//			if(additionalCharIdx < s.length()) {
//				sb.append(s.charAt(additionalCharIdx));
//			}
//		}
//		k += skip;
//	}
//}
//return sb.toString();
//}


//class Mapping{
//String c;
//int val;
//
//public Mapping() {
//	
//} 
//
//public Mapping(String c, int val) {
//	this.c = c;
//	this.val = val;
//}
//}

//public String intToRoman(int num) {
//    List<Mapping> list = new ArrayList<Mapping>();
//    
//    list.add(0, new Mapping("I", 1));
//    list.add(1, new Mapping("IV", 4));
//    list.add(2, new Mapping("V", 5));
//    list.add(3, new Mapping("IX", 9));
//    list.add(4, new Mapping("X", 10));
//    list.add(5, new Mapping("XL", 40));
//    list.add(6, new Mapping("L", 50));
//    list.add(7, new Mapping("XC", 90));
//    list.add(8, new Mapping("C", 100));
//    list.add(9, new Mapping("CD", 400));
//    list.add(10, new Mapping("D", 500));
//    list.add(11, new Mapping("CM", 900));
//    list.add(12, new Mapping("M", 1000));
//    
//    StringBuffer sb = new StringBuffer();
//    
//    while(num!=0) {
//    	for(int i = list.size() - 1; i >=0; i--) {
//    		
//    		int quotient = num / list.get(i).val;
//    		
//    		if(quotient > 0) {
//        		while(quotient > 0) {
//        			sb.append(list.get(i).c);
//        			quotient--;
//        		}
//        		num = num % list.get(i).val;
//        		break;
//    		} 
//    	}
//    }
//    return sb.toString();
//}
//


//public String reverseWords(String s) {
//	char[] arr = new char[s.length()];
//	int charIdx = 0;
//	//cleanup 
//	
//	int k = 0;
//	int j = 0;
//	int n = s.length();
//	
//	while(j < n) {
////		skip spaces
//		while(j <n && s.charAt(j) == ' ') j++;
//		
////		copy non space chars
//		while(j< n && s.charAt(j) != ' ') {
//			arr[k] = s.charAt(j);
//			k++;
//			j++;
//		}
//		// check if any space after the word
//		while(j<n && s.charAt(j) == ' ') j++;
//		// if any then add only on space for all the 
//		// spaces there might be
//		if(j < n) {
//			arr[k] = ' ';
//			k++;
//		}
//	}
//	
//	int newLen = k;
//	// reverse the the clean string
//	int left = 0;
//	int right = newLen - 1;
//	
//    while(left < right) {
//    	//swap
//    	char temp = arr[left];
//    	arr[left] = arr[right];
//    	arr[right] = temp;
//    	
//    	left++;
//    	right--;
//    }
//    
//    // now that the entire sentence is reversed we 
//    // reverse each word
//	int start = 0;
//	int end = 0;
//    for(int i = 0; i < newLen; i++) {
//    	while(i < newLen && arr[i] != ' ') {
//    		i++;
//    	}
//		// the end of a word found
//		end = i-1;
//
//    	// now reverse the word
//    	while(start < end) {
//    		char temp = arr[start];
//    		arr[start] = arr[end];
//    		arr[end] = temp;
//    		start++;
//    		end--;
//    	}
//    	start = i+1;
//    	end = i+1;
//    }
//    
//    return new String(arr, 0, newLen);
//}

