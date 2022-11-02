class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = new int[edges.length];
        int[] dist2 = new int[edges.length];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        int c = 0;
        int p = node1;
        while(p != -1) {
            if (dist1[p] >=0) break;
            dist1[p] = c++;
            p = edges[p];
        }

        c = 0;
        p = node2;
        while(p != -1) {
            if (dist2[p] >=0) break;
            dist2[p] = c++;
            p = edges[p];
        }

        
        int min = -1;
        int res = -1;
        for(int i = 0;i<edges.length;i++) {
            if (dist1[i] < 0 || dist2[i] < 0) continue;
            if (min == -1 || Math.max(dist1[i], dist2[i]) < min) {
                min = Math.max(dist1[i], dist2[i]);
                res = i;
            }
        }

        return res;
    }
}