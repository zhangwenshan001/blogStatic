class Solution {
    public long countGood(int[] nums, int k) {
        int i = 0, j = 0;
        Map<Integer, Integer> count = new HashMap<>();
        
        long res = 0;
        int goodCount = 0;
        while(j < nums.length) {
            int jCount = count.getOrDefault(nums[j], 0);
            count.put(nums[j], jCount+1);
            goodCount += jCount;
            if (goodCount >= k) {
                res += nums.length - j; 
            }
            
            while(goodCount >= k && i < j) {
                int iCount = count.get(nums[i]);
                count.put(nums[i], iCount-1);
                goodCount -= (iCount - 1);
                i++;
                if (goodCount >= k) {
                    res += nums.length - j; 
                } 
            }
            j++;
            
        }
        return res;
    }
}