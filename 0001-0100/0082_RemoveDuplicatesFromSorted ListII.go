/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func deleteDuplicates(head *ListNode) *ListNode {
    res := &ListNode{0, nil}
    p := res
    
    for head != nil && head.Next != nil {
        if head.Val != head.Next.Val {
            p.Next = head
            p = p.Next
            
        } else {
            for head.Next != nil && head.Val == head.Next.Val {
                head = head.Next
            } 
        }
        head = head.Next
    }
    p.Next = head
    
    return res.Next
    
}