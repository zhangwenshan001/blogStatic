<?php

class Solution {

    /**
     * @param Integer[][] $mat
     * @return Integer
     */
    function numSubmat($mat) {
        $m = count($mat);
        if ($m == 0) {
            return 0;
        }
        $n = count($mat[0]);
        
        $res = 0;
        for($up =0;$up<$m;$up++) {
            $h = array_fill(0, $n, 1);
            for($down = $up;$down<$m;$down++) {
                for($j = 0;$j<$n;$j++) {
                    $h[$j] = $h[$j] & $mat[$down][$j];
                }
                
                $res += $this->countOneRow($h);
            }
        }
        return $res;
    }
    
    function countOneRow($h) {
        $res = 0;
        $length = 0;
        $n = count($h);
        for($i =0;$i<$n;$i++) {
            $length = ($h[$i] == 0)? 0 : $length+1;
            $res = $res + $length;
        }
        
        return $res;
    }
}
