class BrowserHistoryNode {
    String url;
    BrowserHistoryNode pre = null;
    BrowserHistoryNode next = null;
    
    public BrowserHistoryNode(String url) {
        this.url = url;
    }
}

class BrowserHistory {
    BrowserHistoryNode cur;
        
    public BrowserHistory(String homepage) {
        cur = new BrowserHistoryNode(homepage);
    }
    
    public void visit(String url) {
        if (cur.next != null) {
            cur.next.pre = null;
        }
        cur.next = new BrowserHistoryNode(url);
        cur.next.pre = cur;
        cur = cur.next;
        
    }
    
    public String back(int steps) {
        while(steps > 0 && cur.pre != null) {
            steps--;
            cur = cur.pre;
        }
        
        return cur.url;
    }
    
    public String forward(int steps) {
        while(steps > 0 && cur.next != null) {
            steps--;
            cur = cur.next;
        }
        return  cur.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
