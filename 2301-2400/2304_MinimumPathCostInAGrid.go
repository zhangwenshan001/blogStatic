func minPathCost(grid [][]int, moveCost [][]int) int {
    minTotal := make([][]int, len(grid))
    minTotal[0] = grid[0]
    
    for i:=1;i<len(grid);i++ {
        minTotal[i] = make([]int, len(grid[0]))
        for j:=0;j<len(grid[0]);j++ {
            minJ := findMinPre(grid, moveCost, minTotal,i, j)
            minTotal[i][j] = minTotal[i-1][minJ] + moveCost[grid[i-1][minJ]][j] + grid[i][j]
        }
    }
    fmt.Println(minTotal)
    res := 2147483647
    for j:=0;j<len(grid[0]);j++ {
        if minTotal[len(grid)-1][j] < res {
            res =  minTotal[len(grid)-1][j] 
        }
    }
    return res

}

func findMinPre(grid [][]int, moveCost [][]int, minTotal[][]int, i int, j int) int {
    m := 2147483647
    minJ := 0
    for k:=0;k<len(grid[0]);k++ {
        if moveCost[grid[i-1][k]][j] + minTotal[i-1][k] < m {
            m = moveCost[grid[i-1][k]][j] + minTotal[i-1][k]
            minJ = k
        }
    }
      
    return minJ
}
