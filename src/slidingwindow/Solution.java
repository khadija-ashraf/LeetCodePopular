package slidingwindow;

import java.util.*;


//Initialize left = 0
//2.	Loop right from 0 to n-1
//3.	Inside the loop:
//•	Expand window: right++ (implement logic)

//•	Check condition:
//•	If valid: maybe update answer
//•	If not valid: move left to shrink window
//4.	Repeat until right reaches the end

public class Solution {
	
	// maxheap			minheap
	// [1,2]			[3,4]
	
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private Map<Integer, Integer> delayed = new HashMap<>();
    private int k;

    public double[] medianSlidingWindow(int[] nums, int k) {
        this.k = k;
        double[] result = new double[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Insert new number
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            balanceHeaps();
            System.out.println("Added: " + num);
            printState(i, nums);

            // Remove out-of-window number
            if (i >= k) {
                int outNum = nums[i - k];
                delayed.put(outNum, delayed.getOrDefault(outNum, 0) + 1);

                // Prune from the right heap
                if (outNum <= maxHeap.peek()) {
                    prune(maxHeap);
                } else {
                    prune(minHeap);
                }

                balanceHeaps();
                System.out.println("Removed (lazy): " + outNum);
                printState(i, nums);
            }

            // Record median
            if (i >= k - 1) {
                result[i - k + 1] = getMedian();
                System.out.println("→ Median: " + result[i - k + 1]);
                System.out.println("──────────────────────────");
            }
        }

        return result;
    }

    private void balanceHeaps() {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
            prune(maxHeap);
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
            prune(minHeap);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
                heap.poll();
            } else {
                break;
            }
        }
    }

    private double getMedian() {
        if (k % 2 == 1) {
            return maxHeap.peek();
        } else {
            return ((long) maxHeap.peek() + (long) minHeap.peek()) / 2.0;
        }
    }

    private void printState(int i, int[] nums) {
        System.out.println("Window: " + Arrays.toString(Arrays.copyOfRange(nums, Math.max(0, i - k + 1), i + 1)));
        System.out.println("MaxHeap: " + maxHeap);
        System.out.println("MinHeap: " + minHeap);
        System.out.println("Delayed: " + delayed);
        System.out.println("Heaps Size: max=" + maxHeap.size() + ", min=" + minHeap.size());
    }

    public static void main(String[] args) {
        Solution solver = new Solution();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        double[] result = solver.medianSlidingWindow(nums, k);
        System.out.println("Final Result: " + Arrays.toString(result));
    }
}

//public String minWindow(String s1, String s2) {
//	int minLen = Integer.MAX_VALUE;
//	String minWin = "";
//	
//	// scan s1 entirely to find the first position
//	for(int i = 0; i < s1.length(); i++) {
//		int s2CurrentIdx = 0;
//
//		// we matched the first char of s2 with a char in s1,
//		// from this point we start matching the subsequence in s1
//		if(s1.charAt(i) == s2.charAt(s2CurrentIdx)) {
//			for(int right = 0; right < s1.length(); right++) {
//				if(s2.charAt(s2CurrentIdx) == s1.charAt(right)) {
//					s2CurrentIdx++;
//
//					if(s2CurrentIdx == s2.length()) {
//						//all the characters of s2 matched so we update the subsequence length
//						// now we go backwards and find the nearest valid starting index of the 
//						// subsequence
//						s2CurrentIdx--;
//						
//						int s1BackwardsIdx = right;
//						int subSeqStartIdx = 0;
//						
//						while(s2CurrentIdx >= 0 && s1BackwardsIdx >= 0) {
//							if(s2CurrentIdx == 0 && s2.charAt(s2CurrentIdx) == s1.charAt(s1BackwardsIdx)) {
//								subSeqStartIdx = s1BackwardsIdx;
//							}
//
//							if(s2.charAt(s2CurrentIdx) == s1.charAt(s1BackwardsIdx)) {
//								s2CurrentIdx--;
//							}
//							s1BackwardsIdx--;
//						}
//						
//						if(right - subSeqStartIdx < minLen) {
//							minLen = right - subSeqStartIdx;
//							minWin = s1.substring(subSeqStartIdx, right + 1);
//						}
//						s2CurrentIdx = 0;
//					} 
//				}
//			}
//		}
//	}
//	return minWin;
//}


