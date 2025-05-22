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

* We traverse the input array from left towards right. While traversing we calculate the prefix sum for every index. Prefix sum is the running sum of every index position on the input array. Either we can maintain a new seperate for prefix sums or we can modify the input array itself if allowed. In this problem we can modify the input array.
* Next we traverse the prefix array from left to right. The idea is, in every index we ask, does this currenPrefixSum (current index position's prefixSum) already contains the sum of one/more subarray summing to k?
* To check this, we go k amount backwards by subtracting the amount 'k' from the currentPrefixSum. This subtracted value is the complementPrefixSum.
* complementPrefixSum is a number that is 'k' less than the currentPrefixSum in the prefixsum array.
* Then we check every index from the beginning until the current index of the prefix sum array to find any complementPrefixSum == (currentPrefixSum-k),
* If we find, than we have got a sub array that resides between the complementPrefixSum and the currentPrefixSum and this subarray is k-sum amount.
* So, currentPrefixSum - complementPrefixSum = k or, we can re-write, currentPrefixSum - k = complementPrefixSum

For example:

Now, we demonstrate a protion of the algorithm execution. Note that, we traverse the precalculated prefix array.

The k-sum subarray count for k = 2, in the given input array,

* indexs : 0, 1, 2, 3, 4, 5, 6 ,7
* inputs : 0, 1,-1, 2, 1, 1,-2, 2
* prefix : 0, 1, 0, 2, 3, 4, 2, 4

<ins>Dry Run for Prefix index 4: we ask, does this currenPrefixSum already contains the sum of one/more subarray summing to k?</ins>

* prefix[4] - k = 3-2 => 1. This '1' is the `complementPrefixSum`.
* if we can find this complementPrefixSum in the prefix array starting from index 0 until index 4, then we can say atleast a subarray exists of sum-k between the complementPrefixSum and the currentPrefixSum. if we find the complementPrefixSum more than once we count all of them as seperate k-sum subarrays.
* we find prefix[1] == 1, which is equal to complementPrefixSum. therefore we found one k-sum subarray between inputs[1] and inputs[4].
* Verification: The subarray starts at index `2` and ends at `4`, thus the index range is [2,4] and the values subarray values are (-1, 2, 1) = -1+2+1 = 2 = k.
* since we found a complementSum in the prefix array so we increase the total number of k-sum subarray count.
* There is no more complementPrefixSum == 1 found until the current index in the prefix array.


<ins>Dry Run for prefix index 5: we ask, does this currenPrefixSum already contains the sum of one/more subarray summing to k?</ins>

* prefix[5] - k = 4-2 => 2. This '2' is the `complementPrefixSum`.
* if we can find this complementPrefixSum in the prefix array starting from index 0 until index 5, then we can say atleast a subarray exists of sum-k between the complementPrefixSum and the currentPrefixSum. if we find the complementPrefixSum more than once we count all of them as seperate k-sum subarrays.
* we find prefix[3] == 2, which is equal to complementPrefixSum. therefore we found one k-sum subarray between inputs[3] and inputs[5].
* Verification: The subarray starts at index `4` and ends at `5`, thus the index range is [4,5] and the subarray values are (1, 1) = 1+1 = 2 = k.
* since we found a complementSum in the prefix array so we increase the total number of k-sum subarray count.
* There is no more complementPrefixSum == 2 found until the current index in the prefix array.


<ins>Dry Run for prefix index 6: we ask, does this currenPrefixSum already contains the sum of one/more subarray summing to k</ins>

* prefix[6] - k = 2-2 => 0. This '0' is the `complementPrefixSum`.
* If we can find this complementPrefixSum in the prefix array starting from index 0 until index 6, then we can say atleast a subarray exists of sum-k between the complementPrefixSum and the currentPrefixSum. If we find the complementPrefixSum more than once we count all of them as seperate k-sum subarrays.
* We find prefix[0] == 0, which is equal to complementPrefixSum. Therefore we found one k-sum subarray between inputs[0] and inputs[6].
* Verification: The subarray starts at index `1` and ends at `6`, thus the index range is [1,6] and the subarray values are (1,-1, 2, 1, 1,-2) = 1+(-1)+2+1+1+(-2) = 2 = k.
* Since we found a complementSum in the prefix array so we increase the total number of k-sum subarray count.
* There is no more complementPrefixSum == 0 found until the current index in the prefix array.

<ins>Dry Run for prefix index 7: we ask, does this currenPrefixSum already contains the sum of one/more subarray summing to k?</ins>

* prefix[7] - k = 4-2 => 2. This '2' is the `complementPrefixSum`.
* If we can find this complementPrefixSum in the prefix array starting from index 0 until index 7, then we can say atleast a subarray exists of sum-k between the complementPrefixSum and the currentPrefixSum. If we find the complementPrefixSum more than once we count all of them as seperate k-sum subarrays.
* We find prefix[3] == 2, which is equal to complementPrefixSum. Therefore we found one k-sum subarray between inputs[3] and inputs[7].
* Verification: The subarray starts at index `4` and ends at `7`, thus the index range is [4,7] and the subarray values are (1, 1,-2, 2) = 1+1+(-2)+2 = 2 = k.
* Since we found a complementSum in the prefix array so we increase the total number of k-sum subarray count.
* Wait, we still have to scan the prefix array until the current index 7. While scanning forward, we found one more (complementPrefixSum == 2) at the index 6.
* We find prefix[6] == 2, which is equal to complementPrefixSum. Therefore we found one more k-sum subarray between inputs[6] and inputs[7].
* Verification: The subarray starts at index `7` and ends at `7`, thus the index range is [7,7] and the subarray values are (2) = k.
* Since we found one more complementPrefixSum in the prefix array so again we increase the total number of k-sum subarray count.



