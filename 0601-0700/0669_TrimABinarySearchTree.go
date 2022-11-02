/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func trimBST(root *TreeNode, low int, high int) *TreeNode {
    if root == nil {
        return root
    }
    
    leftNode := trimBST(root.Left, low, high)
    rightNode := trimBST(root.Right, low, high)
    
    if root.Val >= low && root.Val <= high {
        root.Left = leftNode
        root.Right = rightNode
        
        return root
    } 
    
    if leftNode != nil && leftNode.Val >= low && leftNode.Val <= high {
        return leftNode
    } 
    
    return rightNode
}