class Solution {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int last;
        for (String s : tokens) {
            if (s.equals("+")) {
                last = stack.pollLast();
                stack.set(stack.size()-1, stack.getLast() + last);
            } else if (s.equals("-")) {
                last = stack.pollLast();
                stack.set(stack.size()-1, stack.getLast() - last);
            } else if (s.equals("*")) {
                last = stack.pollLast();
                stack.set(stack.size()-1, stack.getLast() * last);      
            } else if (s.equals("/")) {
                last = stack.pollLast();
                stack.set(stack.size()-1, stack.getLast() / last);
            } else {
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.getFirst();
    }
}