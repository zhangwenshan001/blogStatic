class Solution {
    int[] arrays;
    int[] randomArrays;

    Random rand = new Random();

    public Solution(int[] nums) {
        arrays = nums;
        randomArrays = nums.clone();
    }
    
    public int[] reset() {
        return arrays.clone();
    }

    public int[] shuffle() {
        for (int i = 0; i < arrays.length; i++) {
            int randomIndex = rand.nextInt(arrays.length - i) + i;
            int tmp = randomArrays[i];
            randomArrays[i] = randomArrays[randomIndex];
            randomArrays[randomIndex] = tmp;
        }
        return randomArrays;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */