<?php

class Solution {
    /**
     * @param Integer $n
     * @param Integer[][] $edges
     * @param Float[] $succProb
     * @param Integer $start
     * @param Integer $end
     * @return Float
     */
    function maxProbability($n, $edges, $succProb, $start, $end) {
        $c = count($edges);
        $map = array_fill(0, $n, []);
        for($i =0;$i<$c;$i++) {
            $edge = $edges[$i];
            $map[$edge[0]][] = [$edge[1], $succProb[$i]];
            $map[$edge[1]][] = [$edge[0], $succProb[$i]];
        }
    
        $probs = array_fill(0, $n, 0);
        $queue = [];
        $queue[] = [$start, 1.0];
        $probs[$start]=1;
        
        while(count($queue) != 0) {
            $cur = $queue[0];
            foreach($map[$cur[0]] as $child) {
                if ($probs[$child[0]] >= $cur[1] * $child[1]) {
                    continue;
                } 
                $queue[] = [$child[0], $cur[1] * $child[1]];
                $probs[$child[0]] = $cur[1] * $child[1];
            }
            array_shift($queue);
        }
        
        return $probs[$end];
    }
}
