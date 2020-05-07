<?php

class RandomizedSet {
    private $locs;
    private $nums;
    
    /**
     * Initialize your data structure here.
     */
    function __construct() {
        $this->locs = [];
        $this->nums = [];
    }
  
    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     * @param Integer $val
     * @return Boolean
     */
    function insert($val) {
        if (array_key_exists($val, $this->locs)) {
            return false;
        }
        $this->nums[] = $val;
        $this->locs[$val] = count($this->nums)-1;
        
        return true;
    }
  
    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     * @param Integer $val
     * @return Boolean
     */
    function remove($val) {
        if (!array_key_exists($val, $this->locs)) {
            return false;
        } 
        
        $loc = $this->locs[$val];
        $last = $this->nums[count($this->nums)-1];
        $this->nums[$loc] = $last;
        $this->locs[$last] = $loc;
        
        unset($this->locs[$val]);
        array_pop($this->nums);
        return true;
    }
  
    /**
     * Get a random element from the set.
     * @return Integer
     */
    function getRandom() {
        return $this->nums[rand(0, count($this->nums)-1)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * $obj = RandomizedSet();
 * $ret_1 = $obj->insert($val);
 * $ret_2 = $obj->remove($val);
 * $ret_3 = $obj->getRandom();
 */
