<?php

class Solution {

    private $maxNum = [];
    private $sum = [];
    /**
     * @param Integer[] $arr
     * @return Integer
     */
    function mctFromLeafValues($arr) {
        $res = $this->mctFromLeafValuesHandle($arr, 0, count($arr) - 1);
        return $res;
    }
    
    function mctFromLeafValuesHandle($arr, $start, $end) {
        if(!empty($this->sum[$start][$end])) {
            return $this->sum[$start][$end];
        }
        
        if ($start == $end) {
            $this->maxNum[$start][$end] = $arr[$start];
            $this->sum[$start][$end] = 0;
            return 0;
        }
        if ($start == $end - 1) {
            $this->sum[$start][$end] = $arr[$start] * $arr[$end];
            $this->maxNum[$start][$end] = max($arr[$start], $arr[$end]);
            return $this->sum[$start][$end];
        } 
        
        $min = PHP_INT_MAX;
        for($i = $start;$i<$end;$i++) {
            if ($arr[$i] > $maxNum){
                $maxNum = $arr[$i];
            }  
            $min = min($min, 
                       $this->mctFromLeafValuesHandle($arr, $start, $i) + 
                       $this->mctFromLeafValuesHandle($arr, $i+1, $end) +
                       $this->maxNum[$start][$i] * $this->maxNum[$i+1][$end]
                     );
        }
       
        $this->sum[$start][$end] = $min;
        $this->maxNum[$start][$end] = max($this->maxNum[$start][$start], $this->maxNum[$start+1][$end]);
    
        
        return $min;
    }
}
