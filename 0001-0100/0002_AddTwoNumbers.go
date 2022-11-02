/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {

	flag := 0

	res := l1
	current := l1

	for l1 != nil && l2 != nil {
		if l1.Val+l2.Val+flag >= 10 {
			l1.Val = l1.Val + l2.Val + flag - 10
			flag = 1
		} else {
			l1.Val = l1.Val + l2.Val + flag
			flag = 0
		}

		current = l1
		l1 = l1.Next
		l2 = l2.Next
	}

	if l1 == nil && l2 == nil {
		if flag == 0 {
			return res
		} else {
			current.Next = &ListNode{1, nil}
			return res
		}
	}

	rest := l1
	if l1 == nil {
		rest = l2
	}

	current.Next = rest

	for flag == 1 {
		if rest == nil {
			current.Next = &ListNode{1, nil}
			flag = 0
		} else if rest.Val == 9 {
			rest.Val = 0
			flag = 1
			current = rest
			rest = rest.Next

		} else {
			rest.Val = rest.Val + 1
			flag = 0
		}
	}

	return res
}