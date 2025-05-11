package com.leetcode.easy.array;

public class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		int count = 0;
		int max = 0;
		
        for(int i = 0; i < nums.length; i++) {
        	if(nums[i] == 1) {
        		count++;
        		max = Math.max(max, count);
        	} else {
        		count = 0;
        	}
        }
        return max;
    }
	
	public static void main(String a[]) {
		Solution ob = new Solution();
		
		int[] nums = {1,1,0,1,1,1};
		System.out.println(ob.findMaxConsecutiveOnes(nums));
	}
}



//public String licenseKeyFormatting(String s, int k) {
//
//StringBuffer cleaned = new StringBuffer();
//
//// remove all '-' dashes and convert to uppercase
//for(char c: s.toCharArray()) {
//	if(c != '-') {
//		cleaned.append(Character.toUpperCase(c));
//	}
//}
//
//// add '-' dashes from the back towards front in every k char
//StringBuffer res = new StringBuffer();
//
//int count = 0;
//for(int i = cleaned.length() - 1; i >= 0; i--) {
//	res.append(cleaned.charAt(i));
//	count++;
//	if(count == k && i != 0) {
//		res.append('-');
//		count = 0;
//	}
//}
//return res.reverse().toString();
//}


//public int islandPerimeter(int[][] grid) {
//	int perimeter = 0;
//	
//	int ROW = grid.length;
//	int COL = grid[0].length;
//	
//	int[][] deltas = {{-1,0},{1,0},{0,1}, {0,-1}};
//
//    for(int i = 0; i < ROW; i++) {
//    	for(int j = 0; j < COL; j++) {
//    		
//    		if(grid[i][j] == 1) {
//        		int localPeri = 0;
//        		for(int[] delta: deltas) {
//        			int r = i + delta[0];
//        			int c = j + delta[1];
//        			
//            		if(!isInBounds(r, c, ROW, COL) || grid[r][c] == 0) {
//            			localPeri += 1;
//            		}
//        		}
//        		perimeter += localPeri;
//    		}
//
//    	}
//    }
//    return perimeter;
//}

//public boolean isInBounds(int i, int j, int ROW, int COL) {
//	 return (i >= 0 && i < ROW) && (j >= 0 && j < COL);
//}

//public boolean repeatedSubstringPattern(String s) {
//String doubled = s.concat(s);
//String trimmed = doubled.substring(1, doubled.length() - 1);
//return trimmed.contains(s);
//}


//public int findContentChildren(int[] g, int[] s) {
//if(g.length <= 0 || s.length <= 0) {
//	return 0;
//}
//
//int count = 0;
//
//Arrays.sort(g);
//Arrays.sort(s);
//for(int i = 0 ; i < g.length; i++) {
//	for(int j = 0; j < s.length; j++) {
//  	if(s[j] != -1 && s[j] >= g[i]) {
//  		count += 1;
//  		s[j] = -1;
//  		break;
//  	} 
//	}
//}
//return count;
//}


//public List<Integer> findDisappearedNumbers(int[] nums) {
//if(nums.length <= 0) {
//	return null;
//}
//
//List<Integer> res = new ArrayList<Integer>();
//
//int[] fre = new int[nums.length + 1];
//
//for(int n: nums) {
//	fre[n] += 1;
//}
//
//for(int i = 1; i <= nums.length; i++) {
//	if(fre[i] == 0) {
//		res.add(i);
//	}
//}
//return res;
//}


//public int countSegments(String s) {
//
//if(s.length() <= 0) {
//	return 0;
//}
//return s.trim().split(" ").length;
//}


//public String addStrings(String num1, String num2) {
//
//if(num1.length() <= 0) return num2;
//
//if(num2.length() <= 0) return num1;
//
//int carry = 0;
//StringBuffer sb = new StringBuffer();
//
//
//int i = num1.length() - 1; 
//int j = num2.length() - 1;
//
//while(i >= 0 || j >= 0|| carry > 0) {
//	int d1 = 0;
//	int d2 = 0;
//	
//	if(i >= 0) {
//		d1 = num1.charAt(i) - '0';
//	}
//	if(j >= 0) {
//		d2 = num2.charAt(j) - '0';
//	}
//	
//	int sum = d1 + d2 + carry;
//	
//	carry = sum / 10;
//	int digit = sum % 10;
//	
//	sb.append(digit);
//	 i--;
//	 j--;
//}
//return sb.reverse().toString();
//}


