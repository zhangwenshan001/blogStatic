func minSumSquareDiff(nums1 []int, nums2 []int, k1 int, k2 int) int64 {
    diff := make([]int, len(nums1))
    for i:=0;i<len(nums1);i++ {
        if nums1[i] > nums2[i] {
            diff[i] = nums1[i] - nums2[i]
        } else {
            diff[i] = nums2[i] - nums1[i]
        }
    }
    
    k := k1 + k2
    // sort.Ints(diff)  //[0 0 0 7 7 17]
    
    var diffNums []int
    diffCount := make(map[int]int)
    
    for i:=0;i<len(diff);i++ {
        if _, ok := diffCount[diff[i]]; !ok {
            diffCount[diff[i]] = 1
            diffNums = append(diffNums, diff[i])
        } else {
            diffCount[diff[i]] = diffCount[diff[i]] + 1
        }
    }
    
    sort.Ints(diffNums)
    idx := len(diffNums) - 1
    for idx > 0 && (diffNums[idx] - diffNums[idx-1]) * diffCount[diffNums[idx]] <= k {
        k = k - (diffNums[idx] - diffNums[idx-1]) * diffCount[diffNums[idx]]
        diffCount[diffNums[idx-1]] = diffCount[diffNums[idx]] + diffCount[diffNums[idx-1]]
        diffCount[diffNums[idx]] = 0
        idx--
    }
    
    if idx == 0 && diffNums[idx] * diffCount[diffNums[idx]] <= k {
        return 0
    }
    // fmt.Println(diffCount, diffNums)
    d := int (k / diffCount[diffNums[idx]])
    k = k % diffCount[diffNums[idx]]
    
    var res int64
    for i:=0;i<idx;i++ {
        res = res + int64(diffNums[i] * diffNums[i] * diffCount[diffNums[i]])
    }
    
    res = res + int64(k * (diffNums[idx]-d-1) * (diffNums[idx]-d-1)) + int64((diffNums[idx]-d) * (diffNums[idx]-d) * (diffCount[diffNums[idx]] - k))
    
    // fmt.Println(diffNums[idx+1], diffCount[diffNums[idx+1]])
    // fmt.Println(diffNums[idx], diffCount[diffNums[idx]])
    // fmt.Println(diffNums[idx-1], diffCount[diffNums[idx-1]])
    // fmt.Println(k)
    return int64(res)
}