func canVisitAllRooms(rooms [][]int) bool {
    marked := make([]bool, len(rooms))
    dfs(&marked, &rooms, 0)
    
    for i:=1;i<len(rooms);i++ {
        if !marked[i] {
            return false
        }
    }
    
    return true
}

func dfs(marked *[]bool, adj *[][]int, s int) {
    (*marked)[s] = true
    for _, w := range (*adj)[s] {
        if !(*marked)[w] {
            dfs(marked, adj, w)
        }
    }
}