class SummaryRanges {
    TreeMap<Integer, Integer> startRes;
    TreeMap<Integer, Integer> endRes;

    public SummaryRanges() {
        startRes = new TreeMap<>();
        endRes = new TreeMap<>();
    }
    
    public void addNum(int value) {
        int floor = -2 , floorCeiling = -2, ceiling = -2, ceilingFloor = -2;
        
        if (startRes.floorKey(value) != null) {
            floor = startRes.floorKey(value);
            floorCeiling = startRes.get(floor);
        }
        if (endRes.ceilingKey(value) != null) {
            ceiling = endRes.ceilingKey(value);
            ceilingFloor = endRes.get(ceiling);
        }

        if (startRes.size() == 0 || 
        floor < 0 && ceilingFloor > value+1 || 
        ceiling < 0 && floorCeiling < value -1 || 
            value -1 > floorCeiling && value+1 < ceilingFloor
        ) {
            startRes.put(value, value);
            endRes.put(value, value);
            return;
        }
        if (value >= floor && value <=floorCeiling || value >=ceilingFloor && value<=ceiling) return;
        if (value == floor-1) {
            startRes.put(value, floorCeiling);
            startRes.remove(value);
            endRes.put(floorCeiling, value);
            return;
        }
        if (value == ceiling+1) {
            startRes.put(ceilingFloor, value);
            endRes.put(value, ceilingFloor);
            endRes.remove(ceiling);
            return;
        }
        if (value == floorCeiling + 1 && value == ceilingFloor-1) {
            startRes.put(floor, ceiling);
            endRes.put(ceiling, floor);
            startRes.remove(ceilingFloor);
            endRes.remove(floorCeiling);
            return;
        }
        if (value == floorCeiling + 1) {
            startRes.put(floor, value);
            endRes.put(value, floor);
            endRes.remove(floorCeiling);
            return;
        }
        if (value == ceilingFloor-1) {
            startRes.put(value, ceiling);
            endRes.put(ceiling, value);
            startRes.remove(ceilingFloor);
            return;
        }
    }
    
    public int[][] getIntervals() {
        int mapSize = startRes.size();
        int[][] res = new int[mapSize][2];
        
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : startRes.entrySet()) {
            res[i++] = new int[]{entry.getKey(), entry.getValue()};
        }
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */