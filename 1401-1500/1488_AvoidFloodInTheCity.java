class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> tmp = new HashMap<Integer, Integer>();
	        List<Integer> zero = new LinkedList<Integer>();
	        
	        int n = rains.length;
	        int[] res = new int[n];
	        
	        for(int i = 0;i<n;i++) {
	        	if (rains[i] == 0) {
	        		zero.add(i);
	        		res[i] = 1;
	        		continue;
	        	}
	            if (tmp.containsKey(rains[i])) {
	            	if (zero.size()>0) {
	            		res[i] = -1;
	            		int j = 0;
	            		while(j<zero.size() && zero.get(j) < tmp.get(rains[i])) {
	            			j++;
	            		}
	            		if (j>= zero.size()) {
	            			return new int [0];
	            		} else {
	            			res[zero.get(j)] = rains[i];
                            zero.remove(j);
                            tmp.put(rains[i], i);
						}
	            	} else {
						return new int [0];
					}
	            } else {
					res[i] = -1;
					tmp.put(rains[i], i);
				}   
	        }
	        
	        return res;
    }
}