<?php

class Solution {

    /**
     * @param String $s
     * @return String
     */
    function frequencySort($s) {
        $len = strlen($s);
        $static = [];
        for($i=0;$i<$len;$i++) {
            if (empty($static[$s[$i]])) {
                $static[$s[$i]] = 1; 
            }else {
                $static[$s[$i]]++; 
            }    
        }
        
        asort($static);
        $count = count($static);
        $res = '';
        foreach($static as $key => $value) {
            $res = str_pad("", $value, $key) . $res;
        }
        
        return $res;
        
    }
}
