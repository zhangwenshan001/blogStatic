/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func spiralMatrix(m int, n int, head *ListNode) [][]int {
    matrix := make([][]int, m)
    for i:=0;i<m;i++ {
        matrix[i] = make([]int, n)
    }
    
    up := -1
    down := m
    left := -1
    right := n
    
    d := 0 //->
    count := 0
    for i, j := 0, 0; count < m*n; {
        if head != nil {
            matrix[i][j] = head.Val
            head = head.Next
        } else {
            matrix[i][j] = -1
        }
        count = count + 1
        
        if d == 0 {
            if j + 1 != right {
                j = j + 1
            } else {
                d = 1 
                up = i
                i = i + 1
            }
        } else if d == 1 {
            if i+1 != down {
                i = i+1
            } else {
                d = 2
                right = j
                j = j -1
            }
        } else if d == 2 {
            if j-1 != left {
                j = j -1
            } else {
                d = 3
                down = i
                i = i -1
            }
        } else if d == 3 {
            if i-1 != up {
                i = i -1
            } else {
                d = 0
                left = j
                j = j+1
            }
        }
        
    }
    
    return matrix
}