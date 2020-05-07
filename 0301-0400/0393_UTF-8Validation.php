<?php

class Solution {

    /**
     * @param Integer[] $data
     * @return Boolean
     */
    function validUtf8($data) {
        $n = count($data);
        
        $i = 0;
        while($i < $n) {
            $cur = $data[$i];
            $oneNums = $this->headOneCounts($cur);
            
            if ($oneNums == 0) {
                $i++;
                continue;
            }
            if ($oneNums == 1 || $oneNums >4) {
                return false;
            }

            if ($i+$oneNums-1 >= $n) {
                return false;
            }
            for($j = $i+1;$j<=$i+$oneNums-1;$j++){
                
                if ($this->headOneCounts($data[$j]) != 1) {
                    return false;
                }
            }
            $i = $i+$oneNums;
        }
        
        return true;
        
    }
    
    
    function headOneCounts($number) {
        if ($number == 255) {
            return 8;
        } else if ($number == 254) {
            return 7;
        } else if ($number >= 252) {
            return 6;
        } else if ($number >= 248) {
            return 5;
        } else if ($number >= 240) {
            return 4;
        } else if ($number >= 224) {
            return 3;
        } else if ($number >= 192) {
            return 2;
        } else if ($number >= 128) {
            return 1;
        }
        
        return 0;
    }
    
}
