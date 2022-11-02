/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func rotateRight(head *ListNode, k int) *ListNode {
    
    if head == nil {
        return head
    }
    
    p := head
    count := 1
    
    for p.Next != nil {
        p = p.Next
        count++
    }
    
    pos := k % count
    
    
    if pos == 0 {
        return head
    }
    
    pos = count - pos;
    fmt.Print(pos)
    p.Next = head
    
    
    for i:=0;i<pos-1;i++ {
        head = head.Next
    }
    
    res := head.Next
    head.Next = nil
    
    return res
}