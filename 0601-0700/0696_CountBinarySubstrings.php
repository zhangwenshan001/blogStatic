<?php
class Solution {

    //all the 0's and all the 1's in these substrings are grouped consecutively
    function countBinarySubstrings($s) {
        $slen = strlen($s);
        
        if($slen == 0) {
            return 1;
        }
        
        if ($slen ==1) {
            return 0;
        }
        
        $total = 0;
        $pre = 0;
        $cur = 0;
        $i = 0;
        while(true) { 
            while($i==0 || $s[$i] == $s[$i-1] && $i<$slen) {
                $i++;
                $cur++;
            }
            
            $total += min($pre, $cur);
            $pre = $cur;
            $cur = 1;
            
            if ($i == $slen) {
                break;
            }
            
            $i++;
    
        }

        return $total;
    }
    /**
     * @param String $s
     * @return Integer
     */
    function countBinarySubstringsTest($s) {
        $slen = strlen($s);
        if ($slen == 0) {
            return 1;
        }
        
        $count = 0;
        $tmp = [];
        $tmp[0] = 1;
        
       
        $c = 0;
        for($i = 0;$i<$slen;$i++) {
            if ($s[$i] == '0') {
                $c--;
            } else {
                $c++;
            }
            
            if (!isset($tmp[$c])) {
                $tmp[$c] = 1;
            } else {
                $count += $tmp[$c]++;
            }
        }
        
        return $count;
        
    }
}
