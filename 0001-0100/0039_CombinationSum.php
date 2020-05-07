<?php

class Solution {

    /**
     * @param Integer[] $candidates
     * @param Integer $target
     * @return Integer[][]
     */
    function combinationSum($candidates, $target) {
         $result = $this->find($candidates, $target, 0);

        return $result;
    }

    function find($candidates, $target, $start)
    {
       if ($start >= count($candidates)) {
            return [];
        }
        $cur = $candidates[$start];
        $result = [];

        if ($cur > $target) {
            $result = $this->find($candidates, $target, $start + 1);
        }
        if ($cur == $target) {
            $result[]   = [$cur];
            $nextResult = $this->find($candidates, $target, $start + 1);
            if ($nextResult) {
                $result = array_merge($result, $nextResult);
            }
        }

        if ($cur < $target) {
            $n = intval($target / $cur);

            for ($i = 0; $i <= $n; $i++) {
                $curResult = $i == 0 ? [] : array_fill(0, $i, $cur);
                if ($target == $i * $cur) {
                    $result[] = array_fill(0, $i, $cur);
                    continue;
                }
                $nextResult = $this->find($candidates, $target - $cur * $i, $start + 1);
                if ($nextResult) {
                    foreach ($nextResult as $item) {
                        $result[] = array_merge($curResult, $item);
                    }
                }
            }

        }

        return $result;
    }
}
