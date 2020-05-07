<?php
class Solution {

    /**
     * @param Integer[] $arr
     * @param Integer $a
     * @param Integer $b
     * @param Integer $c
     * @return Integer
     */
    function countGoodTriplets($arr, $a, $b, $c) {
        $n = count($arr);
        if ($n < 3) {
            return 0;
        }
        $res=0;
        for($i =0;$i<$n-2;$i++) {
            for($j =$i+1;$j<$n-1;$j++) {
                for($k = $j+1;$k<$n;$k++) {
                    if ($arr[$i] - $arr[$j] <= $a && $arr[$i] - $arr[$j] >= -$a 
                       && $arr[$j] - $arr[$k] <= $b && $arr[$j] - $arr[$k] >= -$b
                        && $arr[$i] - $arr[$k] <= $c && $arr[$i] - $arr[$k] >= -$c
                       ) {
                        $res++;
                    }
                }
            }
        }
        
        return $res;
    }
}
