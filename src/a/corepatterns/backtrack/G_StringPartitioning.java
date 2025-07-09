package a.corepatterns.backtrack;

import java.util.*;

// TODO: total no of partition possible = 2^(n -1),
// TODO: for n = 4, total number of partition, 2^(4-1)

public class G_StringPartitioning {

	public List<List<String>> partition(String s){
		List<List<String>> result = new ArrayList<>();
		List<String> currentList = new ArrayList<>();
		int startIdx = 0;
		
		backtrack(s, result, currentList, startIdx);
		return result;
	}
	
	private void backtrack(String s,
				List<List<String>> result,
				List<String> currentList,
				int startIdx) {
		
		if(startIdx == s.length()) {
			result.add(new ArrayList<String>(currentList));
			return;
		}
		
		for(int end = startIdx + 1; end <= s.length(); end++) {
			String subStr = s.substring(startIdx, end);
			currentList.add(subStr);
			backtrack(s, result, currentList, end);
			currentList.remove(currentList.size() - 1);
		}
	}
	
	
	public static void main(String[] args) {
		G_StringPartitioning ob = new G_StringPartitioning();
		
		String s = "abcd";
		
		System.out.println(ob.partition(s));

	}

}
