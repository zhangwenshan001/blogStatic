func generateMatrix(n int) [][]int {
    matrix := make([][]int, n)
    for k := range matrix {
        matrix[k] = make([]int, n)
    }
    
    left := 0
    right := n-1
    up := 0
    down := n-1
    
    mod := 1
    start := 1
    i,j:=0,0
    for start <= n*n {
        if mod == 1 {
            for j <= right {
                matrix[i][j] = start
                j++
                start++
            }
            up = i+1
            i++
            j = right
            mod = 2
        }

        if mod == 2 {
            for i <= down {
                matrix[i][j] = start
                i++
                start++
            }
            right = j-1
            j--
            i = down
            mod = 3
        }
        
        if mod == 3 {
           for j >= left {
                matrix[i][j] = start
               j--
               start++
            }
            down = i-1
            i--
            j = left
            mod = 4
        }

        if mod == 4 {
            for i >= up {
                matrix[i][j] = start
                i--
                start++
            }
            left = j+1
            j++
            i = up
            mod = 1
        }
    }
    
    return matrix
}