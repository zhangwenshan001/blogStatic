<?php

class Solution {

    private $maps = [];
    private $route = [];
    /**
     * @param String[][] $tickets
     * @return String[]
     */
    function findItinerary($tickets) {
        foreach($tickets as $ticket) {
            if (!empty($ticket[0])) {
                $this->maps[$ticket[0]][] = $ticket[1];
            } else {
                $this->maps[$ticket[0]] = [$ticket[1]];
            }
           
        }
        
        foreach($this->maps as $key => &$item) {
            sort($item);
        }
        
        $this->visit("JFK");
        
        return array_reverse($this->route);
    }
    
    function visit($airport) {
        while(!empty($this->maps[$airport]) && count($this->maps[$airport]) > 0) {
            $to = array_shift($this->maps[$airport]);
            $this->visit($to);
        }
        $this->route[] = $airport;
    }
    
    
}
