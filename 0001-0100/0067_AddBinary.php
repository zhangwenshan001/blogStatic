<?php
class Solution {

    /**
     * @param String $a
     * @param String $b
     * @return String
     */
    function addBinary($a, $b) {
        $alen = strlen($a);
        $blen = strlen($b);
        
        $res = "";
        $llen = $alen > $blen ? $alen : $blen;
        $slen = $alen > $blen ? $blen : $alen;
        $ls = $alen > $blen ? $a : $b;
        $ss = $alen > $blen ? $b : $a;
        
        $i = 0;
        $flag = false;
        while($slen-1-$i >=0) {
            $lch = $ls[$llen - 1 - $i];
            $sch = $ss[$slen - 1 - $i];
            
            if ($lch == '0' && $sch == '0') {
                $res = $flag ? "1".$res : "0".$res; 
                $flag = false;
            } else if ($lch == '1' && $sch == '1') {
                $res = $flag ? "1".$res : "0".$res; 
                $flag = true;
            } else {
                if ($flag) {
                    $res = "0" . $res;
                } else {
                    $res = "1".$res;
                }
            }
            $i++;
        }
        while($llen - 1 - $i >=0) {
            $lch = $ls[$llen - 1 - $i];
            if ($lch == '0') {
                $res = $flag ? "1".$res : "0".$res; 
                $flag = false;
            } else {
                if ($flag) {
                    $res = "0" . $res;
                } else {
                    $res = "1".$res;
                }
            }
            $i++;
        }
        if ($flag) {
            $res = "1" . $res;
        }
        return $res;
    }
}
