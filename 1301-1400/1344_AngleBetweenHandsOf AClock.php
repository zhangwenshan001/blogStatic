<?php
class Solution {

    /**
     * @param Integer $hour
     * @param Integer $minutes
     * @return Float
     */
    function angleClock($hour, $minutes) {
        $minutesAngle = $minutes * 6;
        $hourAngle = $hour * 30;
        
        $hourMinitesAngle = $minutes * 0.5;
        
        $res = abs($hourAngle+$hourMinitesAngle-$minutesAngle);
        if ($res > 180) {
            return 360 - $res;
        }
        
        return $res;
    }
}
