class NumberContainers {
    HashMap<Integer,TreeSet<Integer>> map;
    HashMap<Integer,Integer> mm;
    public NumberContainers() {
        this.map = new HashMap<>();
        this.mm = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(mm.containsKey(index)) {
            map.get(mm.get(index)).remove(index);
            if(map.get(mm.get(index)).size() == 0) map.remove(mm.get(index));
        }
        map.putIfAbsent(number,new TreeSet<>());
        map.get(number).add(index);
        mm.put(index,number);
    }
    
    public int find(int number) {
        if(!map.containsKey(number)) return -1;
        return map.get(number).first();
    }
}
