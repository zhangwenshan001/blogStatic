type NumMatrix struct {
    Matrix [][]int
}


func Constructor(matrix [][]int) NumMatrix {
    for i:=0;i<len(matrix);i++ {
        for j:=0;j<len(matrix[0]);j++ {
            if i == 0 {
                if j > 0 {
                    matrix[i][j] = matrix[i][j] + matrix[i][j-1]
                } 
            } else {
                if j == 0 {
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j]
                } else {
                    matrix[i][j] = matrix[i][j] + matrix[i-1][j] + matrix[i][j-1] - matrix[i-1][j-1]
                }
            }
        }
    }
    return NumMatrix{Matrix:matrix}
}


func (this *NumMatrix) SumRegion(row1 int, col1 int, row2 int, col2 int) int {
    if row1 == 0 && col1 == 0 {
        return this.Matrix[row2][col2]
    } else if row1 == 0 {
        return this.Matrix[row2][col2] - this.Matrix[row2][col1-1]
    } else if col1 == 0 {
        return this.Matrix[row2][col2] - this.Matrix[row1-1][col2]
    } else {
        return this.Matrix[row2][col2] - this.Matrix[row1-1][col2] - this.Matrix[row2][col1-1] + this.Matrix[row1-1][col1-1]
    }
    
}


/**
 * Your NumMatrix object will be instantiated and called as such:
 * obj := Constructor(matrix);
 * param_1 := obj.SumRegion(row1,col1,row2,col2);
 */