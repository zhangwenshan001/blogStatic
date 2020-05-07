<?php
  
 class Solution {

    /**
     * @param String $date
     * @return String
     */
    function reformatDate($date) {
        $monthMap = [
            "Jan" => "01", 
            "Feb" => "02",
            "Mar" => "03",
            "Apr" => "04",
            "May" => "05", 
            "Jun" => "06", 
            "Jul" => "07", 
            "Aug" => "08", 
            "Sep" => "09", 
            "Oct" => "10", 
            "Nov" => "11", 
            "Dec" => "12",
        ];
        [$day, $month, $year] = explode(' ', $date);
        $day = str_pad(substr($day, 0, strlen($day)-2) ,2,'0', STR_PAD_LEFT);
        $month = $monthMap[$month];
        return $year. "-" . $month . "-" . $day;
    }
}
