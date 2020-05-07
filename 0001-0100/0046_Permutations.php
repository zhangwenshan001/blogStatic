<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function permute($nums) {
         if (!$nums) {
            return [];
        }

        $result = [];

        $count = count($nums);

        if ($count == 1) {
            $result[] = [current($nums)];
        } else {
            foreach ($nums as $item) {
                $nextResult = $this->permute(array_diff($nums, [$item]));
                foreach ($nextResult as $r) {
                    array_unshift($r, $item);
                    $result[] = $r;
                }
            }
        }

        return $result;
    }
}
