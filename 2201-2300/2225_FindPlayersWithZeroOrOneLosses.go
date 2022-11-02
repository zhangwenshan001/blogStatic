func findWinners(matches [][]int) [][]int {
    winners := make(map[int]int)
    losers := make(map[int]int)
    
    for _, match := range matches {
        if winners[match[0]] == 0 {
            winners[match[0]] = 1
        }
    }
    
    for _, match := range matches {
        if winners[match[1]] == 1 {
            delete(winners, match[1])
        }
        losers[match[1]]++
    }
    
    for k, v := range losers {
        if v > 1 {
            delete(losers, k)
        }
    }
    
    var wks, lks []int
    for k:= range winners {
        wks = append(wks, k)
    }
    
    for k:= range losers {
        lks = append(lks, k)
    }
    sort.Ints(wks)      
    sort.Ints(lks)    
    return [][]int{wks, lks}
}