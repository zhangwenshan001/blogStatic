/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */




func recoverTree(root *TreeNode)  {
    var last *TreeNode
    var first, second *TreeNode 
    recoverTreeInOder(root, &first, &second, &last)
    first.Val, second.Val = second.Val,  first.Val
}

func recoverTreeInOder(p *TreeNode, first, second, last **TreeNode) {
    if p == nil {
        return
    }
    
    recoverTreeInOder(p.Left,first, second, last)
    if *last != nil && (*last).Val > p.Val {
        if *first == nil {
            *first = *last  
        } 
        *second = p
    }
    
    *last = p
    recoverTreeInOder(p.Right,first, second, last)
}