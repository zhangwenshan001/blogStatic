<?php

class Solution {

    private $m;
    private $n;
    private $image;
    private $newColor;
    private $oldColor;
    
    /**
     * @param Integer[][] $image
     * @param Integer $sr
     * @param Integer $sc
     * @param Integer $newColor
     * @return Integer[][]
     */
    function floodFill($image, $sr, $sc, $newColor) {
        if (count($image) == 0) {
            return [];
        }
        
        $this->m = count($image);
        $this->n = count(current($image));
        $this->image = $image;
        $this->newColor = $newColor;
        $this->oldColor = $image[$sr][$sc];
        
        $this->dfs($sr, $sc);
        return $this->image;
    }
    
    function dfs($row,$col) {
        if ($this->image[$row][$col] == $this->oldColor) {
            $this->image[$row][$col] = $this->newColor;
        } else {
            return;
        }
        if ($row > 0) {
            $this->dfs($row-1, $col);
        }
        if ($row < $this->m - 1) {
            $this->dfs($row+1, $col);
        }
        if ($col > 0) {
             $this->dfs($row, $col-1);
        }
        if ($col < $this->n - 1) {
             $this->dfs($row, $col+1);
        }
        
        return;
    }
}
