<?php

class ThreeSum {

    /**
     * 暂时还没想到复杂度更低的方法
     *
     * @param $nums
     *
     * @return array
     */
    function getThreeSum($nums)
    {
        if (empty($nums)) {
            return [];
        }

        sort($nums);
        $count = count($nums);

        $result = [];
        $j      = $count - 1;
        while ($j > 0) {
            $i = 0;
            while ($i < $j - 1) {
                $target      = -$nums[$i] - $nums[$j];
                $targetIndex = $this->findNum($nums, $i + 1, $j - 1, $target);
                if ($targetIndex) {
                    $result[] = [$nums[$i], $nums[$targetIndex], $nums[$j]];
                }
                $i++;
                while ($i < $j - 1 && $nums[$i] == $nums[$i - 1]) {
                    $i++;
                }
            }
            $j--;
            while ($j > 0 && $nums[$j] == $nums[$j + 1]) {
                $j--;
            }
        }

        return $result;
    }

    function findNum(&$nums, $i, $j, $target)
    {
        for ($k = $i; $k <= $j; $k++) {
            if ($nums[$k] == $target) {
                return $k;
            }
        }

        return null;

    }
}
