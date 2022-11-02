func networkBecomesIdle(edges [][]int, patience []int) int {
    adj := make([][]int, len(patience))
    for _,edge :=range edges {
        adj[edge[0]] = append(adj[edge[0]], edge[1])
        adj[edge[1]] = append(adj[edge[1]], edge[0])
    }
    
    var queue []int
    queue = append(queue, 0)
    pathLen := make([]int, len(patience))
    pathLen[0] = 0
    cur := 0
    for len(queue) > 0 {
        cur = queue[0] 
        for _,w := range adj[cur] {
            if pathLen[w] == 0 && w != 0 {
                queue = append(queue, w)
                pathLen[w] = pathLen[cur] + 1
            }
        }
        queue = queue[1:]
    }
    
    max := 0
    
    for i:=1;i<len(patience);i++ {
        curTime := int((2 * pathLen[i]-1) / patience[i]) * patience[i] + 2 * pathLen[i]
        if curTime > max {
            max = curTime
        }
    }
    return max + 1
}
