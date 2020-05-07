<?php

class RegularExpressionMatching {

    /**
     * 实现简单的*.匹配
     * 待优化
     *
     * @param String $s
     * @param String $p
     *
     * @return Boolean
     */
    function isMatch($s, $p)
    {
        echo $s.PHP_EOL;
        echo $p.PHP_EOL;
        //全为空，则匹配
        if (!$s && !$p) {
            return true;
        }

        if (!$p && $s) {
            return false;
        }

        //只要是*开头 就返回false
        if (substr($p, 0, 1) == '*') {
            return false;
        }

        $slen = strlen($s);
        $plen = strlen($p);


        //p只剩一位（ 肯定不是*） 或者
        //p p+1为普通字母 [./x]y或[./x].[y] 当前随便 后面是字母或者.+字母
        if ($plen == 1 ||
            ($plen >= 2 && $p[1] != '*')) {

            //s不存在
            if (!$s) {
                return false;
            } elseif ($p[0] == '.' || $p[0] == $s[0]) {
                return $this->isMatch(substr($s, 1, $slen - 1), substr($p, 1, $plen - 1));
            } else {
                return false;
            }

        }

        //p p+1 为.*
        if ($plen >= 2 && $p[0] == '.' && $p[1] == '*') {
            if ($plen == 2) {
                return true;
            }

            $i = 0;
            while ($i < $slen) {
                $iRes = $this->isMatch(substr($s, $i, $slen - $i), substr($p, 2, $plen - 2));
                //只要有一个匹配，就认为匹配
                if ($iRes) {
                    return true;
                }
                $i++;
            }

            return $this->isMatch(substr($s, $i, $slen - $i), substr($p, 2, $plen - 2));
        }

        //p p+1 为 x*[] //当前字母 后面为* （向后看一位）
        if ($plen >= 2 && $p[0] !== '.' && $p[1] == '*') {
            //p剩下x* 则s剩下全部都必须是x
            if ($plen == 2) {
                $i = 0;
                while ($i < $slen) {
                    if ($s[$i] != $p[0]) {
                        return false;
                    }
                    $i++;
                }

                return true;
            }

            if ($s[0] != $p[0]) {
                return $this->isMatch($s, substr($p, 2, $plen - 2));
            }

            $i = 0;
            while ($s[$i] == $p[0] && $i < $slen) {
                $iRes = $this->isMatch(substr($s, $i, $slen - $i), substr($p, 2, $plen - 2));
                if ($iRes) {
                    return true;
                }
                $i++;
            }

            return $this->isMatch(substr($s, $i, $slen - $i), substr($p, 2, $plen - 2));
        }
    }
}

