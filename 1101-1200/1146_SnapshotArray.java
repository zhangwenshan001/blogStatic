class SnapshotArray {
    List<TreeMap<Integer, Integer>> snapShots = new ArrayList<>();
    int [] vals;
    int snapIdx = 0;
    public SnapshotArray(int length) {
        vals = new int[length];

        for (int i = 0;i<length;i++) {
            snapShots.add(new TreeMap<Integer, Integer>());
        }
    }
    
    public void set(int index, int val) {
        vals[index] = val;
    }
    
    public int snap() {
        for (int i = 0;i<vals.length;i++) {
            TreeMap<Integer, Integer> curSnapShot = snapShots.get(i);
            if (curSnapShot.isEmpty() || curSnapShot.get(curSnapShot.lastKey()) != vals[i]) {
                curSnapShot.put(snapIdx, vals[i]);
            }
        }
        return snapIdx++;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer, Integer> curSnapShot = snapShots.get(index);
        int start = 0;
        int end = curSnapShot.lastKey();
        if (snap_id >= end) return curSnapShot.get(end);
        while(start < end) {
            int mid = (start + end) / 2;
            if ()
        }
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */