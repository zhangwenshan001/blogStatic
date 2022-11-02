func searchMatrix(matrix [][]int, target int) bool {
    var m, n int = len(matrix), len(matrix[0])
    var i, j int = 0, m*n-1
    var mid, midi, midj int
    for;i<=j; {
        mid = (i + j) / 2
        midi = mid / n
        midj = mid % n
        
        if matrix[midi][midj] == target {
            return true
        } else if matrix[midi][midj] < target {
            i = mid + 1
        } else {
            j = mid - 1
        }
    }
    
    return false
}