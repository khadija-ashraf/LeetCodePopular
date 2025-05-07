package com.leetcode.hard.graph;

import java.util.*;

public class Solution {
	public int numBusesToDestination(int[][] routes, int source, int target) {
		
        HashMap<Integer, Integer> stopMark = new HashMap<Integer, Integer>();

        Map<Integer, List<Integer>> graph = buildAdj(routes, stopMark);
        
        Set<Integer> visited = new HashSet<Integer>();
        
        return bfs(graph, source, target, stopMark, visited);
        
        
    }
	
	public int bfs(Map<Integer, List<Integer>> graph, 
			int source, int target, 
			HashMap<Integer, Integer> levels,
			Set<Integer> visited) {
		
		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);
		visited.add(source);


		Map<Integer, Integer> parent = new HashMap<Integer, Integer>();
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			
			if(current == target) {
				break;
			}

			for(int neighbor: graph.getOrDefault(current, new ArrayList<>())) {
				if(!visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.add(neighbor);
					parent.put(neighbor, current);
				}
			}
		}
		
		// reconstruct the path from the parent array
		List<Integer> path = new ArrayList<Integer>();
		
		if(!visited.contains(target)) {
			return -1;
		}
		int i = target;
		
		path.add(i);
		
		while(i != source) {
			path.add(parent.get(i));
			i = parent.get(i);
		}
		
		path = path.reversed();
		
		int cnt = 0;
		for(int j = 0; j < path.size()-1; j++) {
			int a = path.get(j);
			int b = path.get(j+1);
			if(levels.get(a) != levels.get(b)) {
				cnt++;
			}
		}
		return cnt == 0 ? -1 : cnt;
	}
	public Map<Integer, List<Integer>> buildAdj(int[][] routes, HashMap<Integer, Integer> levels){
		Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		
		for(int i = 0; i < routes.length; i++) {
			for(int j = 0; j < routes[i].length; j++) {
				levels.put(routes[i][j], i);
				if(j == routes[i].length - 1) {
					int from = routes[i][j];
					int to = routes[i][0];
					if(graph.containsKey(from)) {
						graph.get(from).add(to);
					} else {
						List<Integer> list = new ArrayList<Integer>();
						list.add(to);
						graph.put(from, list);
					}
				} else {
					int from = routes[i][j];
					int to = routes[i][j+1];
					if(graph.containsKey(from)) {
						graph.get(from).add(to);
					} else {
						List<Integer> list = new ArrayList<Integer>();
						list.add(to);
						graph.put(from, list);
					}
				}

			}
		}
		return graph;
	}

	public static void main(String a[]) {
		Solution ob = new Solution();
		
//		int[][] routes = {{1,2,7},{3,6,7}};
//		int source = 1, target = 6;
		
//		int[][] routes = {{7,12},{4,5,15},{6},{15,19},{9,12,13}};
//		int source = 5, target = 12;
//		
		int[][] routes = {{0,1,6,16,22,23},{14,15,24,32},{4,10,12,20,24,28,33},
				{1,10,11,19,27,33},{11,23,25,28},{15,20,21,23,29},{29}};
		
		int source = 4;                                                                               
		
		int target = 21;
		

		System.out.println(ob.numBusesToDestination(routes, source, target));
	}

}
