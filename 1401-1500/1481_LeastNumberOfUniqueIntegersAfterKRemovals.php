<?php
class Solution {

    /**
     * @param Integer[] $arr
     * @param Integer $k
     * @return Integer
     */
    function findLeastNumOfUniqueInts($arr, $k) {
        $numCount = [];
        $c = count($arr);
        for($i = 0;$i<$c;$i++) {
            $numCount[$arr[$i]] = isset($numCount[$arr[$i]]) ? $numCount[$arr[$i]]+1 : 1;
        }
        
        $counts = array_values($numCount);
        sort($counts);
        $i = 0;
        $sum = $counts[$i];
        while($sum < $k) {
            $i++;
            $sum += $counts[$i];
        }
        if ($sum == $k) {
            return count($counts) - $i - 1;
        } else {
            return count($counts) - $i;
        }
    }
}
