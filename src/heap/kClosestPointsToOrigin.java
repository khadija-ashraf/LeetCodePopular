package heap;

import java.util.PriorityQueue;

public class kClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        
    	PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
    			(x,y) -> Integer.compare(distance(y), distance(x)));
    	
    	for(int[] point: points) {
    		maxHeap.offer(point);
    		if(maxHeap.size() > k) {
    			maxHeap.poll();
    		}
    	}
    	
    	int[][] res = new int[k][2];
    	for(int i = 0; i < k; i++) {
    		res[i] = maxHeap.poll();
    		System.out.println(res[i][0] +", "+ res[i][1]);
    	}
    	return res;
    }
    
    private int distance(int[] p) {
    	return p[0]*p[0] + p[1]*p[1];
    }
    
	public static void main(String[] args) {
		kClosestPointsToOrigin ob = new kClosestPointsToOrigin();
		
//		int[][] points = {{1,3},{-2,2}};
//		int k = 1;
//		Output: [[-2,2]]
		
		int[][] points = {{3,3},{5,-1},{-2,4}};
		int k = 2;
//		Output: [[3,3],[-2,4]]
		ob.kClosest(points, k);
		
	}

}
