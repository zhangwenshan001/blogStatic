<?php

class Solution {

    /**
     * @param Integer $N
     * @param Integer[][] $paths
     * @return Integer[]
     */
    function gardenNoAdj($N, $paths) {
        $linkMap = [];
        foreach($paths as $path) {
            if (empty($linkMap[$path[0]])) {
                $linkMap[$path[0]] = [$path[1]];
            } else {
                $linkMap[$path[0]][] = $path[1];
            }
            
            if (empty($linkMap[$path[1]])) {
                $linkMap[$path[1]] = [$path[0]];
            } else {
                $linkMap[$path[1]][] = $path[0];
            }
        }
        $res = [];
        for($i = 0;$i<$N;$i++) {   
            //var_dump($res);
            if (empty($linkMap[$i+1])) {
                $res[$i] = 1;
                continue;
            }
            $color = [];
            foreach($linkMap[$i+1] as $j) {
                if (!empty($res[$j-1])) {
                    $color[$res[$j-1]] = 1;
                }
            }
            for($c = 1;$c<5;$c++) {
                if (empty($color[$c])) {
                    $res[$i] = $c;
                    break;
                }
            }
        }
        return $res; 
    }
}
