<?php

class Solution {

    /**
     * @param Integer[][] $intervals
     * @return Integer[][]
     */
    function merge($intervals) {
        $count = count($intervals);

        if ($count <= 1) {
            return $intervals;
        }

        usort($intervals, function ($a, $b) {
            if ($a[0] == $b[0] && $a[1] == $b[1]) {
                return 0;
            }
            if ($a[0] < $b[0] || ($a[0] == $b[0] && $a[1] < $b[1])) {
                return -1;
            }
            if ($a[0] > $b[0] || ($a[0] == $b[0] && $a[1] > $b[1])) {
                return 1;
            }
        });

        $result   = [];
        $curStart = $intervals[0][0];
        $curEnd   = $intervals[0][1];
        for ($i = 1; $i < $count; $i++) {
            if ($intervals[$i][0] > $curEnd) {
                $result[] = [$curStart, $curEnd];
                $curStart = $intervals[$i][0];
                $curEnd   = $intervals[$i][1];
            } else {
                $curEnd = max($curEnd, $intervals[$i][1]);
            }
        }
        $result[] = [$curStart, $curEnd];

        return $result;
    }
}
