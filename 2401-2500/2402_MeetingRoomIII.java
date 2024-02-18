class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> unusedRoom  = new PriorityQueue<>();
        PriorityQueue<int[]> ongoingMeeting = new PriorityQueue<>((a,b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]); 
        for (int i = 0;i<n;i++) unusedRoom.offer(i);
        int[] counts = new int[n];
        int ans = -1;
        for (int[] meeting : meetings) {
            int startTime = meeting[0];
            int endTime = meeting[1];
            while(ongoingMeeting.size() > 0 && ongoingMeeting.peek()[1] <= startTime) {
                unusedRoom.offer(ongoingMeeting.poll()[2]);
            }
            if (unusedRoom.size() > 0) {
                int room = unusedRoom.poll();
                ongoingMeeting.offer(new int[]{startTime, endTime, room});
                counts[room]++;
                if (ans < 0 || counts[room] > counts[ans] || counts[room] == counts[ans] && room < ans ) ans = room;
            } else {
                int[] first = ongoingMeeting.poll();
                ongoingMeeting.offer(new int[]{first[1], endTime-startTime+first[1], first[2]});
                counts[first[2]]++;
                if (ans < 0 || counts[first[2]] > counts[ans] || counts[first[2]] == counts[ans] && first[2] < ans) ans = first[2];
            }
        }
        return ans;
    }
}