class Solution {
    // method 1
    // public int minGroups(int[][] intervals) {
    //     int res = 0, cur = 0, n = intervals.length, A[][] = new int[n * 2][2];
    //     for (int i = 0; i < n; ++i) {
    //         A[i * 2] = new int[]{intervals[i][0], 1};
    //         A[i * 2 + 1] = new int[]{intervals[i][1] + 1, -1};
    //     }
    //     Arrays.sort(A, Comparator.comparingInt(o -> o[0] * 3 + o[1]));
    //     for (int[] a: A)
    //         res = Math.max(res, cur += a[1]);
    //     return res;
    // }

    // method 2
    // public int minGroups(int[][] intervals) {
        // int n = intervals.length;
        // int[] begin = new int[n];
        // int[] end = new int[n];
        // for(int i = 0;i<n;i++) {
        //     begin[i] = intervals[i][0];
        //     end[i] = intervals[i][1];
        // }
        // Arrays.sort(begin);
        // Arrays.sort(end);

        // int j = 0;
        // for(int i =0;i<n;i++) {
        //     if (begin[i] > end[j]) j++; //j means we can reuse j rooms 
        // }

        // return n-j;
    // }
    
    public int minGroups(int[][] intervals) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Arrays.sort(intervals, (a,b)->(a[0]==b[0])?a[1]-b[1]:a[0]-b[0]);

        for (int[] arr :intervals) {
            // remove if last meeting is ended
            if (pq.size()>0 && pq.peek() < arr[0]) pq.remove(); 
            //start current meeting
            pq.add(arr[1]); 
        }
    
        return pq.size();
    }

}