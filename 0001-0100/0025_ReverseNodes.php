<?php

class ReverseNodes
{

    /**
     * @param ListNode $head
     * @param Integer  $k
     *
     * @return ListNode
     */
    function reverseKGroup($head, $k)
    {
        if ($k < 2) {
            return $head;
        }

        $pCount = $head;
        //校验剩余是否存在k个节点
        for ($i = 0; $i < $k; $i++) {
            if (!$pCount) {
                return $head;
            } else {
                $pCount = $pCount->next;
            }
        }

        $i = 0;

        $p1 = null;
        $p2 = $head;

        while ($i < $k) {
            $tmp = $p2->next;
            $p2->next = $p1;

            $p1 = $p2;
            $p2 = $tmp;
            $i++;
        }

        //p1指向第k个 p2 = pCount
        if (!$p2) {
            return $p1;
        }

        $head->next = $this->reverseKGroup($p2, $k);
        return $p1;
    }
}

