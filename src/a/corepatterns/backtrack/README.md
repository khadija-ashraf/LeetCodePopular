# Backtrack 101

The top classic backtracking problems are, Permutations, Combinations, SubArrays, String Partitioning, Constraints Solving, Unique paths, Grid Paths, so on. Just imaginze, if we nail the fundamental pattern of building a backtracking solution, that is our key to success in coding many more backtracking problems.

In this article, my target is to introduce the fundamental travarsal of backtracking along with the coding pattern. Later in the tutorial, when we get the knack of writing a `basic backtracking function` we will tweak the `basic backtracking function` to solve different problems under the mentioned topics avobe.  

## What is Backtracking? 

- It exactly is like walking in a maze.

While walking in a maze:

- You walk forward,
- If you hit a wall (invalid path),
- you go back (backtrack),
- Yry a new path (recursive branch),
- Repeat until the exit is found.

> In summary: include (an item) → Recurse(pick the next item) → exclude (the picked item) 


Backtracking Tree for Subsets of [1, 2, 3], keep an eye on the bracket [] marked array in every step.

    start = 0
    []
    ├── include 1 → [1]
    │   ├── include 2 → [1, 2] 
    │   │   ├── include 3 → [1, 2, 3]
    │   │   └── exclude 3 → [1, 2]
    │   └── exclude 2 → [1]
    │       ├── include 3 → [1, 3]
    │       └── exclude 3 → [1]
    └── exclude 1 → []
        ├── include 2 → [2]
        │   ├── include 3 → [2, 3]
        │   └── exclude 3 → [2]
        └── exclude 2 → []
            ├── include 3 → [3]
            └── exclude 3 → []


