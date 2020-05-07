<?php

class NextPermutation
{

    /**
     * 找到比当前数组大的最小数组
     * note：
     * 1. 从后往前，找到第一个相邻正序对位置j-1 & j
     * 2. 从后往前，找到第一个比j-1位置大的数 位置为i
     * 3. 将j-1与i交换位置（保证了此时j-1位置是所有满足条件数的最小值）
     * 4. 剩下j到末尾整体翻转
     *
     * @param $nums
     */
    function exeNextPermutation(&$nums)
    {
        if (!$nums) {
            return;
        }
        $count = count($nums);
        if ($count == 1) {
            return;
        }

        for ($j = $count - 1; $j > 0; $j--) {
            //找到正序的位置 $j-1
            if ($nums[$j] > $nums[$j - 1]) {
                //找到大于$nums[$j-1]的倒数第一个数
                $i = $count - 1;
                while ($i > $j - 1 && $nums[$i] <= $nums[$j-1]) {
                    $i--;
                }
                //交换j-1 和i
                $nums[$j - 1] = $nums[$j - 1] + $nums[$i];
                $nums[$i]     = $nums[$j - 1] - $nums[$i];
                $nums[$j - 1] = $nums[$j - 1] - $nums[$i];
                break;
            }
        }
        //位置j 到位置 count-1 翻转
        if ($nums[$j] == $nums[$count - 1]) {
            return;
        }

        $i = $j;
        $k = $count - 1;
        while ($i < $k) {
            $nums[$i] = $nums[$i] + $nums[$k];
            $nums[$k] = $nums[$i] - $nums[$k];
            $nums[$i] = $nums[$i] - $nums[$k];
            $i++;
            $k--;
        }

        return;
    }
}

