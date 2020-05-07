<?php

class ZigZag {

    /**
     * @param String  $s
     * @param Integer $numRows
     *
     * @return String
     */
    function convert($s, $numRows)
    {
        if (!$s || !$numRows || $numRows == 1) {
            return $s;
        }

        $strLen = strlen($s);
        $k      = 2 * $numRows - 2;

        $resultStr = '';
        for ($row = 0; $row < $numRows; $row++) {
            if ($row == 0 || $row == $numRows - 1) {
                $t = 0;
                while ($t * $k + $row < $strLen) {
                    $resultStr = $resultStr . $s[$t * $k + $row];
                    $t++;
                }
            } else {
                $t = 0;
                while ($t * $k + $row < $strLen) {
                    $resultStr = $resultStr . $s[$t * $k + $row];
                    if ($t * $k + 2 * $numRows - $row - 1 <= $strLen) {
                        $resultStr = $resultStr . $s[$t*$k + 2*$numRows - $row - 2];
                    }
                    $t++;
                }
            }
        }
        return $resultStr;
    }
}

