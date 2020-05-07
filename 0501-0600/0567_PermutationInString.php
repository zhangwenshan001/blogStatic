<?php

class Solution {

    /**
     * @param String $s1
     * @param String $s2
     * @return Boolean
     */
    function checkInclusion($s1, $s2) {
        if (strlen($s1) > strlen($s2)) {
            return false;
        }
        $map1 = array_fill(0, 26, 0); //init
        $map2 = array_fill(0, 26, 0);
        $strlen1 = strlen($s1);
        $strlen2 = strlen($s2);
        
        for($i=0;$i<$strlen1;$i++) {
            $index1 = ord($s1[$i]) - ord('a');
            $index2 = ord($s2[$i]) - ord('a');
            $map1[$index1]++;
            $map2[$index2]++;
        }
        
        $count = 0;
        for($i=0;$i<26;$i++) {
            if ($map1[$i] == $map2[$i]) {
                $count++;
            }
        }
        
        if ($count == 26) {
            return true;
        }
        
        for($i = 0;$i<$strlen2 - $strlen1;$i++) {
            $headIndex = ord($s2[$strlen1 + $i]) - ord('a');
            $tailIndex = ord($s2[$i]) - ord('a');
            
            if ($map2[$headIndex] == $map1[$headIndex]) {
                $count--;
            } 
            if ($map2[$tailIndex] == $map1[$tailIndex]) {
                $count--;
            }
            $map2[$headIndex]++;
            $map2[$tailIndex]--;
            if ($map2[$headIndex] == $map1[$headIndex]) {
                $count++;
            }
            if ($map2[$tailIndex] == $map1[$tailIndex]) {
                $count++;
            }
            if ($count==26) {
                return true;
            }
        }
        
        return false;     
    }
}
