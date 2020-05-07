<?php

class Solution {

    /**
     * @param Integer $numBottles
     * @param Integer $numExchange
     * @return Integer
     */
    function numWaterBottles($numBottles, $numExchange) {
        $res = $numBottles;
        while($numBottles >= $numExchange) {
            $res += (int) ($numBottles / $numExchange);
            $numBottles = (int) ($numBottles / $numExchange) + $numBottles % $numExchange;
        }
        return $res;
    }
}
