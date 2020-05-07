<?php
class Solution {
    /**
     * @param Integer $numCourses
     * @param Integer[][] $prerequisites
     * @return Boolean
     */
    function canFinish($numCourses, $prerequisites) {
        $map = array_fill(0, $numCourses, []);
        $indegree = array_fill(0, $numCourses, 0); //course has how many pre courses;
        
        foreach($prerequisites as $pre) {
            if (!in_array($pre[0], $map[$pre[1]])) {
                $indegree[$pre[0]]++;  
            }
            $map[$pre[1]][] = $pre[0];
        }
    
        $count = 0;
        $queue = [];
        
        foreach($indegree as $key => $value) { 
            if ($value == 0) {
                $queue[] = $key; //the course which has no pre courses;
            }
        }
        while(count($queue) != 0) {
            $course = $queue[0];
            array_shift($queue);
            $count++;
            foreach($map[$course] as $key => $value) {
                if (--$indegree[$value] ==0) {
                    $queue[] = $value;
                }    
            }
        }
        
        return $count == $numCourses;
    }
}


/**
 * Class SolutionDFS
 * Note: check a cycle in Digraph
 */
class SolutionDFS {
    private $marked = [];
    private $adj = [];
    private $onStack = [];

    /**
     * @param Integer $numCourses
     * @param Integer[][] $prerequisites
     * @return Boolean
     */
    function canFinish($numCourses, $prerequisites) {
        $adj = array_fill(0, $numCourses, []);
        foreach($prerequisites as $item) {
            $adj[$item[0]][] = $item[1];
        }
        $this->adj = $adj;
        $this->marked = array_fill(0, $numCourses, false);
        $this->onStack = array_fill(0, $numCourses, false);

        for($i=0;$i<$numCourses;$i++){
            if (!$this->marked[$i]) {
                $res = $this->dfs($i);
                if (!$res) {
                    return false;
                }
            }
        }
        return true;
    }

    function dfs($i){
        $this->onStack[$i] = true;
        $this->marked[$i] = true;
        foreach($this->adj[$i] as $w) {
            if (!$this->marked[$w]) {
                $res = $this->dfs($w);
                if (!$res) {
                    return false;
                }
            } else if ($this->onStack[$w]) {
                return false;
            }
        }
        $this->onStack[$i] = false;
        return true;
    }
}