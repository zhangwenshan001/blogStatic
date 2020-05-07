<?php

class StockSpanner {
    
    private $prices;
    private $memo;
    
    function __construct() {
        $this->prices = [];
        $this->memo = [];
    }
  
    /**
     * @param Integer $price
     * @return Integer
     */
    function next($price) {
        
        $this->prices[] = $price;
        $i = count($this->prices)-1;
        
        $j = $i-1;
        $count = 1;
        while($j >= 0) {
            if ($this->prices[$i] >= $this->prices[$j]) {
                $count += $this->memo[$j];
                $j = $j - $this->memo[$j];
            } else {      
                break;     
            }
        }
        $this->memo[$i] = $count;
        return $count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * $obj = StockSpanner();
 * $ret_1 = $obj->next($price);
 */
