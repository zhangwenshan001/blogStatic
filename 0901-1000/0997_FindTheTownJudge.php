<?php

class Solution {

    /**
     * @param Integer $N
     * @param Integer[][] $trust
     * @return Integer
     */
    function findJudge($N, $trust) {
        if ($N == 1) {
            return $N;
        }
        $trusted = [];
        $trusting = [];
        for($i = 0;$i<count($trust);$i++) {
            if (!empty($trusted[$trust[$i][1]])) {
                $trusted[$trust[$i][1]]++;
            }
            else {
                $trusted[$trust[$i][1]] = 1;
            }
            
            $trusting[$trust[$i][0]] = 1;
        }
      
        for($i = 1;$i<=$N;$i++) {  
            if (!empty($trusted[$i]) && $trusted[$i] == $N-1 && empty($trusting[$i])) {
                return $i;
            }
        }
        
        return -1;
    }
}
