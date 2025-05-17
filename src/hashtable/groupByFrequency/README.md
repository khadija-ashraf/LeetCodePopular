### [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/description/)

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

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

__Algorithm:__
* sort every string in the input String array, the sorted strings are the key, and the original input string is the value.
* sort the current word
* store the original input string in a Lis<String> 

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
