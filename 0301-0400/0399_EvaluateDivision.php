<?php

class Solution {

    private $dp = [];
    private $adj = [];
    private $marked = [];
    /**
     * @param String[][] $equations
     * @param Float[] $values
     * @param String[][] $queries
     * @return Float[]
     */
    function calcEquation($equations, $values, $queries) {
        $c = count($equations);
        for($i=0;$i<$c;$i++) {        
            if (empty($this->adj[$equations[$i][0]])) {
                $this->adj[$equations[$i][0]] = [$equations[$i][1]];
            } else {
                $this->adj[$equations[$i][0]][] = $equations[$i][1];
            }
            
            if (empty($this->adj[$equations[$i][1]])) {
                $this->adj[$equations[$i][1]] = [$equations[$i][0]];
            } else {
                $this->adj[$equations[$i][1]][] = $equations[$i][0];
            }
            
            $this->dp[$equations[$i][0]][$equations[$i][1]] = $values[$i];
            $this->dp[$equations[$i][1]][$equations[$i][0]] = 1 / $values[$i];
        }
        
        $res = [];
        
        foreach($queries as $query) {
            if (!isset($this->adj[$query[0]]) || !isset($this->adj[$query[1]])) {
                $res[] = -1; 
                continue; 
            }
            if ($query[0] == $query[1]) { 
                $res[] = 1;
                continue;
            }

            $this->marked = [];
            $res[] = $this->dfs($query[0], $query[1]);
            
        }
        
        return $res;
    }
    
    function dfs($from, $to) {
        if (isset($this->dp[$from][$to])) {
            return $this->dp[$from][$to];
        }
        if (isset($this->dp[$to][$from])) {
            return 1/$this->dp[$to][$from];
        }
        
        $this->marked[$from] = true;
        foreach($this->adj[$from] as $w) {
            if (empty($this->marked[$w]) && $this->dfs($w, $to) != -1) {
                $this->dp[$from][$to] = $this->dp[$from][$w] * $this->dfs($w,$to);
                $this->dp[$to][$from] = 1 / $this->dp[$from][$to];
                return $this->dp[$from][$to];
            }
        }
        
        $this->dp[$from][$to] = -1;
        $this->dp[$to][$from] = -1;
        return $this->dp[$from][$to];
    }
}
