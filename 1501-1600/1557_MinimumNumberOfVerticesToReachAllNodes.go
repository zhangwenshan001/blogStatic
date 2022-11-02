func findSmallestSetOfVertices(n int, edges [][]int) []int {
    toPoint := make([]bool, n)
    for _, edge := range edges {
        toPoint[edge[1]] = true
    }
    
    var res []int
    for i:=0;i<n;i++ {
        if !toPoint[i] {
            res = append(res, i)
        }
    }
    
    return res
}