<?php

class Solution {

    private $board;
    private $m;
    private $n;
    /**
     * @param String[][] $board
     * @param Integer[] $click
     * @return String[][]
     */
    function updateBoard($board, $click) {
        $this->board = $board;
        $this->m = count($board);
        $this->n = count(current($board));
        
        if($this->board[$click[0]][$click[1]] == 'M') {
            $this->board[$click[0]][$click[1]] = 'X';
            return $this->board;
        }
    
        $this->dfs($click[0], $click[1]);
        return $this->board;
    }
    
    function dfs($x, $y) {
        if ($this->board[$x][$y] != 'E') {
            return;
        }
    
        $mineCount = 0;
        for($i = -1;$i<=1;$i++) {
            for($j = -1;$j<=1;$j++) {
                if ($i==0 && $j == 0) {
                    continue;
                }
                if ($x + $i >= 0 && $x + $i < $this->m && $y + $j >=0 && $y+$j < $this->n) {
                    $minCount += ($this->board[$x+$i][$y+$j] == 'M') ? 1 : 0;
                }
            }
        }
        
        if ($minCount > 0) {
            $this->board[$x][$y] = (String) $minCount;
        }
        else {
            $this->board[$x][$y] = 'B';
            for($i = -1;$i<=1;$i++) {
                for($j = -1;$j<=1;$j++) {
                    if ($i==0 && $j == 0) {
                        continue;
                    }
                    if ($x + $i >= 0 && $x + $i < $this->m && $y + $j >=0 && $y+$j < $this->n) {
                        $this->dfs($x + $i, $y + $j);
                    }
                }
            }
        }
        
        return;
    }
}
