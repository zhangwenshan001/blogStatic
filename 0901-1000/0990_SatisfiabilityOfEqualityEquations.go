func equationsPossible(equations []string) bool {
    ids := make([]byte, 26)
    var i byte
    for i=0;i<26;i++ {
        ids[i] = i
    }
    
    for _, equation := range equations {
        if equation[1] == '=' {
            quickUnion(&ids, byte(equation[0]) - byte('a'), byte(equation[3]) - byte('a'))
        }
    }
    
    for _, equation := range equations {
        if equation[1] == '!' && find(&ids, byte(equation[0]) - byte('a')) == find(&ids, byte(equation[3]) - byte('a')) {
            return false
        }
    }
    
    return true
}

func quickUnion(ids *[]byte, p byte, q byte) {
    pr, qr := find(ids, p), find(ids, q)
    (*ids)[qr] = pr
}

func find(ids *[]byte, p byte) byte {
    for p != (*ids)[p] {
        p = (*ids)[p]
    }
    
    return p
}