<?php

class Solution {

    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function maxProductPath($grid) {
        $n = count($grid);
        if ($n == 0) {
            return 0;
        }
        $m = count($grid[0]);
        
        $flag = false;
        
        $dp = [];
        for($j = 0;$j<$m;$j++) {
            if ($j == 0) {
                $dp[0][0] = $grid[0][0] < 0 ? [null, $grid[0][0]] : [$grid[0][0], null];
            } else {
                if ($grid[0][$j] == 0) {
                    $flag = true;
                    $neg = null;
                    $pos = 0;
                } else if ($grid[0][$j] < 0) {
                    $neg = ($dp[0][$j-1][0] != null && $dp[0][$j-1][0] != 0) ?$dp[0][$j-1][0] * $grid[0][$j] : null;
                    $pos = $dp[0][$j-1][1] != null ? $dp[0][$j-1][1] * $grid[0][$j]   : null; 
                   
                } else {
                    $neg = $dp[0][$j-1][1] != null ? $dp[0][$j-1][1] * $grid[0][$j]  : null;
                    $pos = $dp[0][$j-1][0] != null ? $dp[0][$j-1][0] * $grid[0][$j]  : null;
                }
                if (!$pos && $dp[0][$j-1][0] === 0) {
                    $pos = 0;
                }
                $dp[0][$j] = [$pos, $neg];
            }
            
        }
        for($i = 1;$i<$n;$i++) {
            for($j =0;$j<$m;$j++) {
                if ($j == 0) {
                    if ($grid[$i][$j] == 0) {
                        $flag = true;
                        $neg = null;
                        $pos = 0;
                    } else if ($grid[$i][0] < 0) {          
                        $pos = $dp[$i-1][0][1] != null ? $dp[$i-1][0][1] * $grid[$i][0]  : null;
                        $neg = ($dp[$i-1][0][0] != null && $dp[$i-1][0][0] != 0)?$dp[$i-1][0][0]*$grid[$i][0] :null;
                    } else {
                        $neg = $dp[$i-1][0][1] != null ? $dp[$i-1][0][1] * $grid[$i][0] : null;
                        $pos = $dp[$i-1][0][0] != null ? $dp[$i-1][0][0] * $grid[$i][0] : null;                   
                    }
                    if (!$pos && $dp[$i-1][0][0] === 0) {
                        $pos = 0;
                    }
                    $dp[$i][0] = [$pos, $neg];
                } else {
                    if ($grid[$i][$j] === 0) {
                        $flag = true;
                        $neg = null;
                        $pos = 0;
                    } else {
                        if ($grid[$i][$j] < 0) {     
                            $pos1 = $dp[$i-1][$j][1] != null ?   $dp[$i-1][$j][1] * $grid[$i][$j] : null;
                            $pos2 = $dp[$i][$j-1][1] != null ?   $dp[$i][$j-1][1] * $grid[$i][$j] : null;
                            $neg1=($dp[$i-1][$j][0]!=null&&$dp[$i-1][$j][0]!=0)?$dp[$i-1][$j][0]*$grid[$i][$j]: null;
                            $neg2=($dp[$i][$j-1][0]!=null&&$dp[$i][$j-1][0]!=0)?$dp[$i][$j-1][0]*$grid[$i][$j]: null;
                        } else {
                            $neg1 = $dp[$i-1][$j][1] != null ?   $dp[$i-1][$j][1] * $grid[$i][$j] : null;
                            $neg2 = $dp[$i][$j-1][1] != null ?   $dp[$i][$j-1][1] * $grid[$i][$j]: null;
                            $pos1 = $dp[$i-1][$j][0] != null ?   $dp[$i-1][$j][0] * $grid[$i][$j] : null;
                            $pos2 = $dp[$i][$j-1][0] != null ?   $dp[$i][$j-1][0] * $grid[$i][$j] : null;
                        }
                    
                        if (!$pos1 && $dp[$i-1][$j][0] == 0) {
                            $pos1 = 0;
                        }
                        if (!$pos2 && $dp[$i][$j-1][0] == 0) {
                            $pos2 = 0;
                        }
                        $pos = ($pos1 != null && $pos2 != null) ? max($pos1, $pos2) : (($pos1 == null) ? $pos2 : $pos1);
                        $neg = ($neg1 != null && $neg2 != null) ? min($neg1, $neg2) : (($neg1 == null) ? $neg2 : $neg1);
                    }
                    
                    $dp[$i][$j] = [$pos, $neg];
                }
            }
        }
       
        return $dp[$n-1][$m-1][0] !== null ? $dp[$n-1][$m-1][0] % 1000000007 : ($flag ? 0 : -1);
    }
}