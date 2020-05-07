<?php

class Solution {

    private $g;
    private $n;
    
    /**
     * @param String[] $grid
     * @return Integer
     */
    function regionsBySlashes($grid) {
        $n = count($grid);
        $g = array_fill(0, $n * 3, array_fill(0, $n*3, 0));
        
        for($i = 0;$i< $n;$i++) {
            for($j = 0;$j<$n;$j++) {
                if ($grid[$i][$j] == '/') {
                    $g[$i*3][$j*3+2] = 1;
                    $g[$i*3+1][$j*3+1] = 1;
                    $g[$i*3+2][$j*3] = 1;
                } else if ($grid[$i][$j] == '\\') {
                    $g[$i*3][$j*3] = 1;
                    $g[$i*3+1][$j*3+1] = 1;
                    $g[$i*3+2][$j*3+2] = 1;
                }
            }
        }
        
        $this->g = $g;
        $this->n = $n;
        
        $c = 0;
        for($i = 0;$i<3*$n;$i++) {
            for($j = 0;$j<3*$n;$j++) {
                if ($this->g[$i][$j] == 0) {
                    $this->dfs($i, $j);
                    $c++;
                }       
            }
        }
        return $c;
    }
    function dfs($i, $j) {
        if ($i>= 3 * $this->n || $j>= 3 * $this->n || $i<0 || $j<0) {
            return;
        }
        if ($this->g[$i][$j] != 0) {
            return;
        }
        $this->g[$i][$j] = -1;
        $this->dfs($i-1, $j);
        $this->dfs($i, $j-1);
        $this->dfs($i+1, $j);
        $this->dfs($i, $j+1);
        return;
    }
    
    
}
