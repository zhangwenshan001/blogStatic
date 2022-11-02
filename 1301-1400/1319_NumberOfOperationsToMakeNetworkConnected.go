func makeConnected(n int, connections [][]int) int {
    if n - 1 > len(connections) {
        return -1
    }
    adj := make([][]int, n)
    for _, edge := range connections {
        adj[edge[0]] = append(adj[edge[0]],edge[1])
        adj[edge[1]] = append(adj[edge[1]],edge[0])
    }
    
    marked := make([]bool, n)
    count := 0
    for i:=0;i<n;i++ {
        if !marked[i] {
            dfs(&marked, &adj, i)
            count++
        }
    }
    
    return count-1
}

func dfs(marked *[]bool, adj *[][]int, s int) {
    (*marked)[s] = true
    for _,w := range (*adj)[s] {
        if !(*marked)[w] {
            dfs(marked, adj, w)
        }
    }
}