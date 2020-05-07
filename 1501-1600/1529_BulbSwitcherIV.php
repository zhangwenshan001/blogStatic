<?php

class Solution {

    /**
     * @param String $target
     * @return Integer
     */
    function minFlips($target) {
        $n = strlen($target);
        $i = 0;
        while($target[$i] == '0'){
            $i++;
        }
        if($i == $n) {
            return 0;
        }
        $c = 1;
        $flag = true;
        while($i<$n) {
            if ($flag && $target[$i] == '0' || !$flag && $target[$i] == '1') {
                $flag = !$flag;
                $c++;
            }
            $i++;
        }
        
        return $c;
    }
}
