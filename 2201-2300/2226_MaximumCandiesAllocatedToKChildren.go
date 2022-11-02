func maximumCandies(candies []int, k int64) int {
    var min, max int
    for _, v := range candies {
        if v > max {
            max = v
        }
    }
    
    var count int64
    var mid int
    for min + 1 < max {
        count = 0
        mid = (min + max) / 2
        for _,v := range candies {
            count += int64(v / mid)
            if count >= k {
                min = mid
                break
            }
        }
        if count < k {
            max = mid
        }
    }
    
    count = 0
    for _,v := range candies {
        count += int64(v / max)
        if count >= k {
            return max
        }
    }
    
    return min
}