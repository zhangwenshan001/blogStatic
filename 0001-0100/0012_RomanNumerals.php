<?php

class RomanNumerals
{

    /**
     * @param Integer $num
     *
     * @return String
     */
    function intToRoman($num)
    {
        if ($num < 1 || $num > 3999) {
            return '';
        }

        $sNum = intval($num /1000);
        $hNum = intval($num / 100) % 10;
        $tNum = intval($num / 10) % 10;
        $oNum = $num % 10;

        $result = '';
        $result = $result . $this->getRoman($sNum,4);
        $result = $result . $this->getRoman($hNum,3);
        $result = $result . $this->getRoman($tNum,2);
        $result = $result . $this->getRoman($oNum,1);

        return $result;

    }

    function getRoman($num, $pos) {
        $map = [
            1 => ['I', 'V'],
            2 => ['X', 'L'],
            3 => ['C', 'D'],
            4 => ['M'],
        ];

        if ($num == 9) {
            return $map[$pos][0] . $map[$pos+1][0];
        }
        if ($num >= 5) {
            return $map[$pos][1] . str_repeat($map[$pos][0], $num-5);
        }
        if ($num == 4) {
            return $map[$pos][0].$map[$pos][1];
        }
        if ($num < 4) {
            return str_repeat($map[$pos][0], $num);
        }
    }
}

