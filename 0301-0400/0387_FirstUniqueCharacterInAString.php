<?php

class FirstUniqueCharacterInAString {
    public function firstUniqChar($s){
        $strlen = strlen($s);

        $map = [];
        for ($i = 0;$i<$strlen;$i++) {
            if (array_key_exists($s[$i], $map)) {
                $s[$i][0]++;
            } else {
                $s[$i] = [0, $i];
            }
        }
        foreach($map as $key => $value) {
            if ($value[0] == 1) {
                return $value[1];
            }
        }

        return -1;
    }
}