//=========================
//public int[] maxSlidingWindow(int[] nums, int k) {
//	// stores indices of a window of nums variable
//	// we implement this deque decreasing order, so all bigger values
//	// will be at the front and smaller values will be at the later positions.
//	// the deque.peekFirst() will always return the max.
//	Deque<Integer> deque = new ArrayDeque<>();
//	
//	int[] res = new int[nums.length - k + 1];
//	
//	for(int right = 0; right < nums.length; right++) {
//		// remove indices outside the window range
//		while(!deque.isEmpty() && deque.peekFirst() <= right - k) {
//			deque.pollFirst();
//		}
//		
//		// remove min values from the end, cause they will never be a max.
//		// before adding an element from the rear end to to deque we ensure
//		// any smaller element siting in the queue got removed. keep removing
//		// elements from the rear until we find a bigger element than our 
//		// current one, or the deque is empty. Only then we add our current element 
//		
//		while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
//			deque.pollLast();
//		}
//		
//		// now we add our current element
//		deque.add(right);
//		
//		// now we add the front element to the deque because this represents the 
//		// max of the current window, before that check if a valid window formed of
//		// size 'k' yet. Cause at the begining the window size will grow from 0 to k
//		
//		if(right >= k - 1) {
//			res[right - k + 1] = nums[deque.peekFirst()];
//		}
//		
//	}
//	return res;
//    
//}

//=======================

//public List<Integer> findSubstring(String s, String[] words) {
//	if(s.length() ==0 || words.length == 0) return new ArrayList<Integer>();
//	
//    int k = words.length;
//    int eachwordLen = words[0].length();
//    int windowLen = k * eachwordLen;
//
//    Map<String, Integer> freqMap = new HashMap<String, Integer>();        
//    
//    List<Integer> res = new ArrayList<Integer>();
//    
//    // generate the freq map
//    for(int i = 0; i < words.length; i++) {
//    	if(freqMap.containsKey(words[i])) {
//    		freqMap.put(words[i], freqMap.get(words[i]) + 1);
//    	} else {
//    		freqMap.put(words[i], 1);
//    	}
//    }
//
//    // to catch all valid concatenations, we need to try every possible offset
//    // Imagine this: you’re scanning a sentence with a ruler that’s exactly 
//    // the size of one word. You move this ruler in steps of 
//    // word size (e.g., 3 or 4 characters), but where you start 
//    // scanning from affects which chunks (words) you see.
//    // So, for:
//	// •	wordLen = 3
//	// •	You could start at index 0, 1, or 2
//    //Each of those gives you a different alignment for 3-letter words:
////    s = "abcxyzabcxyzabc"
////	     ↑  ↑  ↑  ↑   → i = 0 (word-aligned start)
////	      ↑  ↑  ↑       → i = 1 (misaligned)
////	       ↑  ↑  ↑      → i = 2 (misaligned)
////    
//    
//    for(int l = 0; l < eachwordLen; l++) {
//    	// initialize left
//    	int left = l;
//    	int right = l;
//        Map<String, Integer> window = new HashMap<String, Integer>();        
//
//		while(right + eachwordLen <= s.length()) {
//			//expand the window to right
//	        String word = s.substring(right, right + eachwordLen);
//	        right += eachwordLen;
//	        
//	        // we process the word only if its in target word list, otherwise discard
//	        if (freqMap.containsKey(word)) {
//	        	window.put(word, window.getOrDefault(word, 0) + 1);
//		    	
//                // If we exceed the allowed count, shrink the window
//	        	while(window.get(word) > freqMap.get(word)) { 
//		        	// shrink the window
//		        	String leftWord = s.substring(left, left + eachwordLen);
//		        	window.put(leftWord, window.get(leftWord) - 1);
//		        	
//		        	if(window.get(leftWord) == 0) {
//		        		window.remove(leftWord);
//		        	}
//		        	left += eachwordLen; 
//	        	}
//	        	// update result
//	        	if(freqMap.equals(window)) res.add(left);
//	        	
//	        } else { // when a miss match found we discard the current window, cause non target words found
//	        	window.clear();
//	        	left = right;
//	        }
//		}
//    }
//	return res;
//}

//========================
//
//public int longestOnes(int[] nums, int k) {
//	//initialize left
//	int left = 0;
//	int right = 0;
//
//	int oneCntSoFar = 0;
//	int maxLen = Integer.MIN_VALUE;
//	
//	while(right < nums.length) {
//		oneCntSoFar += nums[right] & 1;
//		right++;
//		
//		// (right-left) - oneCntSoFar -> windowlen - number of One's so far
//		// this gives us how many replacement we need to do.
//		int windowSize = right - left;
//		
//		// if window is valid 
//		if(windowSize - oneCntSoFar <= k) {
//			// for valid window update the result
//			maxLen = Math.max(windowSize, maxLen);
//		} else {
//			// now shrink the window from left it the window becomes 
//			// invalid again. so that we can traverse towards right
//			// the entire input array.
//			if(nums[left] == 1) oneCntSoFar--;
//			left++;
//		}
//	}
//	return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
//}

//=================

