<?php

class Solution {

    /**
     * @param Integer[][] $coordinates
     * @return Boolean
     */
    function checkStraightLine($coordinates) {
        if(empty($coordinates) || count($coordinates) <= 1) {
            return false;
        }
    
        if (count($coordinates) == 2) {
            return true;
        }
        
        $dx = $coordinates[1][0] - $coordinates[0][0];
        $dy = $coordinates[1][1] - $coordinates[0][1];

        for($i = 1+1;$i<count($coordinates);$i++) {
            $curDx = $coordinates[$i][0] -  $coordinates[$i-1][0];
            $curDy =  $coordinates[$i][1] -  $coordinates[$i-1][1];
            
            if ($dy * $curDx != $dx * $curDy) {
                return false;
            }
        }
        
        return true;
    }
}
