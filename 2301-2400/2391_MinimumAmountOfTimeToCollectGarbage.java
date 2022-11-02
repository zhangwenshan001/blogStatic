class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int count = 0;
        int glast = -1;
        int plast = -1;
        int mlast = -1;
        for (int i = garbage.length-1;i>=0;i--) {
            for (int j = 0;j<garbage[i].length();j++) {
                char c = garbage[i].charAt(j);
                if (c == 'P' && plast < 0) plast = i;
                if (c == 'M' && mlast < 0) mlast = i;
                if (c == 'G' && glast < 0) glast = i;
                count++;
            }
        }

        int t = 3;
        if (glast < 0) t--;
        if (mlast < 0) t--;
        if (plast < 0) t--;
        for (int i = 0;i<travel.length;i++) {
            if (i == plast) t--;
            if (i == mlast) t--;
            if (i == glast) t--;
            count += t*travel[i];
       }

        return count;
    }
}