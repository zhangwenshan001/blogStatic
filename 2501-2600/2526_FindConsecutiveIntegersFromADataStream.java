class DataStream {
    int value;
    int k;
    int counter;
    int lastDiff;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        counter = 0;
        lastDiff = 0;
    }
    
    public boolean consec(int num) {
        counter++;
        if (num != value) lastDiff = counter;
        if (counter - lastDiff >= k) return true;
        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */