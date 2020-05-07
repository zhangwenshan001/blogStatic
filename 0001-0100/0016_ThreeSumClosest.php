<?php

class ThreeSumClosest {
    /**
     * 思路：先排序，排序后遍历其中一个数，剩下两个从头尾向中间靠近
     *
     * @param Integer[] $nums
     * @param Integer   $target
     *
     * @return Integer
     */
    function threeSumClosest($nums, $target)
    {
        $arrayCount = count($nums);
        if ($arrayCount < 3) {
            return null;
        }

        sort($nums); //排序

        $result = PHP_INT_MAX;
        for ($i = 0; $i < $arrayCount; $i++) {
            $curTarget = $target - $nums[$i];  //固定当前
            $start     = $i + 1;
            $end       = $arrayCount - 1;
            while ($start < $end) {
                //如果当前三个数的和=target,直接返回
                if ($nums[$start] + $nums[$end] == $curTarget) {
                    return $target;
                }

                $d = $result - $target > 0 ? $result - $target : $target - $result; //此时的最小距离
                //如果当前三个数的和离target更近，则更新result
                if ($nums[$start] + $nums[$end] - $curTarget > -$d && $nums[$start] + $nums[$end] - $curTarget < $d) {
                    $result = $nums[$start] + $nums[$end] + $nums[$i];
                }

                //两个数之和偏大
                if ($nums[$start] + $nums[$end] > $curTarget) {
                    $end--;
                } else {
                    $start++;
                }
                echo 'result: ' . $result . PHP_EOL;
            }
        }

        return $result;

    }
}

