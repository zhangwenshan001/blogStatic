<?php

class ReverseInt {

    /**
     * 整数翻转，超过最大最小整数时，返回0
     *
     * @param Integer $x
     *
     * @return Integer
     */
    function reverse($x)
    {
        if (!$x) {
            return 0;
        }

        $result = 0;
        while ($x) {
            $result = $result * 10 + ($x % 10);
            if ($result > 2147483647 || $result < -2147483648) {
                return 0;
            }
            $x = intval($x / 10);
        }


        return $result;
    }

}

