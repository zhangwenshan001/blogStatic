/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func convertBST(root *TreeNode) *TreeNode {
    var preMax int = 0
    convert(root, &preMax)
    return root
}


func convert(p *TreeNode, preMax *int) {
    if p == nil {
        return
    }
    if p.Right != nil {convert(p.Right, preMax)}
    p.Val += *preMax
    *preMax =  p.Val
    if p.Left != nil {convert(p.Left, preMax)} 
}