package backtrack;
import java.util.*;

public class StringPartitioning {

	private void backtrack(String s, 
			int currentIdx, 
			List<String> currentList, 
			List<List<String>> result) {
		
		if(currentIdx == s.length()) {
			result.add(new ArrayList<String>(currentList));
			return;
		}
		for(int end = currentIdx + 1; end <= s.length(); end++) {
			String subStr = s.substring(currentIdx, end);
			currentList.add(subStr);
			backtrack(s, end, currentList, result);
			currentList.remove(currentList.size() - 1);
		}
	}
	
	public List<List<String>> partition(String s){
		List<List<String>> result = new ArrayList<>();
		List<String> currentList = new ArrayList<>();
		int startIdx = 0;
		
		backtrack(s, startIdx, currentList, result);
		return result;
	}
	
	public static void main(String[] args) {
		StringPartitioning ob = new StringPartitioning();
		String s = "abc";
		System.out.println(ob.partition(s));
	}
}

