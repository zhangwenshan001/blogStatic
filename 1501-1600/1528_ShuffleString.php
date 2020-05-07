<?php

class Solution {

    /**
     * @param String $s
     * @param Integer[] $indices
     * @return String
     */
    function restoreString($s, $indices) {
        $n = count($indices);
        $afterArr = [];
        for($i = 0;$i<$n;$i++) {
            $afterArr[$indices[$i]] = $s[$i];
        }
        
       
        $afterS = "";
        for($i =0;$i<$n;$i++){
            $afterS .= $afterArr[$i];
        }
        
        return $afterS;
    }
}
