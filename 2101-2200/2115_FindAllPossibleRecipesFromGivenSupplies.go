func findAllRecipes(recipes []string, ingredients [][]string, supplies []string) []string {
    suppliesNum := len(supplies) 
    recipesNum := len(recipes) 
    
    n := suppliesNum + recipesNum
    nmap := make(map[string]int)
    for i:=0;i<suppliesNum;i++ {
        nmap[supplies[i]] = i
    }
    for i:=0;i<recipesNum;i++ {
        nmap[recipes[i]] = i+suppliesNum
    }
    
    // flag := make([]bool, recipesNum)
    flag := make([]int, n) //0 unknown 1 can't  -1 can
    adj := make([][]int, n)
    for i:=0;i<recipesNum;i++ {
        for j:=0;j<len(ingredients[i]);j++ {
            igt, ok := nmap[ingredients[i][j]]
            if !ok {
                flag[nmap[recipes[i]]] = 1
            } else {
                adj[nmap[recipes[i]]] = append(adj[nmap[recipes[i]]], igt) //reverse graph
            }
        }
    }
            // fmt.Println(flag)
    
    onStack := make([]bool, n)
    
    for i:=0;i<recipesNum;i++ {
        if flag[nmap[recipes[i]]] == 0 {
            dfs(&flag,&onStack, &adj, nmap[recipes[i]])
        }
    }
     // fmt.Println(flag)
    var res []string
    for i:=0;i<recipesNum;i++ {
        if flag[nmap[recipes[i]]] == -1 {
            res = append(res, recipes[i])
        }
    }
    
    return res
}

func dfs(hasCircle *[]int, onStack *[]bool, adj *[][]int, s int) {
    (*hasCircle)[s] = -1 
    (*onStack)[s] = true
    
    for _, w := range (*adj)[s] {
        if (*onStack)[w] {
            (*hasCircle)[s] = 1
            break
        }
        if (*hasCircle)[w] == 0 {
            dfs(hasCircle, onStack, adj, w)
        }
        
        if (*hasCircle)[w]==1 {
            (*hasCircle)[s] = 1
            break
        }
    }
    
    (*onStack)[s] = false
}