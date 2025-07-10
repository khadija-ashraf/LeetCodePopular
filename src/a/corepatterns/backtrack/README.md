# Backtrack 101

The top classic backtracking problems are, Subsets, Combinations, Permutations, SubArrays, String Partitioning, Constraints Solving, Unique paths, Grid Paths, so on. When we nail down the fundamental pattern of building a backtracking solution, that is our key to success in coding many more backtracking problems.

In this article, my target is to introduce the different nature of travarsals in backtracking along with the coding patterns. Gradually, when we get the knack of writing a basic `backtrack` function we will tweak that basic function to solve different problems. There is a progression of learning in this this tutorial, a later topic is built upon the concept of an earlier topic. 

The topic progression is somewhat, 
> subsets → combination → permutation →sub array →string partitioning →cartesian product → multiple string combination → and more. 

My recommendation to you for reading this turorial is, read sequentially... 😃

## What is Backtracking? 

- It exactly is like walking in a maze.

While walking in a maze:

- You walk forward,
- If you hit a wall go back (backtrack),
- Try a new path (recursive branch),
- Repeat until the exit is found.

In summary:
> step on(current_item) → Recurse(step on the rest of the items one after the other) → step back(current_item) 

Below, is the backtracking tree for walking through the item-maze: [1, 2, 3]. Keep an eye on the star marked  items in every step after a  `step-on`. 


    start = 0
    [] ⭐
    ├── step-on 1 → [1] ⭐
    │   ├── step-on 2 → [1, 2] ⭐
    │   │   ├── step-on 3 → [1, 2, 3] ⭐
    │   │   └── step-back 3 → [1, 2]
    │   └── step-back 2 → [1]
    │       ├── step-on 3 → [1, 3] ⭐
    │       └── step-back 3 → [1]
    └── step-back 1 → []
        ├── step-on 2 → [2] ⭐
        │   ├── step-on 3 → [2, 3] ⭐
        │   └── step-back 3 → [2]
        └── step-back 2 → []
            ├── step-on 3 → [3] ⭐
            └── step-back 3 → []

 :small_orange_diamond: Example: Exploring all the paths starting from the item 1:  :small_orange_diamond:

- we walk on the current item [1] (step-on item 1),
- then keep moving forward until hitting the wall (step-on rest of the items [2, 3] one after the other until hitting the end of array),
- step back from the current item [1] → []


The square braket arrays generated during walking through the item-maze [1, 2, 3] are:

`[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]`
Okay, wait, aren't these arrays same as the powerset of the items [1, 2, 3]? Exactly, We just generated all possible subsets of the items [1, 2, 3].

The java code snippet of walking through the item-maze is:
```java

private void backtrack(int[] items, int currentIdx, 
		List<Integer> currentList) {

	System.out.println(currentList);
	for(int i = currentIdx; i < items.length; i++) {
		currentList.add(items[i]); // step-on the current item
		backtrack(items, i + 1, currentList, result); //keep stepping-on the rest of the items onebyone
		currentList.remove(currentList.size() - 1); // step-back from the current item
	}
}
	
```

The backtrack(items, currentIdx, currentList) is generating subsets of elements starting from every index of the `items` array.

- Starting from index 0: [1], [1,2], [1,2,3], [1,3]→ (end of array- hitting the wall)
- Starting from index 1: [2], [2,3] → (end of array- hitting the wall)
- Starting from index 2: [3] → (end of array- hitting the wall)
- end of array

> Starting from every position in the items array the backtrack function is called until the
`currentIdx` hits the wall, that means it reaches to the end of the array.

### Why we have the `currentList`?
- `currentList`  represents a forward path that we walked through until some point.
- It starts with an empty subset, that means we didn't start walking at that point.
- The `currentList` is the list where we keep adding items in every `step-on` phase contrarily, keep removing in every `step-back` phase. When we walk to an item we add, when we walk back then we remove.
- It keeps growing in every recursion step. Keeps shrinking upon returning from a recursion call.
- In the Backtrack101 we are printing the `currentList` in every recursion step. The printed items are the subsets. Each subset grows during the `step-on` phase and shrinks in the `step-back` phase when we walk backwards.

:star: Below is the complete implementation of the all possible subset generations. Bookmark this class `Backtrack101`.  This is the ultimate base pattern of a backtrack function. :star:

