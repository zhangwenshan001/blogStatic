func countVowelStrings(n int) int {
    na,ne,ni,no,nu := 1,1,1,1,1
    for i:=1;i<=n;i++{
        na,ne,ni,no,nu = na+ne+ni+no+nu, ne+ni+no+nu, ni+no+nu, no+nu, nu
    }
    return na
}