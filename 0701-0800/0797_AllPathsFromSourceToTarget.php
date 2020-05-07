<?php

class Solution {
    private $stack;
    private $res;
    private $marked;
    private $n;
    private $adj;

    /**
     * @param Integer[][] $graph
     * @return Integer[][]
     */
    function allPathsSourceTarget($graph) {
        $this->res = [];
        $this->stack = [];
        $this->n = count($graph);
        $this->marked = array_fill(0,$n, false);
        
        $this->adj = $graph;
        $this->dfs(0);
        
        return $this->res;
    }
    
    function dfs($v) {
        if ($this->marked[$v]) {
            return;
        }
        
        $this->marked[$v] = true;
        $this->stack[] = $v;
        if ($v == $this->n-1) {
            $this->res[] = $this->stack;
        } else {
            foreach($this->adj[$v] as $w) {
                $this->dfs($w);
            }
        }
        
        array_pop($this->stack);
        $this->marked[$v] = false;
        return;
    }
}
