<?php

class Solution {

    /**
     * @param Integer[] $numbers
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($numbers, $target) {
        $start = 0;
        $end = count($numbers)-1;
        
        while($start < $end) {
            if ($numbers[$start] + $numbers[$end] == $target) {
                return [$start+1, $end+1];
            }  else if ($numbers[$start] + $numbers[$end] > $target) {
                $end--;
            } else {
                $start++;
            }
        }
        
        return [];
    }
}
