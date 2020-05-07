<?php

class Solution {

    /**
     * @param Integer[][] $books
     * @param Integer $shelf_width
     * @return Integer
     */
    function minHeightShelves($books, $shelf_width) {
        $dp = [];
        
        $dp[0] = 0;
        
        for($i = 1;$i <= count($books);$i++) {
            $width = $books[$i-1][0];
            $height = $books[$i-1][1];
            $dp[$i] = $dp[$i-1] + $height;
            
            for($j = $i-1;$j>0 &&$width + $books[$j-1][0] <=$shelf_width; $j--) {
                $height = max($height, $books[$j-1][1]);
                $width = $width + $books[$j-1][0];
                $dp[$i] = min($dp[$i], $dp[$j-1] + $height);
            }
        }
        
        return $dp[count($books)];
    }
}
