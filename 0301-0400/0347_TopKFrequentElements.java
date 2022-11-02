import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
         Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		 for (int i : nums) {
			 freq.put(i, freq.getOrDefault(i, 0) + 1);
		}

		 List<Integer>[] freqNum = new ArrayList[nums.length];
		 Iterator<Entry<Integer, Integer>> iterator = freq.entrySet().iterator();
		 while (iterator.hasNext()) {
			 Map.Entry<Integer, Integer> entry = iterator.next();
			 Integer key = entry.getKey();
			 Integer freqValue = entry.getValue();
			 if (freqNum[freqValue-1] == null) {
				 freqNum[freqValue-1] = new ArrayList<Integer>();
			 }
			 freqNum[freqValue-1].add(key); //freq same
		}

		 List<Integer> result = new ArrayList<Integer>();
		 int index = nums.length - 1;
		 while(k>0 && index>=0) {
			 if (freqNum[index] != null) {
				 result.addAll(freqNum[index]);
				 k = k-freqNum[index].size();
			 }
			 index--;
		 }

		 return result;
    }
}