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

## <ins>Approach 1: Brute Force</ins>

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
    for (int start = 0; start < nums.length; start++) {
        int sum = 0;
        for (int end = start; end < nums.length; end++) {
            sum += nums[end];
            if (sum == k) {
                count++;
            }
        }
    }
    return count;
}
```

All the k-sum subarrays for k = 2, in the given input array,

* Input Array: 0, 1,-1, 2, 1, 1,-2, 2
* Prefix Sum:  0, 1, 0, 2, 3, 4, 2, 4
	         
	1,-1,2
	2
	-1,2,1
	2,1,1,-2
	1,1,-2,2


<ins>Time & Space:</ins>

* Time O(n^2): check all subarrays, and there are roughly n(n+1)/2 subarrays.
* Space O(1): using only a few variables, no extra data structures.

----

## <ins>Approach 2:  Prefix Sum</ins>

### Key Concept and Algorithm:

* We traverse the input array from left towards right. While traversing we calculate the prefix sum for every index.
* The idea is to when calculating the prefix sum, in every index we ask, have we sum enough along our way to make a k-sum subarray!?
* to check this, we go k amount backwards by subtracting the amount 'k' from the currentPrefixSum (current index position's prefixSum). This subtracted value is the complementPrefixSum.
* complementPrefixSum is a number that is 'k' less than the currentPrefixSum in the prefixsum array.
* then we check every index from the beginning until the current index of the prefix sum array to find any complementPrefixSum == (currentPrefixSum-k),
* if we find, than we have got a sub array that resides between the complementPrefixSum and the currentPrefixSum and this subarray is k-sum amount.
* so, currentPrefixSum - complementPrefixSum = k or, we can re-write, currentPrefixSum - k = complementPrefixSum

For example:

All the k-sum subarrays for k = 2, in the given input array,

* index           : 0, 1, 2, 3, 4, 5, 6 ,7
* input nums      : 0, 1,-1, 2, 1, 1,-2, 2
* prefixSum Array : 0, 1, 0, 2, 3, 4, 2, 4

PrefixSum index 4: we ask, did we sum enough on our way already to get subarray of sum `k`?
Answer: 
* prefixSum[4] - k = 3-2 => 1. This '1' is the complementPrefixSum.
* if we can find this complementPrefixSum in the prefixSum array traversed so far, then we can say atleast a subarray exists of sum-k between the complementPrefixSum and the currentPrefixSum. if we find the complementPrefixSum more than once we count all of them as seperate k-sum subarrays.
* we find prefixSum[1] == 1, which is equal to complementPrefixSum. therefore we found one k-sum subarray between nums[1] and nums[4] 

