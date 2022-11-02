func maximumXOR(nums []int) int {
    res := 0

    for i:=0;i<33;i++{
        flag := false
        for j:=0;j<len(nums);j++ {
            if nums[j] % 2 == 1 {
                flag = true
            }
            nums[j] = nums[j] >> 1
        }
        
        if flag {
            res = res + 1 << i
        }
    }
    return res
}