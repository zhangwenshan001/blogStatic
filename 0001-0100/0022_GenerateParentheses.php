<?php

class Solution {

    /**
     * @param Integer $n
     * @return String[]
     */
    function generateParenthesis($n) {
        if (!$n) {
            return [];
        }

        $resultTmp    = [];
        $flagTmp      = [];
        $leftTotalTmp = [];


        for ($i = 0; $i < 2 * $n; $i++) {

            $result    = [];
            $flag      = [];
            $leftTotal = [];

            if (empty($resultTmp)) {
                $resultTmp[]    = '(';
                $flagTmp[]      = 1;
                $leftTotalTmp[] = 1;
                continue;
            }

            foreach ($resultTmp as $key => $value) {
                if ($flagTmp[$key] > 0 && $flagTmp[$key] < $n && $leftTotalTmp[$key] < $n) {
                    $result[]    = $value . '(';
                    $flag[]      = $flagTmp[$key] + 1;
                    $leftTotal[] = $leftTotalTmp[$key] + 1;
                    $result[]    = $value . ')';
                    $flag[]      = $flagTmp[$key] - 1;
                    $leftTotal[] = $leftTotalTmp[$key];
                } elseif ($flagTmp[$key] == 0) {
                    $result[]    = $value . '(';
                    $flag[]      = $flagTmp[$key] + 1;
                    $leftTotal[] = $leftTotalTmp[$key] + 1;
                } else {
                    $result[] = $value . ')';
                    $flag[]   = $flagTmp[$key] - 1;
                    $leftTotal[] = $leftTotalTmp[$key];
                }
            }

            $resultTmp = $result;
            $flagTmp   = $flag;
            $leftTotalTmp = $leftTotal;
        }

        return $resultTmp;
    }
}
