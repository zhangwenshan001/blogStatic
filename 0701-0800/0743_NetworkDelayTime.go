func networkDelayTime(times [][]int, n int, k int) int {
    adj := make([][][]int, n)
    for _,edge := range times {
        adj[edge[0]-1] = append(adj[edge[0]-1], []int{edge[1]-1, edge[2]})
        // adj[edge[1]-1] = append(adj[edge[1]-1], []int{edge[0]-1, edge[2]})
    }
    return minMaxPath(&adj, n, k-1)
}

func minMaxPath(adj *[][][]int, n int, k int) int {
    marked := make([]bool, n)
    dist:=make([]int, n)
    marked[k] = true
    for i:=0;i<n;i++ {
        dist[i] = -1
    }
    dist[k] = 0
    // fmt.Println((*adj)[k])
    
    for _, w :=range (*adj)[k] {
        dist[w[0]] = w[1]
    }
    
    count := 1
    res := 0
    for count < n {
        //find next
        next := -1
        for i:=0;i<n;i++ {
            if marked[i] {
                continue
            }
            if dist[i] >= 0 && (next == -1 || dist[i] < dist[next]) {
                next = i
            }
        }
        if next == -1 {
            return -1
        }
        marked[next] = true
        count++
        
        for _, w := range (*adj)[next] {
            if !marked[w[0]] && (dist[w[0]] == -1 || dist[w[0]] > dist[next] + w[1]) {
                dist[w[0]] =  dist[next] + w[1]
            }
        }
        // fmt.Println("next:", next, " dist:", dist)
        if count == n {
            res = dist[next]
        }
    }
    
    return res
}