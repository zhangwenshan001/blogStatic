class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0;i<nums.length;i++) {
            map.put(nums[i], i);
        }

        int index;
        for(int i = 0;i<operations.length;i++) {
            index = map.get(operations[i][0]);
            nums[index] = operations[i][1];
            map.put(operations[i][1], index);
        }

        return nums;
    }

}