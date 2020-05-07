<?php

class Solution {

    /**
     * @param Integer[] $target
     * @param Integer[] $arr
     * @return Boolean
     */
    function canBeEqual($target, $arr) {
        if (count($target) != count($arr)) {
            return false;
        }
        $map = [];
        $c = count($target);
        for($i = 0;$i<$c;$i++) {
            if (empty($map[$target[$i]])) {
                $map[$target[$i]] = 1;
            }else {
                $map[$target[$i]]++;
            }
        }

        for($i=0;$i<$c;$i++) {
            if (empty($map[$arr[$i]])) {
                return false;
            }else {
                $map[$arr[$i]]--;
            }
        }


        return true;

    }
}