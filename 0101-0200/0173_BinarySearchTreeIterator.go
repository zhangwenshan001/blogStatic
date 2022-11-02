/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
type BSTIterator struct {
    stack []*TreeNode
}


func Constructor(root *TreeNode) BSTIterator {
    iterator := BSTIterator{}
    for root != nil {
        iterator.stack = append(iterator.stack, root)
        root = root.Left
    }
    
    return iterator
}


func (this *BSTIterator) Next() int {
    l := len(this.stack)
    curNode := this.stack[l-1]
    this.stack = this.stack[0:l-1]
    for p := curNode.Right; p != nil; {
        this.stack = append(this.stack, p)
        p = p.Left
    }
    
    return curNode.Val
}


func (this *BSTIterator) HasNext() bool {
    return len(this.stack) > 0
}


/**
 * Your BSTIterator object will be instantiated and called as such:
 * obj := Constructor(root);
 * param_1 := obj.Next();
 * param_2 := obj.HasNext();
 */