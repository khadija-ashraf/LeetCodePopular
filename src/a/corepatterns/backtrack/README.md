# Backtrack 101

The top classic backtracking problems are, Permutations, Combinations, SubArrays, String Partitioning, Constraints Solving, Unique paths, Grid Paths, so on. When we nail down the fundamental pattern of building a backtracking solution, that is our key to success in coding many more backtracking problems.

In this article, my target is to introduce the fundamental travarsal of backtracking along with the coding pattern. Later in the tutorial, when we get the knack of writing a `basic backtracking function` we will tweak the `basic backtracking function` to solve different problems under the mentioned topics avobe.  

## What is Backtracking? 

- It exactly is like walking in a maze.

While walking in a maze:

- You walk forward,
- If you hit a wall (invalid path),
- You go back (backtrack),
- Try a new path (recursive branch),
- Repeat until the exit is found.

> In summary: include(current_item) → Recurse(include next_item) → exclude(current_item) 

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


The square braket arrays generated during walking through the item-maze [1, 2, 3] are:

`[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]`
Okay, wait, aren't these arrays same as the powerset of the items [1, 2, 3]? Exactly, We just generated all possible subsets of the items [1, 2, 3].

The java code snippet of walking through the item-maze is:

```java
public class Backtrack101 {
	public void subsets(int[] nums) {
		List<Integer> subset = new ArrayList<Integer>();
		backtrack(nums, 0, subset);
	}
	private void backtrack(int[] nums, int currentIdx, List<Integer> subset) {
		System.out.println(subset);
		for(int i = currentIdx; i < nums.length; i++) {
			subset.add(nums[currentIdx]);
			backtrack(nums, i + 1, subset);
			subset.remove(subset.size() - 1);
		}
	}
	public static void main(String[] args) {
		Backtrack101 ob = new Backtrack101();
		int[] nums = {1,2,3};
		ob.subsets(nums);
	}
}
```

