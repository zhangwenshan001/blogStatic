class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return m;
        }
        int floorM = getFloor(m);
        int floorN = getFloor(n);
        
        int res = 0;
        while (floorM == floorN) {
             res = res + (int)Math.pow(2, floorM);
             m = m - (int)Math.pow(2, floorM);
             n = n - (int)Math.pow(2, floorN);
            floorM = getFloor(m);
            floorN = getFloor(n);
        }
        
        return res;
    }
    
    public int getFloor(int k) {
        int floor = -1;
        while(k > 0) {
            k = k >> 1;
            floor++;
        }
        return floor;
    }
}