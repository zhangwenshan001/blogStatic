<?php

class Solution {

    /**
     * @param Integer[][] $A
     * @param Integer[][] $B
     * @return Integer[][]
     */
    function intervalIntersection($A, $B) {
        if (count($A) == 0 || count($B) == 0) {
            return [];
        }
        $res = [];
        $i = 0;
        $j = 0;
        $curA = $A[$i];
        $curB = $B[$j];
        
        $countA = count($A);
        $countB = count($B);
        
        while(true) {
            if ($curA[0] >= $curB[0] && $curA[0] <= $curB[1] && $curB[1] <= $curA[1]) {
                $res[] = [$curA[0], $curB[1]];
                $j++;
            } else if ($curB[0] >= $curA[0] && $curB[0] <= $curA[1] && $curA[1] <= $curB[1]) {
                $res[] = [$curB[0], $curA[1]];
                $i++;
            } else if ($curA[0] >= $curB[0] && $curA[1] <= $curB[1]) {
                $res[] = $curA;
                $i++;
            } else if ($curB[0] >= $curA[0] && $curB[1] <= $curA[1]) {
                $res[] = $curB;
                $j++;
            } else {
                if ($curB[1] > $curA[1]) {
                    $i++;
                } else {
                    $j++;
                }
            }
            
            if ($i == $countA || $j == $countB) {
                break;
            }
            $curA = $A[$i];
            $curB = $B[$j];
        }
        
        return $res;
    }
}
