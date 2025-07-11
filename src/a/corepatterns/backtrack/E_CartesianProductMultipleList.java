package a.corepatterns.backtrack;
import java.util.*;

public class E_CartesianProductMultipleList {

    public static <T> List<List<T>> cartesianProduct(List<List<T>> lists) {
        List<List<T>> result = new ArrayList<>();
        backtrack(lists, result, new ArrayList<>(), 0);
        return result;
    }

    private static <T> void backtrack(List<List<T>> lists, 
    		List<List<T>> result, 
    		List<T> current, 
    		int currentLevel) {
    	
        if (currentLevel == lists.size()) {
            result.add(new ArrayList<>(current));
            return;
        }

        List<T> steppedList = lists.get(currentLevel);

        for(int i = 0 ; i < steppedList.size(); i++) {
        	T everyItem = steppedList.get(i);
        	current.add(everyItem);
        	backtrack(lists, result, current, currentLevel + 1);
        	current.remove(current.size() - 1);
        }
    }

    // Sample usage
    public static void main(String[] args) {
        List<List<Character>> input = new ArrayList<>();
        input.add(Arrays.asList('a', 'b', 'c'));
        input.add(Arrays.asList('d', 'e', 'f'));

        List<List<Character>> product = cartesianProduct(input);

        for (List<Character> combo : product) {
            System.out.println(combo);
        }
    }
}