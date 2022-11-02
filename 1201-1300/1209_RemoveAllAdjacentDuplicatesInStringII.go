func removeDuplicates(s string, k int) string {
    sArr := []byte(s)
    
    res := make([]byte, len(sArr))
    count := make([]int, len(sArr))
    
    pos := -1
    
    for i:=0;i<len(sArr);i++ {
        if pos >= 0 && sArr[i] == res[pos] {
            if count[pos] + 1 == k {
                pos = pos + 1 - k
            } else {
                pos++
                res[pos] = sArr[i]
                count[pos] = count[pos-1] + 1
            }
        } else {
            pos++
            res[pos] = sArr[i]
            count[pos] = 1
        }
    }
    return string(res[:pos+1])
}