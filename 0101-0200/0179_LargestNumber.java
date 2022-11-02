class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for(int i = 0;i<nums.length;i++) {
            strNums[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String o1 = a + b;
                String o2 = b + a;
                return o2.compareTo(o1);
            }
        });

        if (strNums[0].equals("0")) return "0";

        StringBuilder res = new StringBuilder();
        for(String s : strNums) {
            res.append(s);
        }
        return res.toString();
    }
}