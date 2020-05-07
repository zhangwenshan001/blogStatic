<?php

class Solution {

     private $map = [
        '2' => ['a', 'b', 'c'],
        '3' => ['d', 'e', 'f'],
        '4' => ['g', 'h', 'i'],
        '5' => ['j', 'k', 'l'],
        '6' => ['m', 'n', 'o'],
        '7' => ['p', 'q', 'r', 's'],
        '8' => ['t', 'u', 'v'],
        '9' => ['w', 'x', 'y', 'z'],
    ];
    /**
     * @param String $digits
     * @return String[]
     */
    function letterCombinations($digits) {
        if (!$digits) {
            return [];
        }

        $slen = strlen($digits);
        $num = $digits[0];

        if ($slen == 1) {
            return ($num == '1') ? [] : $this->map[$num];
        }


        $nextResult = $this->letterCombinations(substr($digits, 1, $slen-1));

        if ($num == '1') {
            return $nextResult;
        }

        if (empty($nextResult)) {
            return $this->map[$num];
        }

        $chars = $this->map[$num];
        $result = [];

        foreach ($chars as $char) {
            foreach ($nextResult as $item) {
                $result[] = $char . $item;
            }
        }

        return $result;
    }
}
