func findCircleNum(isConnected [][]int) int {
    marked := make([]bool, len(isConnected))
    count := 0
    
    for i:=0;i<len(isConnected);i++ {
        if !marked[i] {
            dfs(&marked, &isConnected, i)
            count++
        }
    }
    return count
}


func dfs(marked *[]bool, isConnected *[][]int, s int) {
    (*marked)[s] = true
    for i:=0;i<len(*isConnected);i++ {
        if !(*marked)[i] && (*isConnected)[s][i] == 1 {
            dfs(marked, isConnected, i)
        }
    }
}

