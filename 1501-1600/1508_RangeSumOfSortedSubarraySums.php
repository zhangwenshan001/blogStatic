<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $n
     * @param Integer $left
     * @param Integer $right
     * @return Integer
     */
    function rangeSum($nums, $n, $left, $right) {
        $sums = [];
        $arr = [];
        for($i = 0;$i<$n;$i++) {
            $sums[$i][$i] = $nums[$i];
            $arr[] = $nums[$i];
        }
        for($i = 0;$i<$n-1;$i++) {
            for($j=$i+1;$j<$n;$j++) {
                $sums[$i][$j] = $sums[$i][$j-1] + $nums[$j];
                $arr[] = $sums[$i][$j];
            }
        }
        
        sort($arr);
        
        $res = 0;
        for($i = $left-1;$i<$right;$i++) {
            $res = ($arr[$i] + $res) % 1000000007;
        }
        
        
        return $res;
        
    }
}
