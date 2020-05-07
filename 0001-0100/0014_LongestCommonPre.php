<?php

class LongestCommonPre {
    /**
     * @param String[] $strs
     *
     * @return String
     */
    function longestCommonPrefix($strs)
    {
        $arrayCount = count($strs);
        if ($arrayCount == 0) {
            return '';
        }
        if ($arrayCount == 1) {
            return $strs[0];
        }

        $minLen = PHP_INT_MAX;
        foreach ($strs as $str) {
            $strlen = strlen($str);
            if ($strlen < $minLen) {
                $minLen = $strlen;
            }
        }

        $i = 0;
        $pre = '';
        while ($i < $minLen) {
            $char = $strs[0][$i]; //第一个字符串的第i个字符
            for ($j = 1; $j < $arrayCount; $j++) {
                if ($strs[$j][$i] != $char) {
                    return $pre;
                }
            }
            $pre = $pre . $char;
            $i++;
        }

        return $pre;
    }
}

echo (new LongestCommonPre())->longestCommonPrefix(["flower","flow","flight"]);