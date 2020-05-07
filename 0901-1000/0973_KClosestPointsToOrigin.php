<?php

class Solution {

    /**
     * @param Integer[][] $points
     * @param Integer $K
     * @return Integer[][]
     */
    function kClosest($points, $K) {
        $dists = [];
        foreach($points as $key => $point) {
            $dist = $point[0] * $point[0] + $point[1] * $point[1];
            $dists[$key] = $dist;
        }

        asort($dists);
        $res = [];
        
        $count = 0;
        foreach($dists as $index => $dist) {
            $res[] = $points[$index];
            $count++;
            if ($count == $K) {
                break;
            }
        }

        return $res;
    }
}
