<?php

class Solution {

     function searchRange($nums, $target)
    {
           if (empty($nums)) {
            return [-1, -1];
        }

        $leftPos = $this->search($nums, $target, true);

        $leftPos  = $nums[0] == $target ? 0 : (($nums[$leftPos + 1] == $target) ? $leftPos + 1 : -1);
        $rightPos = $this->search($nums, $target, false);
        $rightPos = ($nums[count($nums) - 1] == $target) ? count($nums) - 1 : (($nums[$rightPos] == $target) ? $rightPos : -1);

        return [$leftPos, $rightPos];
    }


    function search($nums, $target, $isLeft)
    {
        $start = 0;
        $end   = count($nums) - 1;

        if ($nums[$start] > $target || $nums[$end] < $target) {
            return -1;
        }

        $mid = intval(($start + $end) / 2);
        while ($start != $mid) {
            $midNum = $nums[$mid];

            if ($midNum > $target || $isLeft && $midNum == $target) {
                $end = $mid;
            } else {
                $start = $mid;
            }
            $mid = intval(($start + $end) / 2);

        }

        return $start;
    }
}
