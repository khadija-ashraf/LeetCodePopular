package slidingwindow;

public class DefuseBomb {
    public int[] decrypt(int[] code, int k) {
        if(k == 0) {
        	return new int[code.length];
        }
        
        int[] res = new int[code.length];
        int increment = 1;
        
        if(k < 0) {
        	increment = -1;
        }
        
        int sum = 0;
        
        if(k < 0) {
        	int i = code.length - 2;
        	
        	while(i >= code.length - 1 - (k * increment)) {
        		sum += code[i];
        		i--;
        	}
        	res[code.length-1] = sum;
        } else if(k > 0) {
        	int i = 1;
        	
        	while(i <= k) {
        		sum += code[i];
        		i++;
        	}
        	res[0] = sum;
        } else {
        	return new int[code.length];
        }
        
        if(k < 0) {
        	for(int i = code.length - 2; i >= 0; i--) {
        		sum -= code[i];
        		sum += code[((i + k) + code.length) % code.length];
        		
        		res[i] = sum;
        	}
        }
        if(k > 0) {
        	for(int i = 1; i < code.length; i++) {
        		sum -= code[i];
        		sum += code[((i + k) + code.length) % code.length];
        		
        		res[i] = sum;
        	}
        }
        return res;
    }
	public static void main(String[] args) {
		DefuseBomb ob = new DefuseBomb();
		
		
		int[] code = {2,4,9,3};
		int k = -2;
//		Output: [12,5,6,13]
						
//		int[] code = {5, 7,1,4,3,2};
//		int k = 3;
		//Output:      [12,8,9,10,14,13]
		
//		int[] code = {5, 7, 1,4};
//		int k = 3;
		//Output: [12,10,16,13]

//		int[] code = {1,2,3,4};
//		int k = 0;
		
		int[] res = ob.decrypt(code, k);

		for(int r: res) {
        	System.out.println(r);
        }
	}

}

//int[] code = {5, 7,1,4,3,2};
//int k = 3;
//Output:      [12,8,9,10,14,13]

//int[] code = {5, 7, 1,4};
//int k = 3;
//Output: [12,10,16,13]

//int[] code = {1,2,3,4};
//int k = 0;
//Output: [0,0,0,0]

