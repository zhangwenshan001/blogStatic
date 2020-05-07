<?php

/**
 * Definition for Employee.
 * class Employee {
 *     public $id = null;
 *     public $importance = null;
 *     public $subordinates = array();
 *     function __construct($id, $importance, $subordinates) {
 *         $this->id = $id;
 *         $this->importance = $importance;
 *         $this->subordinates = $subordinates;
 *     }
 * }
 */

class Solution {

    /**
     * @Tag BFS
     *
     * @param Employee[] $employees
     * @param Integer $id
     * @return Integer
     */
    function getImportance($employees, $id) {
        $mark = [];
        $map = [];
        foreach ($employees as $employee) {
            $mark[$employee->id] = false;
            $map[$employee->id] = $employee;
        }

        $queue = [$id];
        $importance = 0;

        while(count($queue)!=0) {
            $count = count($queue);
            for($i = 0;$i<$count;$i++) {
                $importance = $importance + $map[$queue[$i]]->importance;
                $mark[$queue[$i]] = true;
                foreach($map[$queue[$i]]->subordinates as $subid) {
                    if ($mark[$subid] != true) {
                        $queue[] = $subid;
                    }
                }
            }
            for($i = 0;$i<$count;$i++) {
                array_shift($queue);
            }
        }

        return $importance;
    }
}
