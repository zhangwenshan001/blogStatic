<?php

class RomanToInt {

    /**
     * 罗马字母转换成整数
     * note：字母值顺序大->小直接+ 逆序则-
     *
     * @param String $s
     *
     * @return Integer
     */
    function getRomanInt($s)
    {
        if (!$s) {
            return 0;
        }

        $map = [
            'I' => 1,
            'V' => 5,
            'X' => 10,
            'L' => 50,
            'C' => 100,
            'D' => 500,
            'M' => 1000,
        ];

        $slen = strlen($s);
        $num = 0;
        for ($i = 0;$i < $slen-1;$i++) {
            if ($map[$s[$i]] >= $map[$s[$i+1]]) {
                $num = $num + $map[$s[$i]];
            } else {
              $num = $num  - $map[$s[$i]];
            }
        }

        $num = $num + $map[$s[$slen-1]];
        return $num;
    }
}
