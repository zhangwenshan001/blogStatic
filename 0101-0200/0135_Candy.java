class Solution {
    public int candy(int[] ratings) {

        int[] distributes = new int[ratings.length];
        distributes[0] = 1;
        for (int i = 1;i<ratings.length;i++) {
            if (ratings[i] > ratings[i-1]) distributes[i] = distributes[i-1] + 1;
            else distributes[i] = 1;
        }

        int sum = distributes[ratings.length-1];
        for (int i = ratings.length-2;i>=0;i--) {
            if (ratings[i] > ratings[i+1]) {
                distributes[i] = Math.max(distributes[i], distributes[i+1] + 1);
            }
            sum += distributes[i];
        }

        return sum;
    }
}