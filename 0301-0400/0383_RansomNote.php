<?php

class RansomNote {
    function canConstruct($ransomNote, $magazine) {
        $ransomMap = [];
        $magazineMap = [];

        $strlen1 = strlen($ransomNote);
        $strlen2 = strlen($magazine);

        for($i = 0;$i<$strlen1;$i++) {
            $c = $ransomNote[$i];
            if (array_key_exists($c, $ransomMap)) {
                $ransomMap[$c]++;
            } else {
                $ransomMap[$c] = 1;
            }
        }

        for($i = 0;$i<$strlen2;$i++) {
            $c = $magazine[$i];
            if (array_key_exists($c,$magazineMap)) {
                $magazineMap[$c]++;
            } else {
                $magazineMap[$c] = 1;
            }
        }

        foreach ($ransomMap as $key => $value) {
            if (!array_key_exists($key, $magazineMap) || $magazineMap[$key] < $value) {
                return false;
            }
        }

        return true;
    }
}

