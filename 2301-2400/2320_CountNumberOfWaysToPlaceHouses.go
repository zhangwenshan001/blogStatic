func countHousePlacements(n int) int {
    if n == 1 {
        return 4
    }
    
    
    n0,n1,n2,n3 := 1,1,1,1

    for i:=2;i<=n;i++ {
        n0,n1,n2,n3 = (n0+n1+n2+n3) % 1000000007, (n0+n2) % 1000000007, (n0+n1) % 1000000007, n0 % 1000000007
    }
    
    return (n0+n1+n2+n3)  % 1000000007
}