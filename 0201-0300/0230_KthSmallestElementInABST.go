func kthSmallest(root *TreeNode, k int) int {
    var kthElement int
    var count int = 0
    nodeNum(root, &kthElement, k, &count)
    return kthElement 
}

func nodeNum(p *TreeNode, kthElement *int, k int, count *int) {
    if p == nil || *count >= k {return}
    
    nodeNum(p.Left, kthElement,k,count)
    if *count == k {return}
    *count++
    if *count == k {
        *kthElement = p.Val
    }
    nodeNum(p.Right, kthElement,k,count)
}