//public int thirdMax(int[] nums) {
//
//int max = Integer.MIN_VALUE;
//int secondeMax = Integer.MIN_VALUE + 1;
//int thirdMax = Integer.MIN_VALUE + 2;
//
//for(int i = 0; i < nums.length; i++) {
//	max = Math.max(max, nums[i]);
//}
//
//for(int i = 0; i < nums.length; i++) {
//	if(nums[i] > secondeMax && nums[i] < max) {
//		secondeMax = Math.max(secondeMax, nums[i]);
//	}
//}
//
//for(int i = 0; i < nums.length; i++) {
//	if(nums[i] > thirdMax && nums[i] < secondeMax) {
//		thirdMax = Math.max(thirdMax, nums[i]);
//	}
//}
//return thirdMax == Integer.MIN_VALUE + 2 ? secondeMax : thirdMax;
//}


//public int longestPalindrome(String s) {
//int max = 0;
//for(int i = 0; i < s.length(); i++) {
//	int oddLen = palindrome(s, i, i);
//	int evenLen = palindrome(s, i, i+1);
//	
//	max = Math.max(max, Math.max(oddLen, evenLen));
//}
//return max;
//}
//
//public int palindrome(String s, int left, int right) {
//int len = 0;
//while(left >= 0 && right < s.length()) {
//	if(s.charAt(left) == s.charAt(right)) {
//		len = right - left + 1;
//		left--;
//		right++;
//	} else {
//		break;
//	}
//}
//return len;
//}


//public boolean isSubsequence(String s, String t) {
//int i = 0;
//int j = 0;
//
//while(i < s.length() && j < t.length()) {
//	if(s.charAt(i) == t.charAt(j)) {
//		i++;
//		j++;
//	} else {
//  	j++;
//	}
//}
//return i == s.length();
//}


//public char findTheDifference(String s, String t) {
//int xor = 0;
//
//for(int i = 0; i < t.length(); i++) {
//	xor = xor ^ t.charAt(i);
//}
//
//for(int i = 0; i < s.length(); i++) {
//	xor = xor ^ s.charAt(i);
//}
//
//return (char) xor;
//}


//public int firstUniqChar(String s) {
//	if(s.length() <= 0) {
//    	return -1;
//    }
//	
//	if(s.length() == 1) {
//    	return 0;
//    }
//    
//	Map<Character, Integer> map = new HashMap<Character, Integer>();
//	
//    char[] sArr = s.toCharArray();
//    
//    for(int i = 0; i < sArr.length; i++) {
//    	if(map.containsKey(sArr[i])) {
//    		map.put(sArr[i], map.get(sArr[i]) + 1);
//    	} else {
//        	map.putIfAbsent(sArr[i], 1);
//    	}
//    	
//    }
//    for(int i = 0; i < sArr.length; i++) {
//    	if(map.get(sArr[i]) == 1) return i;
//    }
//    return -1;
//}


//public boolean canConstruct(String ransomNote, String magazine) {
//if(magazine.length() <= 0) {
//	return false;
//}
//
//if(ransomNote.length() <= 0) {
//	return true;
//}
//
//if(ransomNote.length() > magazine.length()) {
//	return false;
//}
//
//char[] rArr = ransomNote.toCharArray();
//char[] mArr = magazine.toCharArray();
//
//for(int i = 0; i < rArr.length; i++) {
//	boolean matched = false;
//	for(int j = 0; j < mArr.length; j++) {
//		if(rArr[i] == mArr[j]) {
//			matched = true;
//			mArr[j] = '#';
//			break;
//		}
//	}
//	if(!matched) {
//		return false;
//	}
//}
//return true;
//}


//public int[] intersect(int[] nums1, int[] nums2) {
//if(nums1.length <= 0 || nums2.length <= 0) {
//	return new int[0];
//}
//
//List<Integer> res = new ArrayList<Integer>();
//
//for(int i = 0; i < nums1.length; i++) {
//	for(int j = 0; j < nums2.length; j++) {
//		if(nums1[i] == nums2[j]) {
//			res.add(nums1[i]);
//			nums2[j] = -111; 
//			break;
//		}
//	}
//}
//int i = 0;
//int[] result = new int[res.size()];
//
//Iterator<Integer> itr = res.iterator();
//while(itr.hasNext()) {
//	result[i] = itr.next();
//	i++;
//}
//return result;
//}


