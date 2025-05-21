# [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/description/)

Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.

    Example 1:
    
    Input: nums = [1,1,1], k = 2
    Output: 2
    Example 2:
    
    Input: nums = [1,2,3], k = 3
    Output: 2
     
    
    Constraints:
    
    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107
----

# Solution

<ins>Approach 1: Brute Force</ins>

// Brute Force: Generate every possible sub array (Time Limit Exceeded)
__Algorithm:__
* Initialize a variable count = 0 to keep track of the number of subarrays with sum equal to k.
* for every index in the input array consider the index as 'start' index of a sub array
* for each 'start' index Loop through the array from 'start' index to n - 1 using index 'end'
  * Add nums[end] to sum
  * if sum == k, increment count
* after both loops complete, return count.

Example all possible subarray of Input: {1, -1, 2, 1, 1, -2, 2}

	i = 0, j = i ... len(nums)
	(1), (1,-1), (1,-1, 2), (1, -1, 2, 1), (1,-1, 2, 1, 1), (1,-1, 2, 1, 1, -2), (1,-1, 2, 1, 1, -2, 2)
	
	i = 1, j = i ... len(nums)
	(-1), (-1, 2), (-1, 2, 1), (-1, 2, 1, 1), (-1, 2, 1, 1, -2), (-1, 2, 1, 1, -2, 2)

	so on..
     
```java

 public int subarraySum(int[] nums, int k) {
	int count = 0;
	for(int i = 0; i < nums.length; i++) {
		for(int j = i; j < nums.length; j++) {
			int sum = 0;
			for(int m = i; m <= j; m++) {
				sum += nums[m];
			}
				if(sum == k) {
					count = count + 1;
				}
		}
	} 
	return count;
}

```

Time and Space
•	Time Complexity: O(n^2)
•	You check all subarrays, and there are roughly n(n+1)/2 subarrays.
•	Space Complexity: O(1)
•	You’re using only a few variables, no extra data structures.

