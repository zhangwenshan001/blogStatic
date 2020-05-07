<?php 

class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer[]
     */
    function findDuplicates($nums) {
        $res = [];
        
        $n = count($nums);
        for($i = 0;$i<$n;$i++) {
            $cur = $nums[$i];
            while($cur != $nums[$cur-1]) {
                $tmp = $nums[$cur-1];
                $nums[$cur-1] = $cur;
                $cur = $tmp;
                if ($cur == $i+1 || $cur == $nums[$cur-1]) {
                    $nums[$i] = $cur;
                    break;
                }
            }
            
        }
        foreach($nums as $key => $value) {
            if ($key != $value -1) {
                $res[] = $value;
            }
        }
        
        return $res;     
    }
}
