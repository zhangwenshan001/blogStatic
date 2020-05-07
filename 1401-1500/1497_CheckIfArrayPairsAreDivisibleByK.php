<?php
class Solution {

    /**
     * @param Integer[] $arr
     * @param Integer $k
     * @return Boolean
     */
    function canArrange($arr, $k) {
        $n = count($arr);
        $tmp = array_fill(0, $n, 0);
        for($i = 0;$i<$n;$i++) {
            $cur = $arr[$i] % $k;
            if ($cur <0) {
                $cur = $cur+$k;
            }
            $tmp[$cur]++;
        }
        if ($tmp[0] % 2 != 0) {
            return false;
        }
        
        for($i = 1;$i<=$k/2;$i++) {
            if ($tmp[$i] != $tmp[$k-$i]) {
                return false;
            }
        }
        
        return true;
    }
}