//public int[] intersection(int[] nums1, int[] nums2) {
//    if(nums1.length <= 0 || nums2.length <= 0) {
//    	return new int[0];
//    }
//    
//    Set<Integer> set = new HashSet<Integer>();
//    for(int i = 0; i < nums1.length; i++) {
//    	for(int j = 0; j < nums2.length; j++) {
//    		if(nums1[i] == nums2[j] && !set.contains(nums1[i])) {
//    			set.add(nums1[i]);
//    		}
//    	}
//    }
//    int i = 0;
//   
//    int[] res = new int[set.size()];
//    
//    Iterator<Integer> itr = set.iterator();
//    while(itr.hasNext()) {
//    	res[i] = itr.next();
//    	i++;
//    }
//    return res;
//}

//public String reverseVowels(String s) {
//int left = 0;
//int right = s.length() - 1;
//String vowels = "aeiouAEIOU";
//
//char[] sArr = s.toCharArray();
//
//while(left < right) {
//	while(left < right && vowels.indexOf(sArr[left]) == -1) {
//		left++;
//	}
//	while(left < right && vowels.indexOf(sArr[right]) == -1) {
//		right--;
//	}
//	
//	//swap
//	char temp = sArr[left];
//	sArr[left] = sArr[right];
//	sArr[right] = temp;
//	
//	left++;
//	right--;
//}
//return new String(sArr);
//
//}


//


//public boolean wordPattern(String pattern, String s) {
//
//String[] sArr = s.split(" ");
//
//if(pattern.length() != sArr.length) return false;
//
//Map<Character, String> map = new HashMap<>();
//
//for(int i = 0; i < pattern.length(); i++) {
//	if(map.containsKey(pattern.charAt(i))) {
//		if(!map.get(pattern.charAt(i)).equalsIgnoreCase(sArr[i])) {
//			return false;
//		}
//	} else if(map.containsValue(sArr[i])) {
//		return false;
//	} else {
//		map.put(pattern.charAt(i), sArr[i]);
//	}
//}
//return true;
//
//}


//public void moveZeroes(int[] nums) {
//if(nums.length <= 1) return;
//
//int k = 0;
//
//for(int i = 0; i < nums.length; i++) {
//	if(nums[i] != 0) {
//		if(i != k) {
//			int temp = nums[k];
//			nums[k] = nums[i];
//			nums[i] = temp;
//		}
//		k++;
//	}
//}
//}


//public int missingNumber(int[] nums) {
//int xor = 0;
//for(int i = 0; i < nums.length; i++) {
//	xor = xor ^ i ^ nums[i];
//}
//
//return xor ^ nums.length;
//}


//public List<String> binaryTreePaths(TreeNode root) {
//// When the root is empty it means the tree is empty
//// therefore no  path is present so we return an empty list.
//if(root == null) {
//	return List.of();
//}
//
//// When the root.left and root.right both are null that means,
//// this is a leaf node. so we reached a leaf node, so we 
//// return the this node value as part of our path.
//if(root.left == null && root.right == null) {
//	return List.of(String.valueOf(root.val));
//}
//
//List<String> allPath = new ArrayList<String>();
//
//List<String> leftPath = binaryTreePaths(root.left);
//List<String> rightPath = binaryTreePaths(root.right);
//
//for(String path: leftPath) {
//	String newPath = String.valueOf(root.val) + "->" + path;
//	allPath.add(newPath);
//}
//
//for(String path: rightPath) {
//	String newPath = String.valueOf(root.val) + "->" + path;
//	allPath.add(newPath);
//}
//
//return allPath;
//}


//public boolean isAnagram(String s, String t) {
//if(s.length() != t.length()) {
//	return false;
//}
//
//Map<Character, Integer> sMap = new HashMap<Character, Integer>();
//Map<Character, Integer> tMap = new HashMap<Character, Integer>();
//
//for(int i = 0; i < s.length(); i++) {
//	if(sMap.containsKey(s.charAt(i))) {
//		sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
//	} else {
//		sMap.put(s.charAt(i), 1);
//	}
//	
//	if(tMap.containsKey(t.charAt(i))) {
//		tMap.put(t.charAt(i), tMap.get(t.charAt(i)) + 1);
//	} else {
//		tMap.put(t.charAt(i), 1);
//	}
//}
//
//return sMap.equals(tMap);
//}


