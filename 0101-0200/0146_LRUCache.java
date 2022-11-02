class Node {
    int key;
    int val;
    Node pre;
    Node post;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node cur = map.get(key);


        // if cur is tail, need update tail
        if (cur.pre != null && cur.post == null) {
            tail = cur.pre;
        }

        // if cur is not head
        if (cur.pre != null) {
            Node curPre = cur.pre;
            Node curPost = cur.post;

            curPre.post = curPost;
            if (curPost != null) curPost.pre = curPre;

            cur.post = head;
            cur.pre = null;
            head.pre = cur;
            
            head = cur;
        }
        return cur.val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node cur = map.get(key);
            cur.val = value;

            if (cur.pre != null && cur.post == null) {
                tail = cur.pre;
            }

            if (cur.pre != null) {
                Node curPre = cur.pre;
                Node curPost = cur.post;

                curPre.post = curPost;
                if (curPost != null) curPost.pre = curPre;

                cur.post = head;
                cur.pre = null;
                head.pre = cur;
            
                head = cur;
            }
            return;
        }

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        newNode.post = head;
        head.pre = newNode;
        head = newNode;
        if (map.keySet().size() > capacity) {
            map.remove(tail.key);
            tail = tail.pre;
            tail.post.pre = null;
            tail.post = null;
        } 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */