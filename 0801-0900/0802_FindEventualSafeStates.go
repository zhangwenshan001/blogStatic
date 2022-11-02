func eventualSafeNodes(graph [][]int) []int {
    status :=  make([]int, len(graph)) // 0 unknow 1 safe 2 unsafe
    var res []int
    
    for i:=0;i<len(graph);i++ {
        if dfs(&status, &graph, i) {
            res = append(res, i)
        }
    }
    
    return res
}

func dfs(status *[]int, adj *[][]int, s int) bool { 
    if (*status)[s] > 0 {
        return (*status)[s] == 1 // return if it's safe
    }
    
    (*status)[s] = 2
    for _, w := range (*adj)[s] {
        if !dfs(status, adj, w) {
            return false
        }
    }
    (*status)[s] = 1
    return true
}