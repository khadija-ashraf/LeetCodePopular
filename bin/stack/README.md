

# Monotonic Stack
* Use case: Next Greater / Smaller Element
* Stack content: Indices (or values) in increasing/decreasing order
* Pattern: While current breaks monotonicity, pop
#### LeetCode
1. [Next Greater Element I - 496](https://leetcode.com/problems/next-greater-element-i/description/)
2. Next Greater Element II - 503
3. Daily Temperatures - 739
4. Largest Rectangle in Histogram - 84
5. Trapping Rain Water - 42


# Reverse Polish Notation / Expression Evaluation
* Use case: Evaluate expressions like ["2", "1", "+", "3", "*"]
* Stack content: Numbers or intermediate results
  
#### Leetcode
* Evaluate Reverse Polish Notation - 150
* Basic Calculator II - 227


# Design Stack (Custom Stack Behavior)
Use case: Extend push, pop, or add getMin() / getMax() / track frequency
Pattern: Use two stacks or extra data structures

Min Stack - 155
Max Stack - 716
Frequency Stack - 895

# Tree Traversals (DFS using Stack)
Use case: Inorder, Preorder, Postorder without recursion
Pattern: Simulate recursion with explicit stack

Binary Tree Inorder Traversal - 94
Flatten Binary Tree - 114
Binary Tree Zigzag Level Order - 103

# Parentheses & Validity Check
Use case: Check balanced parentheses or generate them
Stack content: Opening brackets or indices

Valid Parentheses - 20
Longest Valid Parentheses - 32
Remove Invalid Parentheses - 301


# Backtracking / Undo with Stack
Use case: Simulate path undo, backtracking states
Pattern: Push state, revert using pop

Binary Tree Paths (DFS Stack) 257
Lowest Common Ancestor (Iterative DFS) 236
Word Ladder II (DFS variant) 126

