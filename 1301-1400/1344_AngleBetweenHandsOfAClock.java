class Solution {
    public double angleClock(int hour, int minutes) {
        // if hour = 12 -> hour = 0
        hour = hour % 12; 

        // double mAngle = minutes * 360 / 60; 

        // double hAngle = hour * 360 / 12 + 30 * minutes / 60;
        double angle = Math.abs(30 * hour  - 5.5 * minutes);
        return angle > 180 ? 360 - angle : angle;
    }
}