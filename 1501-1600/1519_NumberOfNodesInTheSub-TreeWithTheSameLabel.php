<?php
class Solution {
    private $subs = [];
    private $labels;
    private $dp = [];
    private $res = [];
    private $marked = [];
    
    /**
     * @param Integer $n
     * @param Integer[][] $edges
     * @param String $labels
     * @return Integer[]
     */
    function countSubTrees($n, $edges, $labels) {
        $this->labels = $labels;
        $this->subs = array_fill(0, $n, []);
        $this->res =  array_fill(0, $n, 0);
        $this->marked = array_fill(0, $n, false);
        foreach($edges as $edge) {
            $this->subs[$edge[0]][] = $edge[1];
            $this->subs[$edge[1]][] = $edge[0];
        }
        $this->handle(0);
        return $this->res;
    }
  
    
    function handle($v) {
        $this->marked[$v] = true;
        $curChar = $this->labels[$v];
        $childNum = count($this->subs[$v]);
        
        $map = [$curChar => 1];
        if($childNum == 0) {
            $this->res[$v] = 1;
            return $map;
        } 
        
        for($i = 0;$i<$childNum;$i++) {
            $sub = $this->subs[$v][$i];
            if($this->marked[$sub]) {
                continue;
            }
            $subMap = $this->handle($sub);
            foreach($map as $key => $value) {
                if (isset($subMap[$key])) {
                    $map[$key] = $value + $subMap[$key];
                }
            }
            foreach($subMap as $key => $value) {
                if (!isset($map[$key])) {
                    $map[$key] = $value;
                }
            }
        }
        $this->res[$v] = $map[$curChar];  
        return $map;
    }
}
