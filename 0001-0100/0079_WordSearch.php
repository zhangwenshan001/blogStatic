<?php

class Solution {

    /**
     * @param String[][] $board
     * @param String $word
     * @return Boolean
     */
    function exist($board, $word) {
         if (!$board || !$word) {
            return false;
        }

        $m = count($board);
        $n = count($board[0]);

        $flag = array_pad([], $m, array_pad([], $n, 0));

        for ($i = 0; $i < $m; $i++) {
            for ($j = 0; $j < $n; $j++) {
                $isMatch = $this->isMatch($board, $word, $m, $n, $flag, $i, $j, 0);
                if ($isMatch) {
                    return true;
                }
            }
        }

        return false;
    }
     function isMatch(&$board, &$word, &$m, &$n, &$flag, $i, $j, $k)
    {
        if ($k == strlen($word) - 1) {
            if ($board[$i][$j] == $word[$k] && $flag[$i][$j] == 0) {
                return true;
            } else {
                return false;
            }
        }
        if ($board[$i][$j] == $word[$k] && $flag[$i][$j] == 0) {
            $flag[$i][$j] = 1;
            if ($i > 0) {
                $isMatch = $this->isMatch($board, $word, $m, $n, $flag, $i - 1, $j, $k + 1);
                if ($isMatch) {
                    return true;
                }
            }
            if ($i < $m - 1) {
                $isMatch = $this->isMatch($board, $word, $m, $n, $flag, $i + 1, $j, $k + 1);
                if ($isMatch) {
                    return true;
                }
            }
            if ($j > 0) {
                $isMatch = $this->isMatch($board, $word, $m, $n, $flag, $i, $j - 1, $k + 1);
                if ($isMatch) {
                    return true;
                }
            }
            if ($j < $n - 1) {
                $isMatch = $this->isMatch($board, $word, $m, $n, $flag, $i, $j + 1, $k + 1);
                if ($isMatch) {
                    return true;
                }
            }
            $flag[$i][$j] = 0;
        } else {
            return false;
        }

    }
}
