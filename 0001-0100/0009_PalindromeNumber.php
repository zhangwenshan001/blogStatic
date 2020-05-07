<?php

class PalindromeNumber {

    /**
     * 是否是回文整数
     *
     * @param Integer $x
     *
     * @return Boolean
     */
    function isPalindrome($x)
    {
        if ($x < 0) {
            return false;
        }

        $numArray = [];
        while ($x) {
            $numArray[] = $x % 10;
            $x          = intval($x / 10);
        }

        if (empty($numArray)) {
            return true;
        }
        $arrayCount = count($numArray);
        $result     = true;
        for ($i = 0; $i < intval($arrayCount / 2); $i++) {
            if ($numArray[$i] != $numArray[$arrayCount - $i - 1]) {
                $result = false;
                break;
            }
        }

        return $result;
    }
}

