class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;

        List<Integer> stack = new ArrayList<>();
        while(i < pushed.length || j<popped.length) {
            while(stack.size() > 0 && j<popped.length && stack.get(stack.size()-1) == popped[j]) {
                j++;
                stack.remove(stack.size()-1);
            }  
            while(i < pushed.length && j<popped.length && pushed[i] != popped[j]) {
                stack.add(pushed[i]);
                i++;
            } 
            i++;
            j++;
        }
        
        return stack.size() == 0;
    }
}