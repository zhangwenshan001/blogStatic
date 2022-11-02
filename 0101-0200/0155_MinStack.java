class MinStack {

    List<Integer> stack = null;
	List<Integer> minStack = null;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<Integer>();
    	minStack = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        stack.add(x);

    	if (minStack.size() == 0) {
    		minStack.add(x);
    	} else {
			int min = minStack.get(minStack.size()-1);
			minStack.add(Math.min(min, x));
		}
    }
    
    public void pop() {
       stack.remove(stack.size()-1);
    	minStack.remove(minStack.size()-1); 
    }
    
    public int top() {
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        return minStack.get(minStack.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */