func removeStones(stones [][]int) int {
    n := len(stones)
    
    adj := make([][]int, n)
    
    for i:=0;i<n-1;i++ {
        for j :=i+1;j<n;j++ {
            if stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1] {
                adj[i] = append(adj[i], j)
                adj[j] = append(adj[j], i)
            }
        }
    }
    
    cn:= 0
    marked := make([]bool, n)
    for i:=0;i<n;i++ {
        if !marked[i] {
            cn++
            dfs(&marked, &adj, i)
        }
    }
    
    return n-cn
}

func dfs(marked *[]bool, adj *[][]int, s int) {
    (*marked)[s] = true
    
    for _, w :=range (*adj)[s] {
        if !(*marked)[w] {
            dfs(marked, adj, w)
        }
    }
}