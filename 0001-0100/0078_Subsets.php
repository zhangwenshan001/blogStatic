<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function subsets($nums) {
        $result = [];

        $this->backTracking($result, [], $nums, 0);
        return $result;
    }
    
    function backTracking(&$list, $tmpList, &$nums, $start)
    {
        $list[] = $tmpList;
        for ($i = $start; $i < count($nums); $i++) {
            array_push($tmpList, $nums[$i]);
            $this->backTracking($list, $tmpList, $nums, $i + 1);
            array_pop($tmpList);
        }
    }
}
