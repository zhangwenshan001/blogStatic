<?php
class Solution {

    /**
     * @param String $s
     * @return String
     */
    function reverseWords($s) {
        $end = 0;
        $slen = strlen($s);
        $strArr = [];
        while($end < $slen) {
            $start = $end;
            while($start < $slen && $s[$start] == ' ') {
                $start++;
            }
            $end=$start;
            while($s[$end] != ' ' && $end < $slen) {
                $end++;
            }
            if ($start != $end) {
                 array_unshift($strArr, substr($s, $start, $end-$start));
            }
        }
        return implode(' ', $strArr);
    }
    
    function reverseWordsRange($s, $start, $end) {
        for($i = $start, $j = $end;$i < $j;$i++,$j--) {
            $tmp = $s[$i];
            $s[$i] = $s[$j];
            $s[$j] = $tmp;
        }
        return $s;
    }
}
