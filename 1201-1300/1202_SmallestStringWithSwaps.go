func smallestStringWithSwaps(s string, pairs [][]int) string {
    res := make([]byte, len(s))
    
    parent := make([]int, len(s))
    for i:=0;i<len(s);i++ {
        parent[i] = i
    }
    
    for _, pair := range pairs {
        union(pair[0], pair[1], parent)
    }
    
    children := make(map[int][]int)
    for i, iparent := range parent {
        r := findRoot(iparent, parent)
        children[r] = append(children[r], i)
    }
    
    for _, rootChildren := range children {
        var curSubS []byte
        for _, idx := range rootChildren {
            curSubS = append(curSubS, s[idx])
        }
        
        sort.Slice(curSubS, func(i,j int) bool {return curSubS[i] < curSubS[j]})
        sort.Ints(rootChildren)
        
        for i, idx := range rootChildren {
            res[idx] = curSubS[i]
        }
    }
    
    return string(res)
}

func findRoot(i int, parent []int) int {
    for i != parent[i] {
        i =  parent[i]
    }
    return i
}

func union(i int, j int, parent []int) {
    if rootI, rootJ := findRoot(i, parent), findRoot(j, parent); rootI != rootJ {
        parent[rootI], parent[i] = rootJ, rootJ
    }
}