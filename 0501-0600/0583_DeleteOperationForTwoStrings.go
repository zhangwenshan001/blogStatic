func minDistance(word1 string, word2 string) int {
    dp := make([][]int, len(word1))
    for i:=0;i<len(word1);i++ {
        dp[i] = make([]int, len(word2))
        for j:=0;j< len(word2);j++ {
            dp[i][j] = -1
        }
    }
    
    return minDist(word1, word2, &dp, 0, 0)
}


func minDist(word1 string, word2 string, dp *[][]int, i int, j int) int {
    if i >= len(word1) {
        return len(word2) - j 
    } 
    if j >= len(word2) {
        return len(word1) - i
    }
    
    if (*dp)[i][j] >= 0 {
        return  (*dp)[i][j]
    }
    r1 := minDist(word1, word2, dp, i+1, j) + 1
    r2 := minDist(word1, word2,dp,  i, j+1) + 1
    var r3 int
    if word1[i] == word2[j] {
        r3 = minDist(word1, word2,dp, i+1, j+1) 
    } else {
        r3 = minDist(word1, word2,dp, i+1, j+1) + 2
    }
    
    if r1 <= r2 && r1 <= r3 {
        (*dp)[i][j] = r1
        return r1
    }
    if r2 <= r1 && r2 <= r3 {
        (*dp)[i][j] = r2
        return r2
    }
    
    (*dp)[i][j] = r3
    return r3
    
    
}