func minimumNumbers(num int, k int) int {
    if num == 0 {
        return 0
    }
    ud := num % 10
    if k == ud {
        return 1
    }
    
    if k == 0 {
        return -1
    }
    
    if num < k {
        return -1
    }
    
    for ud <= num && ud <=100 {
        if ud >= k && ud % k == 0 {
            return ud/k
        }
        ud = 10 + ud
    }
    
    return -1
}