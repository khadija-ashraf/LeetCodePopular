### [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/description/)
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    Example 1:
    Input: nums = [1,2,3,1]
    Output: true
    Explanation: The element 1 occurs at the indices 0 and 3.

    Example 2:
    Input: nums = [1,2,3,4]
    Output: false
    Explanation: All elements are distinct.

    Example 3:
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true

    Constraints:
    1 <= nums.length <= 105
    -109 <= nums[i] <= 109


### Solution 


__Brute-Force Approach__: Without much thinking we can try solving this problem using brute force. 

We check every pair of elements and see if any two are equal.

```java
public boolean containsDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) {
                return true;
            }
        }
    }
    return false;
}
```

- Time Complexity: O(n²) — Nested loops go through all possible pairs.

- Space Complexity : O(1) — No extra space used (in-place comparison).

      Example
      
      Input: {7, 1, 4, 6, 1};
      - Compare 7 with 1, 4, 6, 1
      - Compare 1 with 4, 6, 1 → Found duplicate 1 at index 1 and 4 → return true

__When to NOT Use the Brute Force solution?__ 
* Works for small inputs, but too slow for large arrays (like the range given in the leetcode constraint n = 10^5).
* Better approach: Use a HashSet for O(n) time and space..


------------

__HashSet Based Approach__: To find duplicates from a given set of inputs, we can use HashSets. A HashSet stores unique elements. 
   Because we are finding a duplicate and don't need the frequency count like we get from a hashmap, so HashSet is a better datastructure. 
   
   Before adding a new item check if the item is already in the HashSet. If yes return 'true' early, otherwise keep adding elements until we reach to the 
   end of the input list. If we reach end that means we did not find any duplicatee sp return 'false'.

```java
public boolean containsDuplicate(int[] nums) {
    	Set<Integer> set = new HashSet<>();
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(set.contains(nums[i])) {
    			return true;
    		} else {
    			set.add(nums[i]);
    		}
    	}
    	return !(set.size() == nums.length);
    }
```
Time & Space:
   * Time: O(n)
   * Space: O(n)

 
     ---
     
### [219. Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/description/)
  Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
  
    Example 1:
    Input: nums = [1,2,3,1], k = 3
    Output: true
    
    Example 2:
    Input: nums = [1,0,1,1], k = 1
    Output: true
    
    Example 3:
    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false
    
    Constraints:
    
        1 <= nums.length <= 105
        -109 <= nums[i] <= 109

  ### Solution

  Contains Duplicate II is a progression of the problem 217. Contains Duplicate. Rather finding a duplicate from the entire input list we
  find a duplicate in a given window of size _k_. The window slides forward starting from left, towards right by single index at a time. 
  To find a duplicate in a window, we can use a HashSet. A HashSet stores unique elements. Because we are finding a duplicate 
  and don't need the frequency count like we get from a hashmap, so HashSet is a better datastructure. 

  In this case, we will keep our HashSet size = k. That means, the HashSet stores only the elements of the current window. 
  Whenever, the HashSet grows beyond _k_ we trim it from the left to keep it to size() == k. 
  
  But wait, isn't a HashSet un-ordered?! then how can we trim it from the left? The answer is we keep track of the sliding window boundary
  with two indices, the 'left' and 'right'. Keep adding elements to the HashSet from the right using the right index, 
  and keep triming from the left side using the left index, one index at a time.

  This is a sliding window problem. Please refer to my sliding window readme for an in-depth demostrations.
  
  Before adding a new item check if the item is already in the HashSet. If yes return 'true' early, 
  otherwise keep adding elements to the HashSet until we reach to the end of the input list. 
  If we reach end that means we did not find any duplicatee sp return 'false'.

```java
public boolean containsNearbyDuplicate(int[] nums, int k) {
    	int left = 0;
    	Set<Integer> set = new HashSet<>();
    	for(int right = 0; right < nums.length; right++) {
    		if(set.contains(nums[right])) {
    			return true;
    		}
    		set.add(nums[right]);
    		while(set.size() > k) {
    			set.remove(nums[left]);
    			left++;
    		}
    	}
    	return false;
    }
```

Time & Space:
   * Time: O(n)
   * Space: O(k)
---
