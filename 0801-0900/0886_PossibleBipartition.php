<?php

class SolutionDFS {
    private $g;
    private $marked;
    private $color;

    /**
     * @param Integer $N
     * @param Integer[][] $dislikes
     * @return Boolean
     */
    function possibleBipartition($N, $dislikes) {
        if (count($dislikes) <= 1) {
            return true;
        }
        $g = array_fill(0, $N, []);
        foreach($dislikes as $dislike) {
            $g[$dislike[0]-1][] = $dislike[1]-1;
            $g[$dislike[1]-1][] = $dislike[0]-1;
        }

        $this->g = $g;

        $this->marked = array_fill(0, $N, false);
        for($i = 0;$i<$N;$i++) {
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
        $curColor = $this->color[$i];
        foreach($this->g[$i] as $d) {
            if (!$this->marked[$d]) {
                $this->color[$d] = !$curColor;
                if(!$this->dfs($d)) {
                    return false;
                };
            } else if ($this->color[$d] == $curColor) {
                return false;
            }
        }

        return true;
    }
}



class Solution {

    /**
     * @param Integer $N
     * @param Integer[][] $dislikes
     * @return Boolean
     */
    function possibleBipartition($N, $dislikes) {
        if (count($dislikes) == 0) {
            return true;
        }
        $map = array_fill(0, $N, []);
        foreach($dislikes as $value) {
            $map[$value[0]-1][] = $value[1]-1;
            $map[$value[1]-1][] = $value[0]-1;
        }
        
        $group = array_fill(0, $N, 0);
        for($i = 1;$i<=$N;$i++) {
            if ($group[$i-1] >0) {
                continue;
            }

            $flag = true;
            $queue = [$i-1];
            while(count($queue) != 0) {
                $c = count($queue);
                
                for($k = 0;$k<$c;$k++) {
                    if ($group[$queue[$k]] == 0) {
                        $group[$queue[$k]] = ($flag ? 1 : 2);
                        $queue = array_merge($queue, $map[$queue[$k]]);
                    } else {
                        if ( ($flag && $group[$queue[$k]] == 2) || 
                            (!$flag && $group[$queue[$k]] ==1)) {
                            return false;
                        }
                    }
                }
                $flag = !$flag;
                for($k = 0;$k<$c;$k++) {
                    array_shift($queue);
                }   
            }    
        }
        return true;
    }
}
