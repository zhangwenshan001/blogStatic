<?php

class Solution {

    /**
     * @param String[] $strs
     * @return String[][]
     */
    function groupAnagrams($strs) {
         if (!$strs) {
            return [];
        }

        $strsMap = [];

        foreach ($strs as $item) {
            $strArray = str_split($item);
            $chMap    = [];
            foreach ($strArray as $ch) {
                if (isset($chMap[ord($ch) - ord('a')])) {
                    $chMap[ord($ch) - ord('a')]++;
                } else {
                    $chMap[ord($ch) - ord('a')] = 1;
                }
            }
            $key = '';
            for ($i = 0; $i < 26; $i++) {
               if (isset($chMap[$i])) {
                    $key = $key . '#' . $chMap[$i];
                } else {
                    $key = $key . '#' . '0';
                }
            }

            if (key_exists($key, $strsMap)) {
                array_push($strsMap[$key], $item);
            } else {
                $strsMap[$key][] = $item;
            }
        }

        return array_values($strsMap);
    }
}
