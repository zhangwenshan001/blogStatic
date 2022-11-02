class Solution {
    // Time complexity O(N) because only loop once
    // Space complexity O(1)
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int customerCountsInNonGrumpyMinutes = 0; // if grumpy[i] = 0, customers[i] must be satisfied.

        int curCustomerCountsInGrumpyMinutes = 0; // for cur slide window
        int max = 0; 

        for (int i = 0;i<customers.length;i++) {
            if (grumpy[i] == 0) customerCountsInNonGrumpyMinutes += customers[i];

            else curCustomerCountsInGrumpyMinutes += customers[i];

            // slide window length = minutes [0, minutes-1]
            if (i > minutes-1 && grumpy[i-minutes] == 1) {
                curCustomerCountsInGrumpyMinutes -= customers[i - minutes];
            } 
            max = Math.max(max, curCustomerCountsInGrumpyMinutes);
        }

        return customerCountsInNonGrumpyMinutes + max;
    }

    // public static void main(String[] args) {
    //     (new Solution()).maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3); 
    //     (new Solution()).maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 1);
    //     (new Solution()).maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 100);  
    // }
}