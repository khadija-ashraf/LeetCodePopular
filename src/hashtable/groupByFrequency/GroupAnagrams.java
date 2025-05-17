package hashtable.groupByFrequency;

import java.util.*;

public class GroupAnagrams {
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
	
	public static void main(String[] args) {
		GroupAnagrams ob = new GroupAnagrams();
		
//		String[] strs = {"eat","tea","tan","ate","nat","bat"};
//		Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//		String[] strs = {""};
//		Output: [[""]]
		
		String[] strs = {"a"};
//		Output: [["a"]]


						
		System.out.println(ob.groupAnagrams(strs));
		
	}

}
