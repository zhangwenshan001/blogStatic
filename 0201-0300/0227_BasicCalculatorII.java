class Solution {
    public int calculate(String s) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        int numStartIndex = 0;
        for (int i = 0;i<=s.length();i++) {
            if (i == s.length() || s.charAt(i) == '+' ||s.charAt(i) == '-' || s.charAt(i) == '*'||s.charAt(i) == '/') {
                int cur = 0;
                for (int j = numStartIndex;j<i;j++) {
                    if (s.charAt(j) >= '0' && s.charAt(j) <= '9') cur = cur * 10 + s.charAt(j) - '0';
                }
                numStartIndex = i+1;
                if (ops.isEmpty() || ops.get(ops.size()-1)=='+' || ops.get(ops.size()-1) == '-') {
                    nums.add(cur);
                    if (i < s.length())ops.add(s.charAt(i));
                    continue;
                }
                
                char lastOp = ops.get(ops.size()-1);
                int lastNum = nums.get(nums.size()-1);
                if (lastOp == '*') { 
                    nums.set(nums.size()-1, lastNum * cur);
                    if (i<s.length()) ops.set(ops.size()-1, s.charAt(i));
                    else ops.remove(ops.size()-1);
                } else if (lastOp == '/') {
                    nums.set(nums.size()-1, lastNum / cur);
                    if (i<s.length()) ops.set(ops.size()-1, s.charAt(i));
                    else ops.remove(ops.size()-1);
                } 
            }
        }
        
        int num1 = nums.get(0);
        int num2;
        if (!ops.isEmpty()) {
            for (int i = 0;i<ops.size();i++) {
                num2 = nums.get(i+1);
                if (ops.get(i) == '+') num1 = num1 + num2;
                if (ops.get(i) == '-') num1 = num1 - num2;
            }
        }
        return num1;
    }
}