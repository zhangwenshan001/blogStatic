func getAncestors(n int, edges [][]int) [][]int {
    adj := make([][]int, n)
    for _,edge :=range edges {
        adj[edge[1]] = append( adj[edge[1]], edge[0]) //反图
    }
    
    marked := make([]bool, n)
    flag := make([][]bool, n)
    for i:=0;i<n;i++ {
        flag[i] = make([]bool, n) 
    }
    
    for i:=0;i<n;i++ {
        if !marked[i] {
            dfs(&marked, &adj, &flag, i)
        }
    }
    
    res := make([][]int, n)
    for i:=0;i<n;i++ {
        for j:=0;j<n;j++ {
            if flag[i][j] {
                res[i] = append(res[i], j)
            }
        }
    }
    return res
}

func dfs(marked *[]bool, adj *[][]int, flag *[][]bool, s int) {
    (*marked)[s] = true
    
    for _, w :=range (*adj)[s] {
        if !(*marked)[w] {
            dfs(marked, adj, flag, w)
        }
        
        for i:=0;i<len(*marked);i++ {
            if (*flag)[w][i] {
                 (*flag)[s][i] = true 
            }
        }

        (*flag)[s][w] = true
    }
}