//public List<String> summaryRanges(int[] nums) {
//List<String> res = new ArrayList<String>();
//
//for(int i = 0; i < nums.length; i++) {
//	int k = i;
//	
//	while(i+1 < nums.length && nums[i] + 1 == nums[i+1]) {
//		i++;
//	}
//	if(i > k) {
//		res.add(String.valueOf(nums[k]) + "->"+String.valueOf(nums[i]));
//	} else {
//		res.add(String.valueOf(nums[k]));
//	}
//}
//return res;
//}


//public boolean containsNearbyDuplicate(int[] nums, int k) {
//
//// (key = num[i], val = i)
//Map<Integer, Integer> map = new HashMap<>();
//
//for(int i = 0; i < nums.length; i++) {
// if(map.containsKey(nums[i])) {
//	   int prevIdx = map.get(nums[i]);
//	   
//	   if(Math.abs(i - prevIdx) <= k) {
//		   return true;
//	   } else {
//		   map.put(nums[i], i);
//	   }
// } else {
//	   map.put(nums[i], i);
// }
//}
//return false;
//}


//public boolean containsDuplicate(int[] nums) {
//if(nums.length <= 0) return false;
//
//Set<Integer> set = new HashSet<>();
//
//for(int n: nums) {
//	set.add(n);
//}
//
//return !(nums.length == set.size());
//		
//}


//public boolean isIsomorphic(String s, String t) {
//if(s.length() != t.length()) {
//	return false;
//}
//
//Map<Character, Character> sToT = new HashMap<>();
//Map<Character, Character> tToS = new HashMap<Character, Character>();
//
//for(int i = 0 ; i < s.length(); i++) {
//	char ch1 = s.charAt(i);
//	char ch2 = t.charAt(i);
//	
//	if(sToT.containsKey(ch1)) {
//		if(sToT.get(ch1) != ch2) {
//			return false;
//		}
//	}else {
//		sToT.put(ch1, ch2);
//	}
//	
//	if(tToS.containsKey(ch2)) {
//		if(tToS.get(ch2) != ch1) {
//			return false;
//		}
//	} else {
//		tToS.put(ch2, ch1);
//	}
//}
//return true;
//}


//public int titleToNumber(String columnTitle) {
//	int num = 0;
//    for(int i = columnTitle.length() - 1; i >= 0; i--) {
//    	char c = columnTitle.charAt(i);
//    	int charVal = c - 'A';
//    	charVal++;
//    	
//		int exponent = columnTitle.length() - 1 - i;
//		int exponentVal = 1;
//		
//		for(int j = 1; j <= exponent; j++) {
//			exponentVal  = 26;
//		}
//		
//		num = num + (exponentVal   charVal);
//
//    }
//    return num;
//}


//public String convertToTitle(int columnNumber) {
//    
//	int num = columnNumber;
//	StringBuffer sb = new StringBuffer();
//	while(num != 0) {
//		num--; // Shift to 0-indexed
//		int quotient = num / 26;
//		int remainder = num % 26;
//		
//		num = quotient;
////		the remainder is the digit in the new number system
//		char c =  (char)('A' + remainder);
//		sb.append(c);
//		
//	}
//	return sb.reverse().toString();
//}
//
//public int singleNumber(int[] nums) {
//	int res = 0;
//    for(int n: nums) {
//    	res  = res ^ n;
//    }
//    return res;
//}
//public List<Integer> getRow(int rowIndex) {
//if(rowIndex < 0) {
//	return null;
//}
//
//List<Integer> prev = new ArrayList<>();
//for(int i = 0; i <= rowIndex; i++) {
//	List<Integer> row = new ArrayList<Integer>();
//	
//	for(int j = 0; j <= i; j++) {
//		if(j == 0 || j == i) {
//			row.add(1);
//		} else {
//			row.add(prev.get(j-1) + prev.get(j));
//		}
//	}
//	prev = row;
//}
//return prev;
//
//}



