class Solution {
    public String robotWithString(String s) {
        int slen = s.length();
        int[] rightMinIndex = new int[slen];
        int curMinIndex = slen-1;
        for (int i = slen-1;i>=0;i--) {
            if (s.charAt(i) <= s.charAt(curMinIndex)) {
                curMinIndex = i;
            }
            rightMinIndex[i] = curMinIndex;
        }

        List<Character> stack = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int cur = rightMinIndex[0];
        for (int i = 0;i<cur;i++) {
            stack.add(s.charAt(i));
        }
        sb.append(s.charAt(cur));
        int next;
        while(cur < slen - 1) {
            //step.1 find the smallest one from cur+1
            next = rightMinIndex[cur+1];
            //step.2 compare the first one in stack and the next one (the smallest one from cur+1)
            //step.3 if the first one in stack is smaller, append it to sb and pop it from stack, loop
            if (!stack.isEmpty() && stack.get(stack.size()-1) <= s.charAt(next)) {
                sb.append(stack.get(stack.size()-1));
                stack.remove(stack.size()-1);
            } else {
            //step.4 if the next is smaller, put [cur+1,next) into stack and cur = next, and append cur
                for(int i = cur+1;i<next;i++) {
                    stack.add(s.charAt(i));
                }
                cur = next;
                sb.append(s.charAt(cur));
            }
        }
        for (int i = stack.size()-1;i>=0;i--) {
            sb.append(stack.get(i));
        }
        return sb.toString();
        
        
        
        
    }
}