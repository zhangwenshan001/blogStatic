<?php

class Solution {

    private $pMap;
    
    /**
     * @param String $s
     * @param String $p
     * @return Integer[]
     */
    function findAnagrams($s, $p) {
        $pMap = $this->getCharMap($p);
        $plen = strlen($p);
        $slen = strlen($s);  
        $res = [];
        $counter = count($pMap);
        
        $start = 0;
        $end = 0;
        
        while($end < $slen) {
            if (array_key_exists($s[$end], $pMap)) {
                $pMap[$s[$end]]--;
                if ($pMap[$s[$end]] == 0) {
                    $counter--;
                }
            }
            $end++;
            
            while($counter == 0) {
                 if (array_key_exists($s[$start],$pMap)) {
                    if ($pMap[$s[$start]]==0) {
                        $counter++;
                    }
                    $pMap[$s[$start]] +=1;
                }
                if ($end-$start == strlen($p)) {
                    $res[] = $start;
                }
                $start++;
            }
        }
        
        return $res;
    }
    
    function getCharMap($s) {
        $map = [];
        $slen = strlen($s);
        for($i=0;$i<$slen;$i++) {
            if (empty($map[$s[$i]])) {
                $map[$s[$i]] = 1;
            } else {
                $map[$s[$i]]++;
            }
        }
        
        return $map;
    }
    
    
}
