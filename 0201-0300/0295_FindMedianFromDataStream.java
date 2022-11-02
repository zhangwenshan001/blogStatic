class MedianFinder {
    PriorityQueue<Integer> left; // max heap
    PriorityQueue<Integer> right; // min heap     
    public MedianFinder() {
        left = new PriorityQueue<>((a,b) -> b - a);
        right = new PriorityQueue<>((a,b) -> a - b);
    }
    
    public void addNum(int num) {
        if (left.isEmpty() && right.isEmpty()) left.offer(num);
        else if (left.size() == right.size()) {
            if (num <= right.peek()) {
                left.offer(num);
            } else {
                left.offer(right.poll());
                right.offer(num);
            }
        } else { // left size > right size
            if (num >= left.peek()) {
                right.offer(num);
            } else {
                right.offer(left.poll());
                left.offer(num);
            }
        }
    }
    
    public double findMedian() {
        if (left.size() > right.size()) return (double) left.peek();
        return (double) (left.peek() + right.peek()) / 2;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */