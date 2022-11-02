/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func increasingBST(root *TreeNode) *TreeNode {
	var res, last *TreeNode
	rearrange(root, &res, &last)
	return res

}
func rearrange(p *TreeNode, res, last **TreeNode) {
	if p == nil {
		return
	}

	rearrange(p.Left, res, last)
	if *res == nil {
		*res = p
		*last = p
	} else {
		(*last).Right = p
		*last = (*last).Right
		(*last).Left = nil
	}
	rearrange(p.Right, res, last)

}