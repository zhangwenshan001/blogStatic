<?php
class Solution {

    /**
     * @param Integer $num
     * @return Integer
     */
    function findComplement($num) {
        $numArray = [];
        while($num != 0) {
            array_unshift($numArray, $num % 2 == 0 ? 1 : 0);
            $num = (int) ($num / 2 );
        }
        
        //var_dump($numArray);
        $res = 0;
        foreach ($numArray as $value) {
            $res = $res * 2 + $value;
        } 
        return $res;
    }
}
