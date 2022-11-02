func threeSumMulti(arr []int, target int) int {
    m := make(map[int]int)
    var uniqArr []int
    
    for i:=0;i<len(arr);i++ {
        if val, ok := m[arr[i]]; ok {
            m[arr[i]] = val + 1
        } else {
            m[arr[i]] = 1
            uniqArr = append(uniqArr, arr[i])
        }
    }
    
    sort.Ints(uniqArr)    
    c := 0
    var t int
    for j:=len(uniqArr)-1;j>=0;j-- {
        for i:=0;i<=j;i++ {
            t = target - uniqArr[i] - uniqArr[j]
            if t < uniqArr[i] || t > uniqArr[j] {
                continue
            }  
            if val, ok := m[t]; ok {
            if uniqArr[i] == uniqArr[j] {
                c = (c + val * (val-1) * (val-2) / 6) % 1000000007
            } else if uniqArr[i] == t {
                c = (c + (val * (val-1) / 2) * m[uniqArr[j]]) % 1000000007
            } else if uniqArr[j] == t {
                c = (c + (val * (val-1) / 2) * m[uniqArr[i]]) % 1000000007
            } else {
                c = (c + m[uniqArr[i]] * m[uniqArr[j]] * val) % 1000000007
            } 
        }
        }
    }
    
    return c
}