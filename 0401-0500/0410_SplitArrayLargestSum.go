const INT_MAX = int(^uint(0) >> 1)

var memo [][]int

func splitArray(nums []int, m int) int {
    n := len(nums)
    prefixSum := make([]int, n + 1)
    for i:=0;i<n;i++ {
       prefixSum[i+1] = prefixSum[i] + nums[i]
    }

    memo = make([][]int, n + 1)
    for i:=0;i<=n;i++ {
        memo[i] = make([]int, m+1)
    }
    fmt.Print(memo)
    
    return minMaxSum(prefixSum, 0, m)
    
}

func minMaxSum(prefixSum []int,i int, m int) int {    
    n := len(prefixSum) - 1
    
    if memo[i][m] != 0 {
        return memo[i][m]
    }
    
    if m == 1 {
        memo[i][m] = prefixSum[n] - prefixSum[i]
        return memo[i][m]
    }
    
    minMax := INT_MAX
    for j:= i;j<=n-m;j++ {
        firstSplitSum := prefixSum[j + 1] - prefixSum[i]
        largestSplitSum := max(firstSplitSum,  minMaxSum(prefixSum, j+1, m-1))
        minMax = min(minMax, largestSplitSum)
        if firstSplitSum >= minMax {
            break
        }
    }
    
    memo[i][m] = minMax
    return memo[i][m]
}

func min(a, b int) int {
    if a < b {
        return a
    }
    return b
}

func max(a, b int) int {
    if a > b {
        return a
    }
    return b
}