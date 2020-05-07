<?php

class Solution {

    /**
     * @param String $word1
     * @param String $word2
     * @return Integer
     */
    function minDistance($word1, $word2) {
       if (empty($word1)) {
            return strlen($word2);
        }

        if (empty($word2)) {
            return strlen($word1);
        }

        $slen1 = strlen($word1);
        $slen2 = strlen($word2);

        $distance = array_pad([], $slen1, array_pad([], $slen2, 0));

        $distance[0][0] = ($word1[0] == $word2[0]) ? 0 : 1;
        for ($i = 1; $i < $slen1; $i++) {
            $distance[$i][0] = min(($word1[$i] == $word2[0]) ? $i : $i + 1, $distance[$i - 1][0] + 1);
        }

        for ($j = 1; $j < $slen2; $j++) {
            $distance[0][$j] = min(
                ($word1[0] == $word2[$j]) ? $j : $j + 1, 
                $distance[0][$j - 1] + 1
            );
        }


        for ($i = 1; $i < $slen1; $i++) {
            for ($j = 1; $j < $slen2; $j++) {
                $distance[$i][$j] = min(
                    $distance[$i - 1][$j] + 1,  
                    $distance[$i][$j - 1] + 1,  
                    (($word1[$i] == $word2[$j]) ? $distance[$i-1][$j-1] : $distance[$i-1][$j-1] + 1)  
                );

            }
        }

        return $distance[$slen1 - 1][$slen2 - 1];
    }
}