//public List<List<Integer>> generate(int numRows) {
//	
//	if(numRows <= 0) return List.of(List.of());
//	
//    List<List<Integer>> res = new ArrayList<>();
//	
//    for (int i = 0; i < numRows; i++) {
//    	List<Integer> row = new ArrayList<>();
//		
//    	for (int j = 0; j <= i; j++) {
//			// add '1' in the both first and last location
//    		if (j == 0 || j == i) {
//                row.add(1);
//    		} else {
//    			// for the middle elements
//				int val = res.get(i - 1).get(j-1) + res.get(i - 1).get(j);
//				row.add(val);
//    		}
//		}
//		res.add(row);
//	}
//	return res;
//    
//}

//public TreeNode sortedArrayToBST(int[] nums) {
//	return buildBST(nums, 0, nums.length - 1);
//    
//}
//
//public TreeNode buildBST(int[] nums, int left, int right) {
//	if(left > right) {
//		return null;
//	}
//	
//	int mid = left + (right - left)/2;
//	
//	TreeNode root = new TreeNode(nums[mid]);
//	
//	root.left = buildBST(nums, left, mid - 1);
//	root.right = buildBST(nums, mid + 1, right);
//	return root;
//}
//
//public void print(TreeNode root) {
//	if(root == null) {
//		System.out.print("null, ");
//		return;
//	}
//	
//	print(root.left);
//	System.out.print(root.val + ", ");
//	print(root.right);
//}


//
//public String addBinary(String a, String b) {
//    
//	if(a.length() <= 0) return b;
//	
//	if(b.length() <= 0) return a;
//	
//	StringBuffer sb = new StringBuffer();
//	
//	int carry = 0;
//	int i = a.length() - 1;
//	int j = b.length() - 1;
//	
//	while(i >= 0 || j >= 0 || carry > 0) {
//		int sum = carry;
//		
//		if(i >= 0) {
//			sum += a.charAt(i) - '0';
//			i--;
//		}
//		
//		if(j >=0) {
//			sum += b.charAt(j) - '0';
//			j--;
//		}
//		
//		int digit = sum % 2;
//		carry = sum/2;
//		
//		sb.append(digit);
//		
//	}
//	return sb.reverse().toString();
//}




//public int[] plusOne(int[] digits) {
//if(digits.length <= 0) {
//	return new int[0];
//}
//
//int carry = 0;
//int finalCarry = 0;
//
//for(int i = digits.length - 1; i >= 0; i--) {
//	int sum = digits[i];
//	
//	if(i == digits.length - 1) {
//		sum = sum + 1;
//	}
//
//	if(carry > 0) {
//		sum = sum + carry;
//	}
//	
//	carry = sum / 10;
//	finalCarry = carry;
//
//	int digit = sum % 10;
//	
//	digits[i] = digit;
//}
//int[] newDigits = new int[digits.length + 1];
//
//if(finalCarry > 0) {
//	newDigits[0] = finalCarry;
//	
//	for(int i = 0; i < digits.length; i++) {
//		newDigits[i+1] = digits[i];
//	}
//	return newDigits;
//} else 
//	return digits;
//}


//public int lengthOfLastWord(String s) {
//if(s.length() <= 0) return 0;
//
//String[] strArr = s.split(" ");
//
//if(strArr.length <= 0) return 0;
//
//String lastString = strArr[strArr.length - 1];
//
//return lastString.length();
//}
//


//public int searchInsert(int[] nums, int target) {
//if(nums.length <= 0) {
//	return -1;
//}
//return binSearch(nums, 0, nums.length - 1, target);
//}
//
//public int binSearch(int[] nums, int left, int right, int target) {
//
//if(left >= nums.length) {
//	return nums.length; 
//}
//
//if(right < 0) {
//	return 0; 
//}
//
//if(left > right) {
//	return left;
//}
//
//int mid = left + (right - left)/2;
//
//if(nums[mid] == target) {
//	return mid;
//}
//
//if(target > nums[mid]) {
//	left = mid + 1;
//} else {
//	right = mid - 1;
//} 
//
//return binSearch(nums, left, right, target);
//}


