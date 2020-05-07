<?php

class Solution {
    private $adj;
    private $marked = [];
    private $color = [];

    /**
     * @param Integer[][] $graph
     * @return Boolean
     */
    function isBipartite($graph) {
        $n = count($graph);
        $this->adj = $graph;

        for($i = 0;$i<$n;$i++) {
            if (!$this->marked[$i]) {
                $this->color[$i] = true;
                $res = $this->dfs($i);
                if (!$res) {
                    return false;
                }
            }
        }
        return true;
    }

    function dfs($i) {
        $this->marked[$i] = true;

        foreach($this->adj[$i] as $w) {
            if (!$this->marked[$w]) {
                $this->color[$w] = !$this->color[$i];
                $res = $this->dfs($w);
                if (!$res) {
                    return false;
                }
            } else {
                if ($this->color[$i] == $this->color[$w]) {
                    return false;
                }
            }
        }
        return true;
    }
}