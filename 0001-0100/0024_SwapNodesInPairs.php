<?php

class SwapNodesInPairs
{

    /**
     * @param ListNode $head
     *
     * @return ListNode
     */
    function swapPairs($head)
    {
        //仅有1个节点时直接返回
        if (!$head || !$head->next) {
            return $head;
        }

        $result = new ListNode(0);
        $pre = $result;

        $p1 = $head;
        $p2 = $head->next;

        while ($p2) {
            $pre->next = $p2;
            $p1->next = $p2->next;
            $p2->next = $p1;

            $p1 = $p1->next;
            $p2 = $p1->next;
            $pre = $pre->next->next;
        }

        return $result->next;
    }
}
