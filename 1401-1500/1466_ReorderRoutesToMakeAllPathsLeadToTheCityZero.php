<?php

class Solution {
    private $adj = [];
    private $reAdj = [];

    private $marked = [];
    private $c = 0;
    private $n;

    private $reCount = 0;

    /**
     * @param Integer $n
     * @param Integer[][] $connections
     * @return Integer
     */
    function minReorder($n, $connections) {
        $adj = array_fill(0,$n,[]);
        $reAdj = array_fill(0,$n,[]);
        foreach($connections as $conn) {
            $adj[$conn[0]][] = $conn[1];
            $reAdj[$conn[1]][] = $conn[0];
        }
        $this->n = $n;
        $this->adj = $adj;
        $this->reAdj = $reAdj;

        //$this->dfsRe(0);
        $this->c++;
        $this->marked[0]=true;

        while($this->c != $n) {
            for($i = 0;$i<$n;$i++) {
                if (empty($this->marked[$i])) {
                    continue;
                }
                $this->dfsRe($i);
            }
            for($i = 0;$i<$n;$i++) {
                if (empty($this->marked[$i])) {
                    continue;
                }
                $this->dfs($i);
            }
        }

        return $this->reCount;

    }

    function dfsRe($i) {
        $this->marked[$i] = true;
        foreach($this->reAdj[$i] as $w) {
            if (empty($this->marked[$w])) {
                $this->c++;
                $this->dfsRe($w);
            }
        }
        return;
    }

    function dfs($i) {
        $this->marked[$i] = true;
        foreach($this->adj[$i] as $w) {
            if (empty($this->marked[$w])) {
                $this->c++;
                $this->reCount++;
                $this->dfs($w);
            }
        }
        return;
    }
}