//public int minSubArrayLen(int target, int[] nums) {
//// initialize left
//int left = 0;
//int right = 0;
//int sum = 0;
//int minLen = Integer.MAX_VALUE;
//
//// loop right from 0 to n-1
//while(right < nums.length) {
//	// expand towards right
//	sum += nums[right];
//	right++; 
//	
//	// check if valid window
//	while(sum >= target) {
//		if(right - left < minLen) {
//			//update result
//			minLen = right - left;
//		}
//		
//		// now shrink the window until its invalid again
//		// this allow us to traverse the entire input array.
//		// when we find a valid window we update the result 
//		// then again we shrink from the left until our valid 
//		// window becomes invalid. when the window becomes invalid
//		// again we expand from the right.
//		sum -= nums[left];
//		left++;
//	}
//}
//return  minLen == Integer.MAX_VALUE ? 0 : minLen;
//}
//===================

//public String minWindow(String s, String t) {
//
//if(t.length() > s.length()) return "";
//
//int left = 0;
//int right = 0;
//int minLen = Integer.MAX_VALUE;
//String minWindow = "";
//Map<Character, Integer> freqMap = new HashMap<Character, Integer>();
//
//for(int i = 0; i < t.length(); i++) {
//	char c = t.charAt(i);
//	if(freqMap.containsKey(c)) {
//		freqMap.put(c, freqMap.get(c) + 1);
//	} else {
//		freqMap.put(c, 1);
//	}
//}
//
//int required = freqMap.size();
//
//while(right < s.length()) {
//	char c = s.charAt(right);
//	
//	if(freqMap.containsKey(c)) {
//		freqMap.put(c, freqMap.get(c) - 1);
//		
//		if(freqMap.get(c) == 0) {
//			required--;
//		}
//	}
//	right++;
//	//check if valid window
//	while(required == 0) {
//		int windowSize = right - left;
//		// if valid update the result
//		if(windowSize < minLen) {
//			minLen = windowSize;
//			minWindow = s.substring(left, right);
//		}
//		// now shrink the window from left
//		char leftChar = s.charAt(left);
//		if(freqMap.containsKey(leftChar)) {
//    		freqMap.put(leftChar, freqMap.get(leftChar) + 1);
//			
//    		if(freqMap.get(leftChar) > 0) required++;
//		}
//		left++;
//	}
//}
//return minWindow;
//
//}


//public int characterReplacement(String s, int k) {
////initialize left
//
//int left = 0;
//int[] freq = new int[26];
//int maxFreq = 0;
//int maxWindow = 0;
//
////loop right from 0 to n-1
//for(int right = 0; right < s.length(); right++) {
//	// expand
//	freq[s.charAt(right) - 'A'] += 1;
//	
//	// tracking the element with max frequency in the window
//	// NOTE: the 'maxFreq' will not be updated always
//	// however, that is not an error .
//	// the notion is the more the max-freq the bigger the 
//	// window size will be with lower number of replacements.
//	// which is good for our algorithm., higher maxFreq == more letters
//	// are in same group.
//	// once we found a higher maxFreq we don't need to decrease
//	// it, even if we decrease the maxfreq our max window size will 
//	// not lower. the only time we update our maxFreq is when we get a 
//	// higher freq for a letter in a window.
//	
//	maxFreq = Math.max(freq[s.charAt(right) - 'A'], maxFreq);
//	
//	int windowSize = right - left + 1;
//	
//	// check if window is valid
//	if(windowSize - maxFreq <= k) {
//		maxWindow = Math.max(maxWindow, windowSize);
//	} else {
////		the window is invalid to shrink the window
//		freq[s.charAt(left) - 'A'] -= 1;
//		left++;
//	}
//	
//}
//return maxWindow;
//
//}


//======================
//public List<Integer> findAnagrams(String s, String p) {
//if(p.length() > s.length()) {
//	return new ArrayList<>();
//}
//
//int[] freq1 = new int[26];
//int[] freq2 = new int[26];
//List<Integer> res = new ArrayList<Integer>();
//
//// counting freq of chars of 'p'
//// also counting the freq of the first window in 's' 
//for(int i = 0; i < p.length(); i++) {
//	freq1[p.charAt(i) - 'a'] += 1;
//	freq2[s.charAt(i) - 'a'] += 1;
//}
//
//
//for(int i = 0; i <= s.length() - p.length(); i++) {
//	
//	// check if valid update result
//	if(matches(freq1, freq2)) {
//		res.add(i);
//	}
//
//	// else slide the window to right
//	// expand towards right
//	if(i+p.length() < s.length()) {
//    	freq2[s.charAt(i) - 'a'] -= 1;
//
//    	//shrinking from the left
//    	freq2[s.charAt(i+p.length()) - 'a'] += 1;
//	}
//}
//
//return res;
//}
//private boolean matches(int[] freq1, int[] freq2) {
//for(int i = 0; i < 26; i++) {
//	if(freq1[i] != freq2[i]) return false;
//}
//return true;
//}
//=========================


