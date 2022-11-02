func latestTimeCatchTheBus(buses []int, passengers []int, capacity int) int {
    sort.Ints(buses)
    sort.Ints(passengers)
    
    fmt.Println(buses)
    fmt.Println(passengers)
    
    i, j := 0,0
    bpn := make([]int, len(buses))
    curNum := 0
    for ;j<len(passengers);j++ {
        if passengers[j] <= buses[i] && curNum < capacity {
            curNum = curNum + 1
            bpn[i] = curNum
        } else {
            for i < len(buses) && (buses[i] < passengers[j] || bpn[i] == capacity){
                i++
            }
            if  i < len(buses) {
                curNum = 1
                bpn[i] = 1
            }
        }
        if i >= len(buses) {
            break
        }
        // fmt.Println(bpn)
        // fmt.Println(i, j, curNum)
        
    }
    
    if i == len(buses) {
        i--
        j--
    }
    
    if j == len(passengers) {
        j--
    } 
    
    if i != len(buses) - 1 {
        return buses[len(buses) - 1]
    }

    
    if bpn[i] < capacity && (j<0 || passengers[j] != buses[i]) {
        return buses[i]
    }
    
    
    for ;j>=1;j-- {
        if passengers[j]-1 != passengers[j-1] {
            return passengers[j] - 1
        }
    }
    return passengers[0]-1
}