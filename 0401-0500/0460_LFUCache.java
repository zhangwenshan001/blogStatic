class LFUCache {
    Map<Integer, int[]> cache;
    TreeMap<Integer, LinkedList<Integer>> counter;
    Integer capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        counter = new TreeMap<>();
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            int[] val = cache.get(key);
            int count = val[1];
            val[1] = count+1;
            LinkedList<Integer> li = counter.get(count);
            if (li.size() == 1) counter.remove(count);
            else li.remove(li.indexOf(key));

            if (counter.containsKey(count+1)) counter.get(count+1).add(key);
            else {
                LinkedList<Integer> cur = new LinkedList<>();
                cur.add(key);
                counter.put(count+1, cur);
            }
            cache.put(key, val);
            return val[0];
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cache.containsKey(key)) {
            int[] val = cache.get(key);
            int count = val[1];
            val[0] = value;
            val[1] = count + 1;
            cache.put(key, val);

            LinkedList<Integer> li = counter.get(count);
            if (li.size() == 1) counter.remove(count);
            else li.remove(li.indexOf(key));
            if (counter.containsKey(count+1)) counter.get(count+1).add(key);
            else {
                LinkedList<Integer> cur = new LinkedList<>();
                cur.add(key);
                counter.put(count+1, cur);
            }           
        } else {
            if (cache.size() < capacity) {
                cache.put(key, new int[]{value, 1});
                if (counter.containsKey(1)) counter.get(1).add(key);
                else {
                    LinkedList<Integer> cur = new LinkedList<>();
                    cur.add(key);
                    counter.put(1, cur);
                }
            } else {
                Map.Entry<Integer, LinkedList<Integer>> firstEntry = counter.firstEntry();
                if (firstEntry != null) {
                    int removeKey = firstEntry.getValue().get(0);
                    if (firstEntry.getValue().size() == 1) counter.remove(firstEntry.getKey());
                    else firstEntry.getValue().remove(0);
                    cache.remove(removeKey);
                }
                if (counter.containsKey(1)) counter.get(1).add(key);
                else {
                    LinkedList<Integer> cur = new LinkedList<>();
                    cur.add(key);
                    counter.put(1, cur);
                }  
                cache.put(key, new int[]{value, 1});
            }
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */