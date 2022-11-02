func findRedundantConnection(edges [][]int) []int {
    ids := make([]int, len(edges))
    for i:=0;i<len(edges);i++ {
        ids[i] = i
    }
    
    for _,edge := range edges {
        if find(&ids, edge[0]-1) == find(&ids, edge[1]-1) {
            return edge
        } else {
            quickUnion(&ids, edge[0]-1, edge[1]-1)
        }
    }
    
    return []int{}
}

func quickUnion(ids *[]int, p int, q int) {
    pr, qr := find(ids, p), find(ids, q)
    (*ids)[qr] = pr
}

func find(ids *[]int, p int) int {
    for p != (*ids)[p] {
        p = (*ids)[p]
    }
    
    return p
}

func union(ids *[]int, p int, q int) {
    pr, qr := quickFind(ids, p), quickFind(ids, q)
    
    for i:=0;i<len(*ids);i++ {
        if (*ids)[i] == qr {
            (*ids)[i] = pr
        }
    }
}

func quickFind(ids *[]int, p int) int {
    return (*ids)[p]
}