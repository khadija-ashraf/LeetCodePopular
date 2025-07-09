package a.corepatterns.backtrack;

import java.util.ArrayList;
import java.util.List;


public class F_BacktrackMutipleStringComb {

	public List<List<String>> mutipleStringCombination(List<String[]> strList){
		
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> currentList = new ArrayList<String>();
		int currentIdx = 0;
		
		backtrack(strList, result, currentList, currentIdx);
		return result;
	}
	
	private void backtrack(List<String[]> strList,
						List<List<String>> result,
						List<String> currentList,
						int currentIdx) {
		
		if(currentIdx == strList.get(0).length) {
			result.add(new ArrayList<>(currentList));
			return;
		}
		
		for(int i = 0; i < strList.size(); i++) {
			String[] intermediate = strList.get(i);
			
			currentList.add(intermediate[currentIdx]);
			backtrack(strList, result, currentList, currentIdx + 1);
			currentList.remove(intermediate[currentIdx]);
		}
		
	}
	public static void main(String[] args) {
		F_BacktrackMutipleStringComb ob = new F_BacktrackMutipleStringComb();
		String[] p = {"1","2"};
		String[] q = {"x","y"};
		String[] r = {"@","$"};
		
		List<String[]> strList = new ArrayList<String[]>();
		strList.add(p);
		strList.add(q);
		strList.add(r);
		
		System.out.println(ob.mutipleStringCombination(strList));
	}

}