```java
public class Backtrack101 {
	private void backtrack(int[] items, int currentIdx, 
			List<Integer> currentList) {
		System.out.println(currentList);
		for(int i = currentIdx; i < items.length; i++) {
			currentList.add(items[i]);
			backtrack(items, i + 1, currentList);
			currentList.remove(currentList.size() - 1); 
		}
	}
	public void subsets(int[] n){
		List<Integer> currentList = new ArrayList<Integer>();
		int currentIdx = 0;
		backtrack(n, currentIdx, currentList); 
	}
	public static void main(String[] args) {
		Backtrack101 ob = new Backtrack101();
		int[] nums = {1,2,3};
		ob.subsets(nums);
	}
}
```
# All Possbile Subsets
Backtrack101 is almost the [Leetcode 78. Subsets](https://leetcode.com/problems/subsets/description/) with only change in the return type. Leetcode asks to return the list of subsets that we generated along the way. For collecting all the subsets we can keep a list of lists. Below is the comparison of Backtrack101 (on the left) implementation with Leetcode 78 (on the right).

<img width="1418" alt="backtrack101" src="https://github.com/user-attachments/assets/168b56b9-d82b-4591-88fc-bb32fe21237d" />

# Combinations
Next comes generating combination from an array of elements. 

> Combination is a special kind of all possible subset that has a size restriction. Any subset in a combination list must be of size-k.
For example: items = {1,2,3};  k = 2;  list of combinations: [[1, 2], [1, 3], [2, 3]]

Since we have a subset-size restrictions, therefore, while building a subset we can check if the `currentList` size meets the size restriction, if yes we add the `currentList` in the result list otherwise move on.  This is similar to walking in the maze, the restriction means keep walking forward until you reach k-steps or hit a wall.

> The class Leetcode78 for All Possbile Subsets is our base pattern for writing our combination backtracking function.

Below is the comparison view of the All Possbile Subsets generation (on the left) and the Combinations generation implementation(on the right). As the first base case shows `(k > item.length)`, we return if the k is grater than the size of the items, which means there are not enough items available for building a k-size subset. In the second base case, as the size of the currentList of items matches to k `k == currentList.size()` we add this currentList to the results.

<img width="1456" alt="combinations" src="https://github.com/user-attachments/assets/4cf1f6ff-db65-4dbb-a62c-22b5e4483a4b" />


# Permutations
The fundamental difference between all possible subset generation and the permutation is, every element is added and again removed in subset generation, whereas every position is used and then released to ensure unique arrangements in the permutation generation process. Additionally, in permutations every sublist size must be equal to the size of the input array, contrariry in all possible subsets, a sublist can be of any size between [0...n]

> Permutation is basically all possible rearrangments of all the elements in the input array. For example, for a given array [1,2]; the [1,2] and [2,1] are two different arrangements of the same set of elements, so they are considered as two valid permutations.

Below tree shows all possible arrangements of items [1,2,3]. Only the green tick marked sublists are the valid permutations.
	Start: []
	
	├── Use 1 ➝ [1]
	│   ├── Use 2 ➝ [1, 2]
	│   │   ├── Use 3 ➝ [1, 2, 3] ✅
	│   │   └── Release 3
	│   └── Release 2
	│   ├── Use 3 ➝ [1, 3]
	│   │   ├── Use 2 ➝ [1, 3, 2] ✅
	│   │   └── Release 2
	│   └── Release 3
	└── Release 1
	
	├── Use 2 ➝ [2]
	│   ├── Use 1 ➝ [2, 1]
	│   │   ├── Use 3 ➝ [2, 1, 3] ✅
	│   │   └── Release 3
	│   └── Release 1
	│   ├── Use 3 ➝ [2, 3]
	│   │   ├── Use 1 ➝ [2, 3, 1] ✅
	│   │   └── Release 1
	│   └── Release 3
	└── Release 2
	
	├── Use 3 ➝ [3]
	│   ├── Use 1 ➝ [3, 1]
	│   │   ├── Use 2 ➝ [3, 1, 2] ✅
	│   │   └── Release 2
	│   └── Release 1
	│   ├── Use 2 ➝ [3, 2]
	│   │   ├── Use 1 ➝ [3, 2, 1] ✅
	│   │   └── Release 1
	│   └── Release 2
	└── Release 3

[Leetcode 46. Permutations](https://leetcode.com/problems/permutations/description/) asks to generate all possible permuations. Below is the java solution for this problem. We use our classical all possible subset generation template from Leetcode 78, with an extra boolean array indicating which items have been used for generating the `currentList`. `currentList` represents a forward path that we walked until some point. `currentList` keeps growing every recursion step, and when it becomes the size of the input array it is then added in the result list.

```java
package backtrack;
import java.util.*;

public class Leetcode46 {
	private void backtrack(int[] items, 
			boolean[] used,
			List<Integer> currentList, 
			List<List<Integer>> result) {
		if(currentList.size() == items.length) {
			result.add(new ArrayList<Integer>(currentList));
			return;
		}
		for(int i = 0; i < items.length; i++) {
			if(used[i]) continue; // avoid using already used positions in the current walking path
			
			currentList.add(items[i]); // including position i in the current path
			used[i] = true; // restricting i in the upcoming forward steps

			backtrack(items, used, currentList, result); // recurse on the whole input array
			
			currentList.remove(currentList.size() - 1); // removing index i from the current path
			used[i] = false; // releasing position i to be available in the upcoming forward steps. 
		}
	}
	public List<List<Integer>> permute(int[] n){
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> currentList = new ArrayList<>();
		boolean[] used = new boolean[n.length];
		
		backtrack(n, used, currentList, result); 
	    return result;
	}
	public static void main(String[] args) {
		Leetcode46 ob = new Leetcode46();
		int[] n = {1,2,3};
		System.out.println(ob.permute(n));
	}
}

```
Below is the comparison between all possible subset (on the left) and the permutation generation (on the right).


<img width="1456" alt="permutation" src="https://github.com/user-attachments/assets/31841aeb-b9c4-4546-b58e-a61dc46d9dad" />