//public boolean checkInclusion(String s1, String s2) {
//if(s1.length() > s2.length()) {
//	return false;
//}
//// initialize left 
//int left = 0;
//int right = 0;
//int k = s1.length();
//
//Map<Character, Integer> map = new HashMap<>();
//Map<Character, Integer> window = new HashMap<>();
//
//// building s2 frequency map;
//for(int i = 0; i < s1.length(); i++) {
//	char c = s1.charAt(i);
//	map.put(c, map.getOrDefault(c, 0) + 1);
//}
//
////loop right from 0 to n-1
//while(right < s2.length()) {
//	// expand: (Note: first let the window be overflowed)
//	char c = s2.charAt(right);
//	window.put(c, window.getOrDefault(c, 0) + 1);
//		
//	// now when the window is overflowed we shrink it 
//	if(right - left + 1 > k) {
//		// shrink the window by one
//		int freq = window.get(s2.charAt(left));
//		
//		if(freq <= 1) {
//			window.remove(s2.charAt(left));
//		} else {
//			window.put(s2.charAt(left), window.get(s2.charAt(left)) - 1);
//		}
//		
//		left++;
//	}
////	// check if valid the update the result
//	if(map.equals(window)) {
//		return true;
//	}
//	right++;
//}
//return false;
//
//}


//public int lengthOfLongestSubstring(String s) {
//// initialize left 
//
//int left = 0;
//// key,value = char, freq
//Set<Character> set = new HashSet<Character>();
//int max = 0;
//
////Loop right from 0 to n-1
//for(int right = 0; right < s.length(); right++) {
//	char c = s.charAt(right);
//	
//	//expand: implement logic
//	if(!set.contains(c)) { // if valid: 
//		//update result
//		max = Math.max(max, right-left+1);
//		set.add(c);
//	} else {
//		// not valid
//		// move left to shrink window
//		while(set.contains(c)) {
//			set.remove(s.charAt(left));
//			left++;
//		}
//		set.add(c);
//	}
//}
//return max;
//}


//public int maxVowels(String s, int k) {
//int left = 0;
//Set<Character> vowels = new HashSet<Character>();
//vowels.add('a');
//vowels.add('e');
//vowels.add('i');
//vowels.add('o');
//vowels.add('u');
//
//int vowelCnt = 0;
//int max = 0;
//for(int right = 0; right < s.length(); right++) {
//	// expand: implement logic
//	if(vowels.contains(s.charAt(right))) {
//		vowelCnt += 1;
//	}
//	
//	// check condition: if valid
//	if(right-left + 1 == k) {
//		// update result
//		max = Math.max(max, vowelCnt);
//		
//		//shrink window;
//		if(vowels.contains(s.charAt(left))) {
//			vowelCnt--;
//		}
//  	left++;
//	} 
//}
//return max;
//}


//public int maximumUniqueSubarray(int[] nums) {
//int left = 0;
//int max = Integer.MIN_VALUE;
//int sum = 0;
//// key, value = num[i], frequency
//
//Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//for(int right = 0; right < nums.length; right++) {
//	
//	while(map.containsKey(nums[right])) {
//		map.remove(nums[left]);
//		sum = sum - nums[left];
//		left++;
//	}
//	if(!map.containsKey(nums[right])) {
//  	sum += nums[right];
//  	max = Math.max(max, sum);
//  	map.put(nums[right], 1);
//	} 
//}
//return max;
//}


//public int findLHS(int[] nums) {
//Map<Integer, Integer> map = new HashMap<>();
//
//for(int i = 0; i < nums.length; i++) {
//	if(map.containsKey(nums[i])) {
//		map.put(nums[i], map.get(nums[i]) + 1);
//	} else {
//		map.put(nums[i], 1);
//	}
//}
//int maxLen = 0;
//for(Integer key: map.keySet()) {
//	if(map.containsKey(key + 1)) {
//		maxLen = Math.max(maxLen, map.get(key) + map.get(key + 1));
//	}
//}
//return maxLen;
//}
//


//public double findMaxAverage(int[] nums, int k) {
//	
//	
//	int left = 0;
//	
//	double avg = 0.0;
//	double sum = 0;
//	double max = Double.NEGATIVE_INFINITY;
//	
//	for(int right = 0; right < nums.length; right++) { 
//		sum += nums[right]; // Expand window: right++
//
//		if(right - left + 1 == k) { // Check condition:
//			avg = sum/k;
//			
//  		max = Math.max(max, avg);  //If valid: maybe update answer
//
//			sum = sum - nums[left]; // move left to shrink window
//			left++;
//		}
////		Repeat until right reaches the end
//	}
//	return max == Double.MIN_VALUE ? 0 : max;
//}

