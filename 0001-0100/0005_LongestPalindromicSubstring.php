<?php

class LongestPalindromicSubstring {
    /**
     * 最长回文子串
     *
     * @param $s
     *
     * @return bool|string|void
     */
    function getLongestPalindromicSubstring($s)
    {
        if (!$s || strlen($s) == 1) {
            return $s;
        }
        $strLength = strlen($s);

        $maxLength = 0;

        $maxStr = '';
        for ($start = 0; $start < $strLength; $start++) {
            $end = $strLength - 1;

            while ($start < $end) {
                while ($s[$start] != $s[$end]) {
                    $end--;
                }
                $i = 0;
                while ($s[$start + $i] == $s[$end - $i] && $start + $i < $end - $i) {
                    $i++;
                }
                if ($start + $i >= $end - $i) {
                    $count = $end - $start + 1;
                    if ($count > $maxLength) {
                        $maxLength = $count;
                        $maxStr    = substr($s, $start, $count);
                    }
                    break;
                } else {
                    $end--;
                }
            }

        }

        return $maxStr;
    }
}

