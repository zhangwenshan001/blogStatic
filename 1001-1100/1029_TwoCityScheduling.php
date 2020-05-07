<?php

class Solution {
    private $ASum = 0;
    private $BSum = 0;
    private $costs;
    private $n;
    private $aCount=0;
    private $min = PHP_INT_MAX;

    /**
     * @param Integer[][] $costs
     * @return Integer
     */
    function twoCitySchedCost($costs) {
        $total = 0;
        $changeToB = []; 
        foreach($costs as $cost) {
            $total += $cost[0];
            $changeToB[] = $cost[1] - $cost[0];
        }
        sort($changeToB);
        $c = count($costs);
        $res = $total;
        for($i = 0;$i<$c/2;$i++) {
            $res += $changeToB[$i];
        }
        return $res;
    }
}
