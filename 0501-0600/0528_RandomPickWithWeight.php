<?php
class Solution {
    private $p;
    private $sum;
    /**
     * @param Integer[] $w
     */
    function __construct($w) {
        $sum = 0;
        $i = 0;
        foreach($w as $weight) {
            $sum += $weight;
            $this->p[$sum] = $i++;
        }
        $this->sum = $sum;
    }
  
    /**
     * @return Integer
     */
    function pickIndex() {
        $num = rand(1, $this->sum);
        $c = count($this->p);

        $i = 0;
        $j = $c-1;
         $keys = array_keys($this->p);
        
        if ($c == 1) {
            return current($this->p);
        }
        if ($c == 2) {
            return ($num > $keys[0]) ? $this->p[$keys[1]] : $this->p[$keys[0]];
        }
        

        while($i < $j-1) {            
            $mid = (int) (($i + $j) / 2);
            if ($keys[$mid] == $num) {
                return $this->p[$num];
            }
            if ($keys[$mid] < $num) {
                $i = $mid;
            } else {
                $j = $mid;
            }
        }

        if ($num <= $keys[$i]) {
            return $this->p[$keys[$i]];
        }
         
        return $this->p[$keys[$j]];
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * $obj = Solution($w);
 * $ret_1 = $obj->pickIndex();
 */
