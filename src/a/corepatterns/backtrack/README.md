# Backtrack 101

The top classic backtracking problems are, Permutations, Combinations, SubArrays, String Partitioning, Constraints Solving, Unique paths, Grid Paths, so on. When we nail down the fundamental pattern of building a backtracking solution, that is our key to success in coding many more backtracking problems.

In this article, my target is to introduce the fundamental travarsal of backtracking along with the coding pattern. Later in the tutorial, when we get the knack of writing a basic `backtrack` function we will tweak that basic `backtrack` function to solve different problems under the mentioned topics avobe.  

## What is Backtracking? 

- It exactly is like walking in a maze.

While walking in a maze:

- You walk forward,
- If you hit a wall (invalid path),
- You go back (backtrack),
- Try a new path (recursive branch),
- Repeat until the exit is found.

In summary:
> include(current_item) → Recurse(include rest of the items one after the other) → exclude(current_item) 

Below, is the backtracking tree for walking through the item-maze: [1, 2, 3]. Keep an eye on the start marked  items in every step after an `include`. 


    start = 0
    [] ⭐
    ├── include 1 → [1] ⭐
    │   ├── include 2 → [1, 2] ⭐
    │   │   ├── include 3 → [1, 2, 3] ⭐
    │   │   └── exclude 3 → [1, 2]
    │   └── exclude 2 → [1]
    │       ├── include 3 → [1, 3] ⭐
    │       └── exclude 3 → [1]
    └── exclude 1 → []
        ├── include 2 → [2] ⭐
        │   ├── include 3 → [2, 3] ⭐
        │   └── exclude 3 → [2]
        └── exclude 2 → []
            ├── include 3 → [3] ⭐
            └── exclude 3 → []


While walking through this item-maze [1, 2, 3]:

 :small_orange_diamond: Exploring all the paths starting from the item 1:  :small_orange_diamond:

- we walk on the current item [1] (include item 1),
- then keep moving forward until hitting the wall (include rest of the items [2, 3] one after the other until hitting the end of array),
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
		currentList.add(items[i]); // include the current item
		backtrack(items, i + 1, currentList, result); // keep including the rest of the items one by one
		currentList.remove(currentList.size() - 1); // exclude the current item
	}
}
	
```

The backtrack(items, currentIdx, currentList) is generating subsets of elements starting from every index of the `items` array.

- Starting from index 0, [1], [1,2], [1,2,3], [1,3]→ (end of array- hitting the wall)
- Starting from index 1, [2], [2,3] → (end of array- hitting the wall)
- Starting from index 2, [3] → (end of array- hitting the wall)
- end of array

> Starting from every position in the items array the backtrack function is called until the
`currentIdx` hits the wall, that means it reaches to the end of the array.

The `currentList` is the list where we keep adding items in every `include` phase contrarily, keep removing in every `exclude` phase. `currentList` starts with an empty array containing no elements, that is the empty subset.

Below is the complete implementation of the all possible subset generations. This is almost the [Leetcode 78. Subsets](https://leetcode.com/problems/subsets/description/) with only change in the return type. Leetcode asks to return the list of subsets.
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

For collecting all the generated subsets we can keep a list of lists. Below is the comparison of Backtrack101 implementation with Leetcode 78.

<img width="1418" alt="backtrack101" src="https://github.com/user-attachments/assets/168b56b9-d82b-4591-88fc-bb32fe21237d" />
