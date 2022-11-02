func countPairs(n int, edges [][]int) int64 {
    uf := weightedQuickUnionFind(n, edges)
    m := make(map[int]int)
    for i:=0;i<n;i++ {
        m[find(&uf, i)]++
    }
    var res int64 = 0
    
    for _, count:= range m {
        res = res + int64(count * (n-count))
    }

    
    return res/2
}

func find(ids *[]int, i int) int {
	for (*ids)[i] != i {
		i = (*ids)[i]
	}
	return i
}

// Weighted Quick Union
func weightedQuickUnionFind(v int, g [][]int) []int {
	uf := make([]int, v)
	sz := make([]int, v)
	for i := 0; i < len(uf); i++ {
		uf[i] = i
		sz[i] = 1
	}

	for _, vv := range g {
		weightedQuickUnion(&uf, &sz, vv[0], vv[1])
	}

	return uf
}


func weightedQuickUnion(ids *[]int, sz *[]int, p int, q int) {
	pr, qr := find(ids, p), find(ids, q)
	if pr == qr {
		return
	}

	if (*sz)[pr] < (*sz)[qr] {
		(*ids)[pr] = (*ids)[qr]
		(*sz)[qr] += (*sz)[pr]
	} else {
		(*ids)[qr] = (*ids)[pr]
		(*sz)[pr] = (*sz)[qr]
	}

}