<?php

class RemoveElement
{

    /**
     * @param Integer[] $nums
     * @param Integer   $val
     *
     * @return Integer
     */
    function remove(&$nums, $val)
    {
        if (!$nums) {
            return;
        }
        $count = count($nums);
        if ($count == 1) {
            return $nums[0] == $val ? [] : $nums;
        }

        $start = 0;
        $end   = $count - 1;

        while ($start < $end) {
            while ($start < $end && $nums[$end] == $val) {
                $end--;
            }
            while ($start < $end && $nums[$start] != $val) {
                $start++;
            }

            if ($start < $end) {
                $nums[$start] = $nums[$start] + $nums[$end];
                $nums[$end]   = $nums[$start] - $nums[$end];
                $nums[$start] = $nums[$start] - $nums[$end];
            }
        }

        $nums = array_slice($nums, 0, ($nums[$end] == $val) ? $end : $end + 1);

        return;
    }
}

