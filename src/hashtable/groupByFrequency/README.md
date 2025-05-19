# [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/description/)

Given an array of strings strs, group the anagrams together. we can return the answer in any order.

 

Example 1:

    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    
    Explanation:
    
    There is no string in strs that can be rearranged to form "bat".
    The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
    The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

    Input: strs = [""]
    
    Output: [[""]]

Example 3:
    
    Input: strs = ["a"]
    
    Output: [["a"]]

Constraints:

    1 <= strs.length <= 104
    0 <= strs[i].length <= 100
    strs[i] consists of lowercase English letters.

---

# Solution


## <ins>__Sorting + HashMap Based Solution:__</ins> 

Any two anagrams will have same character frequency and same order when both are sorted. We use this anagram property to our advantage and make the sorted string key of a HashMap. The value associated to the `key` is a list of strings of the original input which all have produced the `key` when sorted.

__Algorithm:__
* sort every string in the input String array,
* populate a 'map' with the sorted string as the `key`, and the original input string is the `value`.
* return the `map.value()` as a nested list of string.

```java

public List<List<String>> groupAnagrams(String[] strs) {
	Map<String, List<String>> map = new HashMap<>();
	for(int i = 0; i < strs.length; i++) {
		String s = strs[i];
		char[] charArr = s.toCharArray();
		
		Arrays.sort(charArr);
		
		String key = new String(charArr);
		
		if(map.containsKey(key)) {
			List<String> temp = new ArrayList<String>();
			temp.addAll(map.get(key));
			temp.add(s);
			map.put(key, temp);
		} else {
			List<String> temp = new ArrayList<String>();
			temp.add(s);
			map.put(key, temp);
		}
	}
	List<List<String>> res = new ArrayList<>();
	for(List<String> groupedStrs: map.values()) {
		res.add(groupedStrs);
	}
	return res;
    }

```

