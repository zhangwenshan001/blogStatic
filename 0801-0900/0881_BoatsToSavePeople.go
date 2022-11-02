func numRescueBoats(people []int, limit int) int {
    sort.Sort(sort.Reverse(sort.IntSlice(people)))
    
    count := 0
    for i, j := 0,len(people)-1;i<=j; {
        if (i!=j && people[i] + people[j] <= limit) {
            i++
            j--
        } else {
            i++
        }
        
        count++
    }
    
    return count
}
