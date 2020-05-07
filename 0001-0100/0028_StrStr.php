<?php

class StrStr
{
    /**
     * @param String $haystack
     * @param String $needle
     *
     * @return Integer
     */
    function getIndexOfsubstr($haystack, $needle)
    {
        if (!$needle) {
            return 0;
        }

        if (!$haystack) {
            return -1;
        }

        $i    = 0;
        $slen = strlen($haystack);
        $nlen = strlen($needle);
        while ($i < $slen - $nlen + 1) {
            while ($haystack[$i] != $needle[0] && $i < $slen - $nlen + 1) {
                $i++;
            }
            $j    = 0;
            $flag = true;
            while ($j < $nlen) {
                if ($needle[$j] != $haystack[$i + $j]) {
                    $flag = false;
                    break;
                }
                $j++;
            }
            if ($flag) {
                return $i;
            } else {
                $i++;
                continue;
            }
        }

        return -1;
    }
}

