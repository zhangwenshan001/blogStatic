func longestSubsequence(s string, k int) int {
    oneNum := 0
    zeroNum := 0
    n := 0
    l := len(s)
    if s[l-1] == '0' {
        zeroNum = 1 
    } else {
        oneNum = 1
        n = 1
    }
    for i:=1;i<l;i++ {
        if s[l-1-i] == '0' {
            zeroNum = zeroNum + 1
        } else {
            cn := 2 << (i-1)
            if cn <= 1000000000 && cn >=1 {
                n = n + cn
                if n <= k && n <= 1000000000 && n >= 1 {
                    oneNum = oneNum + 1
                }
            }
        }
        // fmt.Println(n)
    }
    // fmt.Println(oneNum, zeroNum)
    
    return oneNum + zeroNum
}