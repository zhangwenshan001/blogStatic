<?php

class SubstringWithConcatenationOfAllWords
{
    /**
     * 复杂度较高
     *
     * @param String   $s
     * @param String[] $words
     *
     * @return Integer[]
     */
    function findSubstring($s, $words)
    {
        if (!$s || !$words) {
            return [];
        }

        $slen = strlen($s);
        $wlen = strlen(current($words));
        if ($slen < $wlen) {
            return [];
        }

        $flags = [];
        $count = count($words);
        $i     = 0;
        while ($i < $count) {
            $flags[] = 1;
            $i++;
        }

        $result = [];
        $i      = 0;
        while ($i < $slen) {
            $isValid = $this->isValid(substr($s, $i, $slen - $i), $words, $flags);
            if ($isValid) {
                $result[] = $i;
            }
            $i++;
        }

        return $result;
    }

    function isValid($s, $words, $flags)
    {
        echo $s . PHP_EOL;
        if (!$words) {
            return false;
        }

        $slen = strlen($s);
        $wlen = strlen(current($words));

        if ($slen < $wlen) {
            return false;
        }

        $curStr = substr($s, 0, $wlen);
        $pos    = null;
        foreach ($words as $key => $value) {
            if ($value == $curStr && $flags[$key] != 0) {
                $pos = $key;
                break;
            }
        }

        //如果找到pos
        if (isset($pos)) {
            $flags[$pos] = 0;

            $allZero = true;
            foreach ($flags as $item) {
                if ($item == 1) {
                    $allZero = false;
                    break;
                }
            }

            if ($allZero) {
                return true;
            }

            return $this->isValid(substr($s, $wlen, $slen - $wlen), $words, $flags);
        }

        return false;
    }


    /**
     * 先做一个word的数量统计
     * 在依次检验对应s是否满足条件
     *
     * @param $s
     * @param $words
     *
     * @return array
     */
    public function findSubstringNew($s, $words)
    {
        if (!$s || !$words) {
            return [];
        }

        $slen  = strlen($s);
        $wlen  = strlen(current($words));
        $count = count($words);
        if ($slen < $wlen) {
            return [];
        }

        $wordCount = [];
        for ($i = 0; $i < $count; $i++) {
            if (key_exists($words[$i], $wordCount)) {
                $wordCount[$words[$i]] = $wordCount[$words[$i]] + 1;
            } else {
                $wordCount[$words[$i]] = 1;
            }
        }

        $wordsTotalLen = $count * $wlen;
        $result        = [];
        for ($i = 0; $i < $slen - $wordsTotalLen + 1; $i++) {
            $tmp     = $wordCount;
            $isMatch = true;
            for ($j = 0; $j < $count; $j++) {
                $curWord = substr($s, $i + $j * $wlen, $wlen);
                if (key_exists($curWord, $tmp) && $tmp[$curWord] > 0) {
                    $tmp[$curWord]--;
                } else {
                    $isMatch = false;
                    break;
                }
            }
            if ($isMatch) {
                $result[] = $i;
            }
        }

        return $result;
    }
}

