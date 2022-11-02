/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func swapNodes(head *ListNode, k int) *ListNode {
    p1, p2 := head, head
    for i := 0 ;i < k-1; i++ {
        p1 = p1.Next
    }
    
    p3 := p1
    
    for ;p1.Next!=nil; {
       p1 = p1.Next
       p2 = p2.Next
    }
    
    t := p3.Val
    p3.Val = p2.Val
    p2.Val = t
    
    return head
}