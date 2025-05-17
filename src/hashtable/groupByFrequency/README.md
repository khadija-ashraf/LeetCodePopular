### [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/description/)

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

### Solution

<ins>__Sorting + HashMap Based Solution>:__</ins> 

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
Time & Space:
* Time O(n * k log k): Sorting each string O(k log k), where k is max word length, Total time: O(n * k log k)
* Space O(n * k): O(n * k) for HashMap Keys and Values and Result list

		1. HashMap Keys and Values
		
		we’re using a HashMap<String, List<String>>.
		•	Each key is a sorted version of a word (e.g., “eat” → “aet”) — that’s a new string taking up O(k) space.
		•	Each value is a list of words, and across the whole map, we’ll store all n words.
		2. Result List
		
		At the end, we return new ArrayList<>(map.values()):
		•	This collects all the n words grouped in sublists.
		•	Again, storing all words → O(n * k)

		Total Space = O(n * k)
		•	n words, each of length k
		•	Possibly storing extra strings (the sorted versions) and all original strings grouped
		•	Final structure holds the same n strings, just grouped
		
		So both the map and the final result use O(n * k) in total.

----




