<?php

class Solution {

    /**
     * @param String $s
     * @param Integer $k
     * @return Integer
     */
    function longestSubstring($s, $k) {    
        $max = 0;
        $slen = strlen($s);
        
        for($h = 1;$h<=26;$h++) {
            $counter = array_fill(0,0,26);
            $i = 0;
            $j = 0;
            $eltk = 0;
            $uniq = 0;
            while($j < $slen) {
                if ($uniq <= $h) {
                    $idx = ord($s[$j]) - ord('a');
                    if ($counter[$idx] == 0) {
                        $uniq++;
                    } 
                    $counter[$idx]++;
                    if ($counter[$idx] == $k) {
                        $eltk++;
                    }
                    $j++;
                } else {
                    $idx = ord($s[$i]) - ord('a');
                    if ($counter[$idx] == $k) {
                        $eltk--;
                    }
                    $counter[$idx]--;
                    if ($counter[$idx] == 0) {
                        $uniq--;
                    } 
                    $i++;
                }
                
                if ($uniq == $h && $eltk == $h) {
                    $max = max($j-$i, $max);
                }
            }
        }
        
        return $max;
    }
}
