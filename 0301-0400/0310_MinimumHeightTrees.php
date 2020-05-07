<?php

class Solution {

    /**
     * @param Integer $n
     * @param Integer[][] $edges
     * @return Integer[]
     */
    function findMinHeightTrees($n, $edges) {
        if ($n == 1) {
            return [0];
        }
        $adjLinks = array_fill(0, $n, []);
        foreach($edges as $edge) {
            $adjLinks[$edge[0]][] = $edge[1];
            $adjLinks[$edge[1]][] = $edge[0];
        }        
        
        
        $leaves = [];
        foreach($adjLinks as $key => $adjLink) {
            if (count($adjLink) == 1) {
                $leaves[] = $key;
            }
        }
        while($n > 2) {
            $n -= count($leaves);
            $newLeaves = [];
            foreach($leaves as $leave) {
                $adjLinks[$adjLinks[$leave][0]] = array_values(array_diff($adjLinks[$adjLinks[$leave][0]], [$leave]));
                if(count($adjLinks[$adjLinks[$leave][0]]) ==1) {
                    $newLeaves[] = $adjLinks[$leave][0];
                }
                unset($adjLinks[$leave]);
                
            }
            $leaves = $newLeaves;
        }
        
        return $leaves;
    }
}
