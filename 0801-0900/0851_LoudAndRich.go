func loudAndRich(richer [][]int, quiet []int) []int {
    n := len(quiet)
    adj := make([][]int, n)
    
    for _,edge := range richer {
        adj[edge[1]] = append(adj[edge[1]], edge[0]) // reverse graph
    }
    
    marked := make([]int, n)
    for i:=0;i<n;i++ {
        marked[i] = -1
    }
    
    for i:=0;i<n;i++ {
        dfs(&marked, &adj, &quiet, i)
    }
    
    return marked
}

func dfs(marked *[]int, adj *[][]int, quiet *[]int,  s int) {
    if (*marked)[s] >= 0 {
        return 
    } 
    
    (*marked)[s] = s 
    for _, w := range (*adj)[s] {
        dfs(marked, adj, quiet, w)
        if (*quiet)[(*marked)[w]] < (*quiet)[(*marked)[s]] {
            (*marked)[s] = (*marked)[w]
        }
    }
    
    return
}


