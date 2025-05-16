### [1. Two Sum](https://leetcode.com/problems/two-sum/description/)

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

    Example 1:
    
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    
    Example 2:
    
    Input: nums = [3,2,4], target = 6
    Output: [1,2]
    
    Example 3:
    
    Input: nums = [3,3], target = 6
    Output: [0,1]
    
    Constraints:

    2 <= nums.length <= 104
    -109 <= nums[i] <= 109
    -109 <= target <= 109
    Only one valid answer exists.

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

### Solution:

<ins>__Brute Force Approach:__</ins>	Check every possible pair of numbers in the array. It tries every possible combination without any optimization. It’s the most straightforward but least efficient solution.

```java

public int[] twoSumBruteForce(int[] nums, int target) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check every pair
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        // No match found (problem says there is one, so this won't be reached)
        return new int[] {};
    }
```

Time Complexity
   * O(n²) — because for each element, you check every other element after it.

Space Complexity
   * O(1) — no extra data structures are used; just simple loops and basic variables.

----

<ins>__HashMap Approach (Optimized O(n) time):__</ins> 
   * Keep adding every element in the hashmap. before adding the number though look for its complement, `(complement = target - nums[i])` already exists in the hashMap. It yes, we found the other number from our traversal already.

```java

public int[] twoSum(int[] nums, int target) {
        if(nums.length <= 0) return new int[] {0,0};
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
        	int complement = target - nums[i];
        	if(map.containsKey(complement)) {
        		res[0] = map.get(complement);
        		res[1] = i;
        		return res;
        	}
        	map.putIfAbsent(nums[i], i);
        }
        return res;
}
```

Time & Space:
   * Time: O(n)
   * Space: O(n)

----
[167. Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

    Example 1:
    
    Input: numbers = [2,7,11,15], target = 9
    Output: [1,2]
    Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
    
    Example 2:
    
    Input: numbers = [2,3,4], target = 6
    Output: [1,3]
    Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
    
    Example 3:
    
    Input: numbers = [-1,0], target = -1
    Output: [1,2]
    Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
    
    Constraints:

    2 <= numbers.length <= 3 * 104
    -1000 <= numbers[i] <= 1000
    numbers is sorted in non-decreasing order.
    -1000 <= target <= 1000
    The tests are generated such that there is exactly one solution.
---
### Solution

This problem is a prgression of 1.Two Sum. Here, the input is sorted. We can take this for our advantage and remove the need to using hashmap like we used in the Two Sum.

```java

public int[] twoSum(int[] nums, int target) {
        if(nums.length <= 0) return new int[] {0,0};
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right) {
        	int sum = nums[left] + nums[right];
        	if(sum < target) {
        		left++;
        	} else if (sum > target) {
        		right--;
        	} else {
        		res[0] = left + 1;
        		res[1] = right + 1;
        		return res;
        	}
        }
        return res;
	}
```





