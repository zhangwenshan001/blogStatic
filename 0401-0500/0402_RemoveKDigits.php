<?php

class Solution {

    /**
     * @param String $num
     * @param Integer $k
     * @return String
     */
    function removeKdigits($num, $k) {
        if (strlen($num) <= $k) {
            return "0";
        }
        
        $res=[];
        
        $n = strlen($num);
        for($i = 0;$i<$n;$i++){
            while(!empty($res) && end($res) > $num[$i] && $k > 0) {
                array_pop($res);
                $k--;
                if ($k == 0) {
                    break;
                }
            }
            
            array_push($res, $num[$i]);
        }
        
        $i = 0;
        $l = count($res);
        for(;$i<$l;$i++) {
            if ($res[$i] != "0") {
                break;
            }
        }
        if ($i == $l) {
            return "0";
        }
        return substr(implode("", $res), $i, $l-$k-$i);
    }
}
