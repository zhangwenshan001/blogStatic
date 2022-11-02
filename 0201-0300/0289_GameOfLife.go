func gameOfLife(board [][]int)  {
    for i:=0;i<len(board);i++ {
        for j:=0;j<len(board[0]);j++ {
            ln := liveNeighbors(board, i, j)
            if board[i][j] == 1 && (ln < 2 || ln > 3) {
                board[i][j] = 2
            } 
            if board[i][j] == 0 && ln == 3 {
                board[i][j] = -1
            }
        }
    }
    
    for i:=0;i<len(board);i++ {
        for j:=0;j<len(board[0]);j++ {
            if board[i][j] == 2 {
                board[i][j] = 0
            }
            
            if board[i][j] == -1 {
                board[i][j] = 1
            }
        }
    }
}

func liveNeighbors(board [][]int, i int, j int) int {
    count := 0
    for di:=-1;di<=1;di++ {
        for dj:=-1;dj<=1;dj++ {
            if (di != 0 || dj != 0) && i+di >=0 && j+dj>=0 && i+di < len(board) && j+dj< len(board[0]) && board[i+di][j+dj] > 0 {
                count += 1
            }
        }
    }
    
    return count
}
