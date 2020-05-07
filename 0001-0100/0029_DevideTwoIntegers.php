<?php

class DevideTwoIntegers
{
    /**
     * @param Integer $dividend
     * @param Integer $divisor
     *
     * @return Integer
     */
    function divide($dividend, $divisor)
    {
        if (!$divisor) {
            return;
        }

        if (!$dividend) {
            return 0;
        }

        if ($divisor == 1) {
            return $dividend;
        }
        if ($divisor == -1) {
            return ($dividend == -2147483648) ? 2147483647 : -$dividend;
        }

        $flag     = ($dividend > 0 && $divisor > 0 || $dividend < 0 && $divisor < 0) ? 1 : -1;
        $dividend = $dividend > 0 ? $dividend : -$dividend;
        $divisor  = $divisor > 0 ? $divisor : -$divisor;


        $i = 0;
        while ($dividend - $divisor >= 0) {
            $dividend = $dividend - $divisor;
            $i++;
        }

        return $flag * $i;
    }
}

