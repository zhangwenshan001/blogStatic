<?php

class Solution {

    /**
     * @param Integer $num
     * @return Integer
     */
    function addDigits($num) {
         return 1 + ($num - 1) % 9;
    }
}
