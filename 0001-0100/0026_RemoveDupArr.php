<?php

class RemoveDupArr
{
    function removeDuplicates(&$nums)
    {
        if (empty($nums)) {
            return $nums;
        }

        $count = count($nums);

        if ($count == 1) {
            return $nums;
        }

        $i = 1;
        $j = 1;
        while ($j < $count) {
            while ($nums[$j] == $nums[$j-1] && $j<$count) {
                $j++;
            }
            if ($j < $count) {
                $nums[$i] = $nums[$j];
                $i++;
            }
            $j++;
        }
        $nums = array_slice($nums,0, $i);
        return;
    }
}

