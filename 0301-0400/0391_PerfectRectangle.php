<?php

class Solution {

    /**
     * @param Integer[][] $rectangles
     * @return Boolean
     */
    function isRectangleCover($rectangles) {
        
        if(count($rectangles) == 0 || count($rectangles[0]) == 0) {
            return false;
        }
            
        $iMin = PHP_INT_MAX;
        $jMin = PHP_INT_MAX;
        $iMax = PHP_INT_MIN;
        $jMax = PHP_INT_MIN;
        
        $set = [];
        foreach($rectangles as $rectangle) {
            $iMin = min($iMin, $rectangle[0]);
            $jMin = min($jMin, $rectangle[1]);
            $iMax = max($iMax, $rectangle[2]);
            $jMax = max($jMax, $rectangle[3]);
            
            $area += ($rectangle[2] - $rectangle[0]) * ($rectangle[3] - $rectangle[1]);
            
            $key1 = $rectangle[0] . "_" .  $rectangle[1];
            $key2 = $rectangle[0] . "_" .  $rectangle[3];
            $key3 = $rectangle[2] . "_" .  $rectangle[3];
            $key4 = $rectangle[2] . "_" .  $rectangle[1];
            
            if (isset($set[$key1])) {
                unset($set[$key1]);
            } else {
                $set[$key1] = 1;
            }
            
            if (isset($set[$key2])) {
                unset($set[$key2]);
            } else {
                $set[$key2] = 1;
            }
            
            if (isset($set[$key3])) {
                unset($set[$key3]);
            } else {
                $set[$key3] = 1;
            }
            
            if (isset($set[$key4])) {
                unset($set[$key4]);
            } else {
                $set[$key4] = 1;
            }
        }
        
        if (count($set) != 4) {
            return false;
        }
        if (!isset($set[$iMin."_".$jMin]) || !isset($set[$iMin."_".$jMax]) || !isset($set[$iMax."_".$jMin]) || !isset($set[$iMax."_".$jMax])) {
            return false;
        }
        
        return $area == ($iMax - $iMin) * ($jMax - $jMin);
    }
}
