func maximalNetworkRank(n int, roads [][]int) int {
    adj := make([][]bool, n)
    for i:=0;i<n;i++ {
        adj[i] = make([]bool, n)
    }
    
    cn := make([]int, n)
    for _, edge := range roads {
        adj[edge[0]][edge[1]] = true
        adj[edge[1]][edge[0]] = true
        cn[edge[0]] = cn[edge[0]] + 1
        cn[edge[1]] = cn[edge[1]] + 1
    }
    
    ec := make([][]int, n)
    for i:=0;i<n;i++ {
        ec[cn[i]] = append(ec[cn[i]], i)
    }
    
    // fmt.Println(ec)
    
    var first int
    maxFlag := true
    res := 0
    for i:=n-1;i>0;i-- {
        if len(ec[i]) == 0 {
            continue
        }
        if maxFlag && len(ec[i]) == 1 {
            first = i
            maxFlag = false
            continue
        } 
        
        if maxFlag { 
            for j := 0;j<len(ec[i])-1;j++ {
                for k:=j+1;k<len(ec[i]);k++ {
                    if !adj[ec[i][j]][ec[i][k]] {
                        // fmt.Println(ec[i][j], " ", ec[i][k])
                        return i * 2
                    } else {
                        res =  i*2-1
                    }
                }
            }
        } else {
            for j:=0;j<len(ec[i]);j++ {
                if !adj[ec[first][0]][ec[i][j]] {
                    // fmt.Println(ec[first][0], " ", j)
                    return first + i
                } else {
                    res = first + i - 1
                    // fmt.Println(ec[first][0], " ", j)
                    // fmt.Println(res)
                }
            }
        }
        return res
        
    }
    
    return 0
    
}

