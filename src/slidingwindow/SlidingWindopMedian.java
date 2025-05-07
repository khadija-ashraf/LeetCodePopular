package slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindopMedian {
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
