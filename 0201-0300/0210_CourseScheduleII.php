<?php

class Solution {

    /**
     * @param Integer $numCourses
     * @param Integer[][] $prerequisites
     * @return Integer[]
     */
    function findOrder($numCourses, $prerequisites) {
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
        
        $courseOrder = [];
        foreach($indegree as $key => $value) { 
            if ($value == 0) {
                $courseOrder[] = $key;
                $queue[] = $key; //the course which has no pre courses;
            }
        }
        while(count($queue) != 0) {
            $course = $queue[0];
            array_shift($queue);
            $count++;
            foreach($map[$course] as $key => $value) {
                if (--$indegree[$value] ==0) {
                    $courseOrder[] = $value;
                    $queue[] = $value;
                }    
            }
        }
        
        if ($count != $numCourses) {
            return [];
        } else {
            return $courseOrder;
        }
       
    }
}
