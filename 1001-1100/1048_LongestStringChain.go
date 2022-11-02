func longestStrChain(words []string) int {
    m := make(map[int][]string)
    count := make(map[string]int)
    
    minl,maxl,l := 17, 0, 0
    for _, word := range words {
        l = len(word)
        if l < minl {
            minl = l
        }
        if l > maxl {
            maxl = l
        }
        if m[l] == nil {
            m[l] = []string{word}
        } else {
            m[l] = append(m[l], word)
        }
    }
    // fmt.Println(m)
    res := 0
    for i:= minl;i<=maxl;i++ {
        if m[i] == nil {
            continue
        }
        for j:=0;j<len(m[i]);j++ {
            count[m[i][j]] = 1
            for k:=0;k<len(m[i-1]);k++ {
                if check(m[i-1][k], m[i][j]) {
                    if count[m[i-1][k]] + 1 > count[m[i][j]] {
                        count[m[i][j]] = count[m[i-1][k]] + 1
                    }   
                }
            }
            if count[m[i][j]] > res {
                res = count[m[i][j]]
            }
        }
    }
    // fmt.Println(count)
    return res  
}


func check(s1 string, s2 string) bool {
    for i,j:=0,0;i<len(s1) && j<len(s2);{
        if s1[i] == s2[j] {
            i++
            j++
        } else {
            j++
        }
        if i == len(s1) {
            return true
        }
    }
    return false
}