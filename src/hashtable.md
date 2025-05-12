⸻

🧩 Common Hash Table Patterns

⸻

1. ✅ Frequency Counting

Use a HashMap or HashSet to count the occurrences of elements.
    •	🔹 Examples:
    •	242. Valid Anagram
    •	387. First Unique Character in a String
    •	451. Sort Characters by Frequency
    •	383. Ransom Note

⸻

2. 🚫 Detect Duplicates

Use a HashSet to check for duplicates quickly.
	•	🔹 Examples:
	•	217. Contains Duplicate
	•	219. Contains Duplicate II
	•	220. Contains Duplicate III

⸻

3. 🧠 Two Sum / Complement Lookup

Use a HashMap to store previously seen numbers and check if their complement exists.
	•	🔹 Examples:
	•	1. Two Sum
	•	167. Two Sum II - Input Array Is Sorted (uses two-pointer)
	•	653. Two Sum IV - Input is a BST

⸻

4. 🔄 Group by Frequency / Pattern

Use a Map<String, List<String>> to group elements by some computed key (e.g., anagram signature).
	•	🔹 Examples:
	•	49. Group Anagrams
	•	347. Top K Frequent Elements
	•	451. Sort Characters by Frequency

⸻

5. 🪞 Sliding Window + HashMap

Use a window to track counts of elements or characters dynamically.
	•	🔹 Examples:
	•	3. Longest Substring Without Repeating Characters
	•	76. Minimum Window Substring
	•	567. Permutation in String

⸻

6. ➕ Prefix Sum with HashMap

Track the sum of elements and use a map to check if a required sum has occurred before.
	•	🔹 Examples:
	•	560. Subarray Sum Equals K
	•	974. Subarray Sums Divisible by K
	•	1248. Count Number of Nice Subarrays

⸻

7. 🌐 Custom Hashing / Coordinate Hashing

Map coordinates, strings, or custom objects to values.
	•	🔹 Examples:
	•	149. Max Points on a Line
	•	981. Time Based Key-Value Store
	•	36. Valid Sudoku

⸻

8. 🌲 Simulate Data Structures

Use hash tables to simulate LRU caches or complex key-value structures.
	•	🔹 Examples:
	•	146. LRU Cache
	•	380. Insert Delete GetRandom O(1)
	•	355. Design Twitter

⸻

9. 🔍 Word Pattern Matching

Track character/word mappings using two hash maps or one with value set checks.
	•	🔹 Examples:
	•	290. Word Pattern
	•	205. Isomorphic Strings
	•	890. Find and Replace Pattern

⸻

🧠 Pro Tip:

When solving a problem, ask yourself:
	•	Can I track frequencies?
	•	Can I use a set to detect duplicates?
	•	Can I map a key to a value (like index, frequency, etc.)?
	•	Can I reduce time complexity using hashmap lookups?

⸻


### Beginner-Friendly Hash Table Problems
    1.	Two Sum
    Find two numbers that add up to a target sum.
    2.	Contains Duplicate
    Check if any value appears at least twice in the array.
    3.	Valid Anagram
    Determine if two strings are anagrams of each other.
    4.	Intersection of Two Arrays
    Find the intersection of two arrays.
    5.	First Unique Character in a String
    Find the first non-repeating character in a string.
    6.	Happy Number
    Determine if a number is a “happy number.”
    7.	Isomorphic Strings
    Check if two strings are isomorphic.
    8.	Word Pattern
    Determine if a string follows a given pattern.

---

### Intermediate Hash Table Problems
    9.	Group Anagrams
    Group strings that are anagrams of each other.
    10.	Top K Frequent Elements
    Find the k most frequent elements in an array.
    11.	Longest Substring Without Repeating Characters
    Find the length of the longest substring without repeating characters.
    12.	Find All Anagrams in a String
    Find all start indices of anagrams of a pattern in a string.
    13.	Subarray Sum Equals K
    Find the total number of continuous subarrays whose sum equals k.
    14.	Longest Palindrome
    Find the length of the longest palindrome that can be built with the letters of a string.
    15.	Find Duplicate Subtrees
    Find all duplicate subtrees in a binary tree.

  ---

### Advanced Hash Table Problems
    16.	Minimum Window Substring
    Find the minimum window in a string which will contain all the characters of another string.
    17.	All Oone Data Structure
    Design a data structure that supports insert, delete, and getMaxKey/getMinKey operations in O(1) time.
    18.	Palindrome Pairs
    Find all pairs of distinct indices in the given list of words such that the concatenation of the two words is a palindrome.
    19.	Substring with Concatenation of All Words
    Find all starting indices of substring(s) in a string that is a concatenation of each word in a list exactly once.
    20.	Max Points on a Line
    Find the maximum number of points that lie on the same straight line.
