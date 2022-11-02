func checkIfPrerequisite(numCourses int, prerequisites [][]int, queries [][]int) []bool {
    adj := make([][]int, numCourses)
    for _, edge := range prerequisites {
        adj[edge[0]] = append(adj[edge[0]], edge[1])
    }
    
    marked := make([]bool, numCourses)
    flag := make([][]bool, numCourses)
    for i:=0;i<numCourses;i++ {
        flag[i] = make([]bool, numCourses)
    }
    for i:=0;i<numCourses;i++ {
        if !marked[i] {
            dfs(&marked, &adj, &flag, i)
        }
    }
    
    res := make([]bool, len(queries)) 
    for i:=0;i<len(queries);i++ {
        res[i] = flag[queries[i][0]][queries[i][1]]
    }
    
    return res
}

func dfs(marked *[]bool, adj *[][]int, flag *[][]bool, s int) {
    (*marked)[s] = true
     
    for _, w := range (*adj)[s] {
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