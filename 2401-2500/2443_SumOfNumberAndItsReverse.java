class Solution {
    static HashSet<Integer> numSet = new HashSet<>();
    static {
        for(int i = 0; i<=19999; i++)
            numSet.add(i+revSum(i));
    }
    public boolean sumOfNumberAndReverse(int num) {
        return numSet.contains(num);
    }
    static int revSum(int num)
    {
        int sum = 0;
        while(num>0)
        {
            sum = sum*10+num%10;
            num/=10;
        }
        return sum;
    }
}