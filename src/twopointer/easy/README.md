## [414. Third Maximum Number](https://leetcode.com/problems/third-maximum-number/description/)

  Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

  Example 1:
  
    Input: nums = [3,2,1]
    Output: 1
    Explanation:
    The first distinct maximum is 3.
    The second distinct maximum is 2.
    The third distinct maximum is 1.

  Example 2:
  
    Input: nums = [1,2]
    Output: 2
    Explanation:
    The first distinct maximum is 2.
    The second distinct maximum is 1.
    The third distinct maximum does not exist, so the maximum (2) is returned instead.
  
  Example 3:
  
    Input: nums = [2,2,3,1]
    Output: 1
    Explanation:
    The first distinct maximum is 3.
    The second distinct maximum is 2 (both 2's are counted together since they have the same value).
    The third distinct maximum is 1.
Constraints:

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1


## Solution

* The first thought comes in my mind, 'Can I do Third Maximum Number with a max heap?'

  Yes, we can absolutely solve this problem using a max heap though a min heap of size 3 is often more optimal). Here’s how both approaches work:

### Max Heap Approach (Not Optimal for this problem)

Using a max heap gives easy access to the largest numbers, but extracting distinct max values requires extra handling.

  Max Heap Strategy:
  1. Add all unique numbers to a max heap (negate values to simulate max heap using Java’s PriorityQueue which is a min heap by default).
  2. Pop from the heap up to 3 times, keeping track of distinct values.
  3. If fewer than 3 distinct values, return the maximum.

  Java Code with Max Heap:

```java
import java.util.*;

public class Solution {
    public int thirdMax(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            if (seen.add(num)) {
                maxHeap.offer(num);
            }
        }

        if (maxHeap.size() < 3) {
            return maxHeap.peek(); // return max if less than 3 distinct
        }

        // Remove top 2 maximums
        maxHeap.poll(); // 1st max
        maxHeap.poll(); // 2nd max
        return maxHeap.poll(); // 3rd max
    }
}
```
Example: Input: [1, 2, 2, 5, 3, 5]

    Initial values:
    seen = {}
    maxHeap = []
    
    Process each number:
    1: not in set
      seen = {1}
      heap = [1]
    2: not in set
      seen = {1, 2}
      heap = [2, 1]
    2: already seen → skip
    5: not in set
      seen = {1, 2, 5}
      heap = [5, 1, 2]
    3: not in set
      seen = {1, 2, 3, 5}
      heap = [5, 3, 2, 1]
    5: already seen → skip

 Extract Third Maximum:

    Now we pop from the heap 3 times to get the third distinct max:
    	1.	heap.poll() → 5
    heap = [3, 1, 2]
    	2.	heap.poll() → 3
    heap = [2, 1]
    	3.	heap.poll() → 2 ← This is the third maximum.

Output: 2

### Better Approach: Min Heap of Size 3

Why? Because we only need to track the top 3 distinct maximums.

  Min Heap Strategy:
  1. Use a min heap of size 3 to store the top 3 unique elements.
  2. If the heap exceeds size 3, remove the smallest.
  3. In the end, if the heap has 3 elements, return the min; otherwise return the max.

```java
public int thirdMax(int[] nums) {
    	if(nums.length <= 0) return -1;
    	PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    	Set<Integer> set = new HashSet<>();
        for(int n: nums) {
            if(set.contains(n)) continue;
            set.add(n);
            minHeap.offer(n);
            if(minHeap.size() > 3) { // remove the smallest of the 4
              minHeap.poll();
            }
    	}
    	if(minHeap.size() < 3) {
    		while(minHeap.size() > 1) {
    			minHeap.poll();
    		}
    	}
    	return minHeap.peek();
}
```

Dry Run:

    Initial:
    	•	seen = {}
    	•	minHeap = []
    
    Step-by-step:
      1:
          Add to seen = {1}
          Heap = [1]
      2:
          Add to seen = {1, 2}
          Heap = [1, 2]
      2:
          Already seen → skip
      5:
          Add to seen = {1, 2, 5}
          Heap = [1, 2, 5]
      3:
          Add to seen = {1, 2, 3, 5}
          Heap = [1, 2, 5, 3] → size is 4, so poll() smallest → remove 1
          Heap = [2, 3, 5]
      5:  Already seen → skip


Final Heap:
* Heap has 3 elements: [2, 3, 5]
* So, return minHeap.peek() = 2 ← Third maximum

Output: 2
 
Approach	| Time Complexity	|Space Complexity
---|---|---|
Max Heap	|O(n log n)	|O(n)
Min Heap (opt.)	|O(n log 3) = O(n)	| O(1) or O(3)




