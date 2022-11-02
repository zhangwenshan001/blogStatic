func findTheCity(n int, edges [][]int, distanceThreshold int) int {
    adj := make([][][]int, n)
    for _,edge := range edges {
        adj[edge[0]] = append(adj[edge[0]], []int{edge[1], edge[2]})
        adj[edge[1]] = append(adj[edge[1]], []int{edge[0], edge[2]})
    }
    res := 0
    num := n
    for i:=0;i<n;i++ {
        curNum := minPath(&adj, i, distanceThreshold, n)
        // fmt.Println(curNum)
        if curNum <= num {
            num = curNum
            res = i
        }
        // fmt.Println(res)
    }
    return res
}


func minPath(adj *[][][]int, s int, distanceThreshold int, n int) int {
    marked := make([]bool, n)
    marked[s] = true
    
    dist := make([]int, n)
    for i:=0;i<n;i++ {
        dist[i] = -1
    }
    dist[s] = 0
    for _, w := range (*adj)[s] {
        dist[w[0]] = w[1]
    }
    
    count := 1
    for count < n {
        next := -1
        for i:=0;i<n;i++ {
            if marked[i] {
                continue
            }
            if dist[i] > 0 && (next == -1 || dist[i] < dist[next]) {
                next = i
            }
        }
        
        if next == -1 || dist[next] > distanceThreshold {
            return count
        }
        marked[next] = true
        count++
        
        for _, w := range(*adj)[next] {
            if dist[w[0]] == -1 || dist[w[0]] > dist[next] + w[1] {
                dist[w[0]] = dist[next] + w[1]
            }
        }
        // fmt.Println("s:", s, " next: ", next,  " dist:", dist) 
    }
    
    return count
}
