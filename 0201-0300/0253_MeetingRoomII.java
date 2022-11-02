// Time complexity O(NlogN)
// Space complexity O(N)
public class Solution {

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        List<Point> points = new ArrayList<>();
        for (Interval interval : intervals) {
            points.add(new Point(interval.start, 1));
            points.add(new Point(interval.end, -1));
        }
        Collections.sort(points, (a, b) -> a.time == b.time ? a.type - b.type : a.time - b.time);

        int count = 0;
        int ongoing = 0;

        int maxOverlapStart = -1;
        int maxOverLapEnd = -1;
        boolean updateFlag = false;
        for (Point p: points) {
            ongoing += p.type;

						// this part is trying to get in which interval the overlapCount is max
            if (ongoing > count) {
                count = ongoing;
                maxOverlapStart = p.time;
                updateFlag = true;
            }
            if (updateFlag && p.type == -1) {
                maxOverLapEnd = p.time;
                updateFlag = false;
            }
        }
        return count;
    }
}

class Point {
    int time;
    int type;

    public Point(int time, int type) {
        this.time = time;
        this.type = type; // start 1; end -1
    }
}