Example: Input = ["eat", "tea", "tan", "ate", "nat", "bat"]
		
  	Step-by-step:
	•	“eat” → “aet” → map = {“aet”: [“eat”]}
	•	“tea” → “aet” → map = {“aet”: [“eat”, “tea”]}
	•	“tan” → “ant” → map = {“aet”: […], “ant”: [“tan”]}
	•	“ate” → “aet” → map = {“aet”: [“eat”, “tea”, “ate”], “ant”: […]}
	•	“nat” → “ant” → map = {…, “ant”: [“tan”, “nat”]}
	•	“bat” → “abt” → map = {…, “abt”: [“bat”]}
	
 	Output: [["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]
  
<ins>Time & Space:</ins>

* Time O(n * k log k): Sorting each string O(k log k), where k is max word length, Total time: O(n * k log k)
* Space O(n * k): O(n * k) for HashMap Keys and Values and Result list

__Space Complexity Described:__
1. HashMap Keys and Values: we’re using a HashMap<String, List<String>>.
   	* Each key is a sorted version of a word (e.g., “eat” → “aet”) — that’s a new string taking up O(k) space.
   	* Each value is a list of words, and across the whole map, we’ll store all n words.
   	  
2. Result List: At the end, we return new ArrayList<>(map.values()):
   	* This collects all the n words grouped in sublists.
   	* Again, storing all words → O(n * k)
   	  
3. Total Space = O(n * k)
   	* n words, each of length k
   	* Possibly storing extra strings (the sorted versions) and all original strings grouped
   	* Final structure holds the same n strings, just grouped
		
So both the map and the final result use O(n * k) in total.

----

# [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/description/)

Given an integer array nums and an integer k, return the k most frequent elements. we may return the answer in any order.

	Example 1:
	
	Input: nums = [1,1,1,2,2,3], k = 2
	Output: [1,2]
	Example 2:
	
	Input: nums = [1], k = 1
	Output: [1]
	 
	
	Constraints:
	
	1 <= nums.length <= 105
	-104 <= nums[i] <= 104
	k is in the range [1, the number of unique elements in the array].
	It is guaranteed that the answer is unique.
	 
Follow up: your algorithm's time complexity must be better than O(n log n), where n is the array's size.

---

# Solution

> <ins>__Pro-Tip (Constraint Clarification)__</ins>
What does these mean, `we may return the answer in any order.` and `constraints : It is guaranteed that the answer is unique.`?

This means:
* There is only one correct set of elements that appear in the top k frequencies.
* However, the order of those elements doesn’t matter.

__Example of unique answer:__

	Input: nums = [1,1,1,2,2,3], k = 2
	Frequencies:
		•	1 → 3 times
		•	2 → 2 times
		•	3 → 1 time
		•	The top 2 most frequent elements are: [1, 2] or [2,1] 
	
	Only one unique set of values satisfies that condition (1 and 2), though we can return [1, 2] or [2, 1] — both are valid.

__So, What Kinds of Ambiguity Could Exist Without This Constraint?__

	__Ties at the K-th Frequency:__
	
	If multiple elements have the same frequency, and that frequency happens to be the K-th most common, we may not know which elements to pick.
	
		nums = [1,1,2,2,3,3,4], k = 2
		requencies:
			•	1 → 2
			•	2 → 2
			•	3 → 2
			•	4 → 1
			•	Top 2 most frequent → any two of [1, 2, 3]
			•	[1,2], [2,3], or [1,3] — all valid if not guaranteed unique
	This is ambiguous — unless the problem tells we which to choose (e.g., by smallest number, lexicographical order, etc.), there is no one correct answer.

So in 347, the guarantee means:
* Only one valid set of elements has the top k highest frequencies.
* There’s no “tie” for the last spot.
* we don’t have to worry about multiple valid combinations.

---

## <ins>__Approach 1: HashMap and Min Heap__</ins>

__Algorithm:__

* count number frequency of the input array using a hashmap
* create a minHeap of type HashMap, so that it can hold the hashMap entries.
* for every `key` in the hashmap insert it into the minHeap.
* whenever the minheap size() > `k` remove the front (lowest element) of the minHeap.
* this way the minHeap will only carry `k` number of items in increasing order. Since we are removing the lowest element from the window every size the heap will be left wiht the top most element starting from the top being the rightmost element in the heap.

  > __Pro-Tip:__ This concept of finding the top-k item using a minheap rather a maxheap feels self contradictory.__ but considering the heap propertiy that a maxheap has the largest item sitting in its front, and the minheap has its smallest time sitting in its front.
  > Every time we poll() we pop an item from the front.
  > If we use maxheap then we have to store all n number of items in the heap since, until end of travarsal of the input list we wont know witch item will be positioned at the kth location in that maxheap.
  > However, when we use a min heap we can keep any `k` larger elemen among all the `n` elements. We keep removing the lowest element from the front whenever the minheap size exceeds size `k`. During the travarsal we will have only top most `k` values among so far traversed inputs.
  > Besides, we know that the lowest value among the top-k items is sitting at the front(by definition of minheap). so we can pull it in constant time.

```java

public int[] topKFrequentHashMapAndMinHeap(int[] nums, int k) {
		
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
        		(a,b) -> a.getValue() - b.getValue());
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
        	map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(Entry<Integer, Integer> anEntry: map.entrySet()) {
        	minHeap.offer(anEntry);
        	while(minHeap.size() > k) {
        		minHeap.poll();
        	}
        }
        int[] res = new int[k];
        int i = 0;
        while(!minHeap.isEmpty()) {
        	res[i++] = minHeap.poll().getKey();
        }
        return res;
}
```
<ins>Time & Space:</ins>

* Time O(n log k):
  * Frequency count (HashMap) : O(n)
  * Heap insertions (n elements) O(n * log k)
  * Extracting result from heap: O(k log k)
  * Total Time: when all elements are unique: O(n + n * log k), -> O(n log k)

* Space O(u + k):
  * HashMap: O(n)
  * Min Heap: O(k)
  * Output array: O(k)
  * Total Space: O(n + k) -> O(n)



---
## <ins>__Approach 2: Frequency Array + Bucket Sort.__ </ins>

__Algorithm:__
* Find the range of the given input array by finding min and max number in that array.
* create a frequency counting array of size (max-min + 1)
* count frequency of the numbers in the input array `freq[nums[i] - min] += 1`
* apply Bucket Sort in the frequency array to group the numbers of input into frequency-groups
* pick the top k freq items by traversing the bucket array backwards by 'k' times.

> __Why this solution optimal?__
> * Avoids the overhead of HashMap and PriorityQueue
> * Efficient for small ranges of integers (works great for bounded integer ranges)

### Step-By-Step Demonstration:

- finding min,max values from the input list, if min,max is known then the range of the input is known to us
```java
	for(int n: nums) {
		if(n > max) {
			max = n;
		} else if(n < min){
			min = n;
		}
	}
```

- use a frequency counting array like we count frequency for lower/upper case characters in a given string now define a frequency counting array of range (max-min + 1)
  ```java
	int[] freq = new int[max-min+1];
	
	// count frequency of the numbers in the input array
	for(int i = 0; i < nums.length; i++) {
		freq[nums[i] - min] += 1;
	}
  ```

- now we apply Bucket Sort in the frequency array to group the numbers of input into frequency-groups. The idea is "EACH_FREQ_Count" is a bucket.
- For example, 
  - bucket[1] = all elements with frequency 1;
  - bucket[2] = all elements with frequency 2;
  - ...
  - bucket[n] = all elements with frequency n;
		
- So, there will be len(nums) number of buckets, bucket is an array of lists. Each item in bucket is a list of Integer numbers.

```java
List<Integer>[] bucket = new List[nums.length + 1]; // 1-indexed, because bucket[0] <- invalid	
	for(int i = 0; i < freq.length; i++) {
		int num = i + min; // reconstructing the original number, similar as (1 + 'a') = b
	
		int freqCount = freq[i];
		
		if(bucket[freqCount] == null) {
			bucket[freqCount] = new ArrayList<>();
		}
		
		bucket[freqCount].add(num); 
	}
```
- Now that we have frequency buckets we can pick the top k freq items by traversing the bucket array backwards by 'k' times.

```java
	int[] res = new int[k];
	int idx = 0;
	for(int i = bucket.length - 1; i >= 0; i--) {
		if(bucket[i] != null) {
			for(int n: bucket[i]) {
				res[idx] = n;
				idx++;
				if(idx >= k) {
					break; 
				}
			}
			if(idx >= k) {
				break; 
			}
		}
	}
	return res;
```
<ins>Time & Space:</ins>
* Time: O(n + r):
    * n = nums.length
    * r = range of the input values = max - min
* Space:
    * O(r): Frequency Array of size r
    * O(n): bucket list of size n in total. n number of buckets each carrying a list of elements from the original input. However, total number of elements aggregating all the bucket lists will not exceed n.

> for full implementation refer to the [TopKFrequentElement.java](https://github.com/khadija-ashraf/LeetCodePopular/blob/main/src/hashtable/groupByFrequency/TopKFrequentElement.java) file in this directory.
---

# [451. Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/description/)
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

	Example 1:
	
	Input: s = "tree"
	Output: "eert"
	Explanation: 'e' appears twice while 'r' and 't' both appear once.
	So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
	Example 2:
	
	Input: s = "cccaaa"
	Output: "aaaccc"
	Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
	Note that "cacaca" is incorrect, as the same characters must be together.
	Example 3:
	
	Input: s = "Aabb"
	Output: "bbAa"
	Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
	Note that 'A' and 'a' are treated as two different characters.
	
	
	Constraints:
	
	1 <= s.length <= 5 * 105
	s consists of uppercase and lowercase English letters and digits.

----

# Solution

This problem is silimar to the TopKFrequencyElement.

## <ins>__Approach 1: HashMap and Max Heap__</ins>

__Algorithm:__

* Step 1: count the frequency by traversing the input array once.
* Step 2: insert map keySet() by decreasing frequency into the maxHeap. Maxheap will have all the unique characters in decreasing order by character frequency.
* Step 3: populate the result array by extracting the elements from the maxHeap 

```java

public String frequencySortHashMapAndMaxHeap(String s) {
	Map<Character, Integer> map = new HashMap<>();
	
	for(int i = 0; i < s.length(); i++) {
		char c = s.charAt(i);
		map.put(c, map.getOrDefault(c, 0) + 1);
	}
	
	PriorityQueue<Character> maxHeap = new PriorityQueue<>(
			(a,b) -> map.get(b) - map.get(a));
	
	for(Character c: map.keySet()) {
		maxHeap.offer(c);
	}
	
	StringBuffer sbuf = new StringBuffer();
	
	while(!maxHeap.isEmpty()) {
		Character c = maxHeap.poll();
		int count = map.get(c);
		
		for(int i = 0; i < count; i++) {
			sbuf.append(c);
		}
	}
	return sbuf.toString();
}
```

<ins>Time & Space:</ins>

* Time O(n log n):
  * Frequency count (HashMap) : O(n)
  * Heap insertions (n elements) O(n log n)
  * Extracting result from heap: O(n log n)
  * Total Time: O(n) + O(n log n) + O(n) -> O(n log n)

* Space O(n):
  * HashMap: O(n)
  * Max Heap: O(n)
  * Output array: O(n)
  * Total Space: O(n)


