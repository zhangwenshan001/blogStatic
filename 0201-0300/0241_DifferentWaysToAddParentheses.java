public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0;i<input.length();i++) {
            if (input.charAt(i) == '-' || input.charAt(i) == '+' || input.charAt(i) == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
                for (int l : left) {
                    for (int r : right) {
                        if (input.charAt(i) == '-') {
                            ans.add(l - r);
                        }
                        if (input.charAt(i) == '+') {
                            ans.add(l + r);
                        }
                        if (input.charAt(i) == '*') {
                            ans.add(l * r);
                        }
                    }
                }
            }
        }
        if (ans.size() == 0) ans.add(Integer.parseInt(input));
        return ans;
    }
}