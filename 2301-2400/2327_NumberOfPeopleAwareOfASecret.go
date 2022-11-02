func peopleAwareOfSecret(n int, delay int, forget int) int {
    toKnow := make([]int, forget)
    total := 0
    
    toKnow[forget-1] = 1
    total = 1
    for i:=2;i<=n;i++ {
        a := 0
        toForget := toKnow[0]
        for j:= 0;j < forget;j++ {
            if j <= forget-delay && j > 0 {
                a = (a + toKnow[j]) % 1000000007
            }
            if j< forget - 1 {
                toKnow[j] = toKnow[j+1]
            }
        }
        toKnow[forget-1] = a
        total =  (total - toForget + toKnow[forget-1]) % 1000000007
        // fmt.Println(toKnow)
        // fmt.Println("day", i, ": toKnow:", a , " toForget:", toForget, " total:", total)
        
    }
    if total < 0 {
        return total + 1000000007
    }
    return total
}