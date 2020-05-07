<?php
class Solution {

    /**
     * @param Integer[] $stones
     * @return Boolean
     */
    function canCross($stones) {
        if ($stones[0] != 0 || $stones[1] != 1) {
            return false;
        }
        
        $dp = [];
        $dp[1] = [1];
       
        $n = count($stones);
        if ($n == 2) {
            return true;
        }
        
        for($i = 2;$i<$n;$i++) {
            $dp[$stones[$i]] = [];
        }
        for($i = 1;$i<$n;$i++) {
            if (!isset($dp[$stones[$i]])) {
                return false;
            }
            foreach($dp[$stones[$i]] as $unit) {
                if ($unit > 1 && isset($dp[$stones[$i] + $unit - 1])) {
                    if ($stones[$i] + $unit - 1 == $stones[$n-1]) {
                        return true;
                    }
                    if (!in_array($unit - 1, $dp[$stones[$i] + $unit - 1])) $dp[$stones[$i] + $unit - 1][] =  $unit - 1;
                }
                if (isset($dp[$stones[$i] + $unit])) {
                    if ($stones[$i] + $unit == $stones[$n-1]) {
                        return true;
                    }
                    if (!in_array($unit, $dp[$stones[$i] + $unit])) $dp[$stones[$i] + $unit][] =  $unit;
                }
                if (isset($dp[$stones[$i] + $unit +1])) {
                    if ($stones[$i] + $unit + 1 == $stones[$n-1]) {
                        return true;
                    }
                    if (!in_array($unit + 1, $dp[$stones[$i] + $unit + 1])) $dp[$stones[$i] + $unit + 1][] =  $unit + 1;
                }
            }
        }
        
        return false;
    }
}
