func combinationSum2(candidates []int, target int) [][]int {
    
    nc := make(map[int]int)
    var k []int
    
    for _,num := range candidates {
        if _, ok := nc[num]; ok {
            nc[num] = nc[num] + 1
        } else {
            nc[num] = 1
            k = append(k, num)
        }
    }
    
    sort.Ints(k)
    res := core(&nc, &k, 0, target)
    
    return res
}

func core(nc *map[int]int, k *[]int, cur int, target int) [][]int{
    var res [][]int
    if cur >= len(*k) {
        return res
    }
    curKey := (*k)[cur]
    
    if target < curKey {
        return res
    }
    
    if target == curKey && (*nc)[target] > 0 {
        res = append(res, []int{target})
    }
    //if we don't use this one
    var tmpRes [][]int
    tmpRes = core(nc, k, cur+1, target)
    for i:=0;i<len(tmpRes);i++ {
        res = append(res, tmpRes[i])
    }
    
     // if use cur 
    if (*nc)[curKey] > 0 {
        (*nc)[curKey] = (*nc)[curKey] - 1
        if (*nc)[curKey] == 0 {
            tmpRes = core(nc, k, cur+1, target-curKey)
        } else {
            tmpRes = core(nc, k, cur, target-curKey)
        }
        
        for i:=0;i<len(tmpRes);i++ {
            tmpRes[i] = append(tmpRes[i], curKey)
            res = append(res, tmpRes[i])
        }
        (*nc)[curKey] = (*nc)[curKey] + 1
    }
    
    // fmt.Println(cur, curKey, nc, res)
    return res
}    
