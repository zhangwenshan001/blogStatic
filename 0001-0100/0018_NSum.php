<?php

class NSum {

    function fourSum($nums, $target)
    {
        //不存在或个数<4时
        if (empty($nums) || count($nums) < 4) {
            return [];
        }

        sort($nums); //排序

        return $this->getNSum($nums, $target, 4);
    }

    function getNSum($nums, $target, $n)
    {
        if (!$n) {
            return null;
        }
        //如果nums个数少于n 则返回[]
        if (empty($nums) || count($nums) < $n) {
            return null;
        }

        if ($n == 1) {
            return in_array($target, $nums) ? [$target] : null;
        }

        $numCount = count($nums);

        if ($n == 2) {
            $i = 0;
            $j = $numCount - 1;

            $result = [];
            while ($i < $j) {
                $sum = $nums[$i] + $nums[$j];
                if ($sum == $target) {
                    $result[] = [$nums[$i], $nums[$j]];
                    $i++;
                    $j--;
                } elseif ($sum < $target) {
                    $i++;
                } else {
                    $j--;
                }
                while ($i < $j && $i > 0 && $nums[$i] == $nums[$i - 1]) {
                    $i++;
                }
                while ($i < $j && $j < $numCount && $nums[$j] == $nums[$j + 1]) {
                    $j--;
                }
            }

            return $result;
        }

        $i      = 0;
        $result = [];

        while ($i + 2 < $numCount) {
            $curNum = $nums[$i];

            $curTarget = $target - $curNum;
            $curArray  = array_slice($nums, $i + 1, $numCount - $i - 1);
            $newResult = $this->getNSum($curArray, $curTarget, $n - 1);
            if (!empty($newResult)) {
                foreach ($newResult as $item) {
                    array_unshift($item, $nums[$i]);
                    $result[] = $item;
                }
            }
            $i++;

            while ($nums[$i] == $nums[$i - 1] && $i +2 < $numCount) {
                $i++;
            }
        }
        return $result;

    }
}

