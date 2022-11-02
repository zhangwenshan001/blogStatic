class CustomStack {
    int[] stack;
    int curIdx;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        curIdx = -1;
    }
    
    public void push(int x) {
        if (curIdx < stack.length-1) {
            stack[++curIdx] = x;
        }
    }
    
    public int pop() {
        if (curIdx == -1) {
            return -1;
        }
        
        return stack[curIdx--];
    }
    
    public void increment(int k, int val) {
        int changeNum = (k <= (curIdx+1)) ? k:curIdx+1;
        for (int i =0;i<changeNum;i++) {
            stack[i] =  stack[i] + val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */