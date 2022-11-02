func maxAreaOfIsland(grid [][]int) int {
    marked := make([][]bool, len(grid))
    for i:=0;i<len(grid);i++ {
        marked[i] = make([]bool, len(grid[0]))
    }
    
    maxArea := 0
    
    for i:=0;i<len(grid);i++ {
        for j:=0;j<len(grid[0]);j++ {
            if !marked[i][j] && grid[i][j] == 1 {
                curArea := 0
                dfs(&grid, &marked, i, j, &curArea)
                
                if curArea > maxArea {
                    maxArea = curArea
                }
            }
        }
    }
    
    return maxArea
}

func dfs(grid *[][]int, marked *[][]bool, i int, j int, curArea *int) {
    (*marked)[i][j] = true
    
    if (*grid)[i][j] == 0 {
        return 
    }
    
    *curArea = *curArea + 1
    if i > 0 && !(*marked)[i-1][j] {
        dfs(grid, marked,i-1,j,curArea)
    }
    
    if i < len(*grid)-1 && !(*marked)[i+1][j] {
         dfs(grid, marked,i+1,j,curArea)
    }
    
    if j > 0 && !(*marked)[i][j-1] {
         dfs(grid, marked,i,j-1,curArea)
    }
    
    if j < len((*grid)[0]) - 1 && !(*marked)[i][j+1] {
        dfs(grid, marked,i,j+1,curArea)
    }
}