//public int strStr(String haystack, String needle) {
//if(haystack.length() <= 0 || needle.length() <= 0) {
//	return -1;
//}
//
//int left = 0;
//
//for(int i = 0; i < haystack.length(); i++) {
//	int k = 0;
//	left = i;
//	while(k < needle.length() && left < haystack.length()) {
//		if(haystack.charAt(left) == needle.charAt(k)) {
//			k++;
//			left++;
//		} else {
//			break;
//		}
//	}
//	if(k == needle.length()) {
//		return i;
//	}
//}
//return -1;
//}

//public int removeElement(int[] nums, int val) {
//    if(nums.length <= 0) {
//    	return 0;
//    }
//    
//    int k = 0;
//    for(int i = 0; i< nums.length; i++) {
//    	if(nums[i] != val) {
//    		nums[k] = nums[i];
//    		k++;
//    	}
//    }
//    return k;
//}


//public boolean isValid(String s) {
//	
//	if(s.length() <= 1) return false;
//	
//	
//    Map<Character, Character> map = new HashMap<>();
//    Stack<Character> stack = new Stack<>();
//    
//    map.put(')', '(');
//    map.put(']', '[');
//    map.put('}', '{');
//    
//    for(int i = 0; i < s.length(); i++) {
//    	char c = s.charAt(i);
//    	if(map.containsKey(c) && !stack.isEmpty()) {
//    		char pair = stack.pop();
//    		
//    		if(!(pair == map.get(c))) {
//    			return false;
//    		}
//    	} else {
//    		stack.add(c);
//    	}
//    }
//    return stack.isEmpty();
//    
//}

//public String longestCommonPrefix(String[] strs) {
//	
//	if(strs.length <= 0) return "";
//	
//	if(strs.length == 1) return strs[0];
//	
//	int i = 0;
//	int prefixIdx = Integer.MAX_VALUE;
//
//	
//	while(i < strs.length  - 1) {
//		String word1 = strs[i];
//    	String word2 = strs[i+1];
//    	
//    	int loopIdx = 0;
//    	int localPrefixLen = 0;
//    	
//    	while(loopIdx < word1.length() && loopIdx < word2.length()) {
//    		if(word1.charAt(loopIdx) == word2.charAt(loopIdx)) {
//    			localPrefixLen++;
//    		}else {
//    			break;
//    		}
//    		loopIdx++;
//    	}
//		prefixIdx = Math.min(prefixIdx, localPrefixLen - 1);
//
//    	i++;
//    }
//	
//	if(prefixIdx == Integer.MAX_VALUE) prefixIdx = 0;
//	
//	return strs[0].substring(0, prefixIdx + 1);
//}


//	public int[] twoSum(int[] nums, int target) {
//        if(nums.length <= 0) return new int[] {0,0};
//        
//        int[] res = new int[2];
//        
//        Map<Integer, Integer> map = new HashMap<>();
//        
//        for(int i = 0; i < nums.length; i++) {
//        	
//        	int pair = target - nums[i];
//        	
//        	if(map.containsKey(pair)) {
//        		res[0] = map.get(pair);
//        		res[1] = i;
//        		return res;
//        	}
//        	map.putIfAbsent(nums[i], i);
//        }
//        return res;
//	}

//public int romanToInt(String s) {
//	if(s.length() <= 0) return 0;
//	
//	Map<Character, Integer> map = new HashMap<>();
//    
//	map.put('I', 1);
//	map.put('V', 5);
//	map.put('X', 10);
//	map.put('L', 50);
//	map.put('C', 100);
//	map.put('D', 500);
//	map.put('M', 1000);
//	
//	int total = 0;
//	
//	for(int i = 0; i < s.length(); i++) {
//		char c = s.charAt(i);
//		int intVal = map.get(c);
//
//		if(c == 'I') {
//			if(i + 1 < s.length() && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
//				
//				int adjVal = map.get(s.charAt(i+1));
//
//				intVal = adjVal - 1;
//				i++;
//			}
//		} else if(c == 'X') {
//			if(i + 1 < s.length() && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
//				
//				int adjVal = map.get(s.charAt(i+1));
//
//				intVal = adjVal - 10;
//				i++;
//			}
//		} else if(c == 'C') {
//			if(i + 1 < s.length() && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
//				
//				int adjVal = map.get(s.charAt(i+1));
//
//				intVal = adjVal - 100;
//				i++;
//			}
//		}
//		total += intVal;
//	}
//	return total;
//}

