class Solution {
    public int sumSubarrayMins(int[] arr) {
        int len = arr.length;
        int[] dp = new int[len+1];
        LinkedList<Integer> stack = new LinkedList<Integer>(); //record the index of the min 
        stack.add(-1);
        
        int res = 0;
        for (int i = 0;i<len;i++) {
            // if cur <= arr[last], then pop the last
            while(stack.getLast() != -1 && arr[i] <= arr[stack.getLast()]) {
                stack.pollLast();
            }
            //now the last one < cur
            dp[i+1] = (dp[stack.getLast() + 1] + (i - stack.getLast()) * arr[i]) % 1000000007;
            res = (res + dp[i+1]) % 1000000007;
            stack.add(i);
        }

        return res;
    }
}