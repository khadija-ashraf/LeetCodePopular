package com.leetcode.easy.list;

import java.util.*;

public class RandomizedSet {
	
	List<Integer> list;
	Map<Integer, Integer> map;
	
	public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    public boolean insert(int val) {
        if(list == null) {
        	list = new ArrayList<Integer>();
        }
        
        if(map == null) {
        	map = new HashMap<Integer, Integer>();;
        }

        if(map.containsKey(val)) {
        	return false;
        }
        
        // add into list
        list.add(val);
        
        // the index of 'val' in the list is the last index of the list.
        // cause 'val' has been added to the end of the list and no other
        // element has been added into the list yet.
        int index = list.size() - 1;
        
        map.put(val, index);
        return true;
    }
    
    public boolean remove(int val) {
        if(list == null || map == null) return false;
        
        if(!map.containsKey(val)) return false;
        
        int rmvCandidateIdx = map.get(val);
        
        if(rmvCandidateIdx != list.size() - 1) {
            int listLastItem = list.get(list.size() - 1);
            // the removing item got replaced by the list element in the list.
            list.set(rmvCandidateIdx, listLastItem); 
            map.put(listLastItem, rmvCandidateIdx);
        } 
        
        // now we removed the list item in the list casue this item already moved to the removing item location.
        // also we removed the last index of the list casue it is duplicate now.
        // removing the list item from a list is a 0(1) operation.
        list.remove(list.size() - 1);
        
        map.remove(val);
        
        return true;
        
    }
    
    public int getRandom() {
    	if(list == null || list.size() == 0) return 0;
    	Random rand = new Random();
    	int randomIdx = rand.nextInt(list.size());
    	return list.get(randomIdx);
    }
    
    public static void main(String a[]) {
    	RandomizedSet obj = new RandomizedSet();
    	boolean param_1 = obj.insert(20);
    	boolean param_2 = obj.insert(30);
    	boolean param_4 = obj.insert(10);
//    	boolean param_5 = obj.insert(30);
    	boolean param_6 = obj.remove(10);

    	boolean param_7 = obj.remove(20);
    	System.out.println(obj.list);

    	boolean param_8 = obj.remove(30);
    	int param_3 = obj.getRandom();
    	System.out.println(param_3);
    }
}
