func twoCitySchedCost(costs [][]int) int {
    sum := 0
    d := make([]int,len(costs), len(costs))
    for i:=0;i<len(costs);i++ {
        sum += costs[i][0]
        d[i] = costs[i][1] - costs[i][0]
    }
    
    sort.Ints(d)     
    for i:=0;i<len(d)/2;i++ {
        sum += d[i]
    }
    
    return sum;
}