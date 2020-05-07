<?php

class Solution {

    /**
     * @param String $s
     * @param String $t
     * @return String
     */
    function minWindow($s, $t) {
        $chMap = [];

        $tlen = strlen($t);
        for ($i = 0; $i < $tlen; $i++) {
            if (isset($chMap[$t[$i]])) {
                $chMap[$t[$i]]++;
            } else {
                $chMap[$t[$i]] = 1;
            }

        }

        $slen     = strlen($s);
        $start    = 0;
        $end      = 0;
        $minWin   = PHP_INT_MAX;
        $resStart = 0;
        $resEnd   = 0;
        $total    = strlen($t);
        while ($end < $slen) {
            if (isset($chMap[$s[$end]])) {
                if ($chMap[$s[$end]] > 0) {
                    $total--;
                }
                $chMap[$s[$end]]--;
            }

            while ($total == 0) {
                if (isset($chMap[$s[$start]])) {
                    $chMap[$s[$start]]++;
                    if ($chMap[$s[$start]] > 0) {
                        $total++;
                        if ($end - $start + 1 < $minWin) {
                            $resStart = $start;
                            $resEnd   = $end;
                            $minWin   = $end - $start + 1;
                        }
                    }
                }
                $start++;
            }
            $end++;
        }

        if ($minWin > $slen) {
            return "";
        }
        return substr($s, $resStart, $minWin);
    }
}
