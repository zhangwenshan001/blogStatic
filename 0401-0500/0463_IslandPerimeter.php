<?php

class Solution {

    private $marked = [];
    private $grid;
    private $res = 0;
    private $m;
    private $n;
    
    /**
     * @param Integer[][] $grid
     * @return Integer
     */
    function islandPerimeter($grid) {
        if (count($grid) == 0) {
            return 0;
        }
        $this->grid = $grid;
        $this->m = count($grid);
        $this->n = count($grid[0]);
        
        for($i = 0;$i<$this->m;$i++) {
            for($j = 0;$j<$this->n;$j++) {
                
                if (!isset($this->marked[$i][$j]) && $this->grid[$i][$j] == 1) {
                    $this->dfs($i, $j);
                }
            }
        }
        
        return $this->res;
    }
    
    function dfs($i, $j) {
        if ($i < 0 || $i >= $this->m || $j < 0 || $j >= $this->n) {
            return;
        }
        if (isset($this->marked[$i][$j]) || $this->grid[$i][$j] == 0) {
            return;
        }
        
        
        $this->marked[$i][$j] = 1;
        if ($i == 0 || $this->grid[$i-1][$j] == 0) {
            $this->res++;
        }
        if ($i == $this->m-1 || $this->grid[$i+1][$j] == 0) {
            $this->res++;
        }
        if ($j == 0 || $this->grid[$i][$j-1] == 0) {
            $this->res++;
        }
        if ($j == $this->n-1 || $this->grid[$i][$j+1] == 0) {
            $this->res++;
        }
        
        $this->dfs($i-1, $j);
        $this->dfs($i+1, $j);
        $this->dfs($i, $j-1);
        $this->dfs($i, $j+1);
        
    }
}
