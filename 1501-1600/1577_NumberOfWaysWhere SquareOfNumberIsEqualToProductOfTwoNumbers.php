<?php

class Solution {

    /**
     * @param Integer[] $nums1
     * @param Integer[] $nums2
     * @return Integer
     */
    function numTriplets($nums1, $nums2) {
        sort($nums1);
        sort($nums2);
        
        return $this->handle($nums1, $nums2) + $this->handle($nums2, $nums1);
    }
    
    function handle($nums1, $nums2) {
        $n = count($nums1);
        $m = count($nums2);
        $res = 0;
        for($i =0;$i< $n;$i++) {
            $start = 0;
            $end = $m-1;
            while($start < $end) {
                if ($nums2[$start] * $nums2[$end] == $nums1[$i] * $nums1[$i]) {
                    if ($nums2[$start] == $nums2[$end]) {
                        $k = $end-$start+1;
                        $res += $k*($k-1)/2;
                        break;
                    }
                    $startN = 1;
                    $startTmp = $start+1;
                    while($startTmp < $end &&  $nums2[$startTmp] == $nums2[$start]) {
                        $startN++;
                        $startTmp++;
                    }
                    $endN = 1;
                    $endTmp = $end-1;
                    while($start < $endTmp && $nums2[$endTmp] == $nums2[$end]) {
                        $endN++;
                        $endTmp--;
                    }
                    
                    $res += $startN * $endN;
                    $start = $startTmp;
                    $end = $endTmp;
                    continue;
                }
                if ($nums2[$start] * $nums2[$end] > $nums1[$i] * $nums1[$i]) {
                    $end--;
                } else {
                    $start++;
                }
            }
        }
        return $res;
    }
}