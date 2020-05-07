<?php
class Solution {

    /**
     * @param Integer[] $citations
     * @return Integer
     */
    function hIndex($citations) {
        $n = count($citations);
        sort($citations);
        
        if (count($citations) == 0) {
            return 0;
        }  
        
        for($i = $n-1;$i>0;$i--) {
            $leNumCount = $n - $i;
            if ($citations[$i]>= $leNumCount && $citations[$i-1] <= $leNumCount) {
                 return $leNumCount;
            }
        }
        
        return $citations[0] >= $n ? $n : 0;
    }
}
