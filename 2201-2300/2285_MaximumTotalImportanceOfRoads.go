func maximumImportance(n int, roads [][]int) int64 {
    en := make([]int64, n)
    for _, edge := range roads {
        en[edge[0]] = en[edge[0]] + 1
        en[edge[1]] = en[edge[1]] + 1
    }
    
    sort.Slice(en, func(i, j int) bool {
        return en[i] < en[j]
    })
    // sort.Ints(en)   
    var res int64 = 0
    for i:=0;i<n;i++ {
        res = res + int64(i+1) * en[i]
    }
    return res
}