<?php

class StrToInt {

    /**
     * 字符串转化成整数，超出范围后输出最大最小整数
     *
     * @param String $str
     *
     * @return Integer
     */
    function myAtoi($str)
    {
        $maxIntStr = '2147483647'; //最大正数
        $minIntStr = '2147483648'; //最小负数
        if (!$str) {
            return 0;
        }

        $strLen = strlen($str);

        //有效字符串第一个位置
        $i = 0;
        while ($str[$i] == ' ' && $i < $strLen) {
            $i++;
        }

        $flag = 1;
        if ($str[$i] == '+' || $str[$i] == '-') {
            $flag = $str[$i] == '+' ? 1 : -1;
            $i++;
        }
        $j = $i;
        while ($str[$j] >= '0' && $str[$j] <= '9') {
            $j++;
        }
        $numStr = substr($str, $i, $j-$i);
        if (($flag == 1 && $numStr > $maxIntStr) || ($flag == -1 && $numStr > $minIntStr)) {
            $numStr = ($flag == 1) ? $maxIntStr : $minIntStr;
        }

        $Numlen = strlen($numStr);
        $result = 0;
        for ($i = 0; $i < $Numlen; $i++) {
            $result = 10 * $result + $flag * ($numStr[$i] - '0');
        }

        return $result;
    }
}

