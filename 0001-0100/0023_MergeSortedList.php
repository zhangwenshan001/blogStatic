<?php

class MergeSortedList
{

    /**
     * @param ListNode[] $lists
     *
     * @return ListNode
     */
    function mergeKLists($lists)
    {
        $cur    = new ListNode(0);
        $result = $cur;
        while (true) {
            $stopFlag     = true;
            $min          = PHP_INT_MAX;
            $minListIndex = 0;
            foreach ($lists as $key => $list) {
                if ($list) {
                    $stopFlag = false;
                    if ($list->val < $min) {
                        $minListIndex = $key;
                        $min          = $list->val;
                    }
                }
            }
            if (!$stopFlag) {
                $cur->next            = $lists[$minListIndex];
                $cur                  = $cur->next;
                $lists[$minListIndex] = $lists[$minListIndex]->next;
            } else {
                break;
            }
        }

        return $result->next;
    }
}

