<?php
class Solution {

    private $dp = [];
    /**
     * @param Integer[] $coins
     * @param Integer $amount
     * @return Integer
     */
    function coinChange($coins, $amount) {
        if ($amount == 0) {
            return 0;
        }
        if (in_array($amount, $coins)) {
            return 1;
        }
        
        if (!empty($this->dp[$amount])) {
            return $this->dp[$amount];
        } 
        
        $min = -1;
        
        foreach($coins as $coin) {
            if ($amount - $coin > 0) {
                $pre = $this->coinChange($coins, $amount-$coin);
                $min = ($pre < 0) ? $min : (($min < 0)? $pre+1 : min($min, $pre+1));
            }
        }
        //r_dump($this->dp);
        $this->dp[$amount] = $min;
        return $min;
    }
}
