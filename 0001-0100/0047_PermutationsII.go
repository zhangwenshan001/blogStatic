func permuteUnique(nums []int) [][]int {
    res := [][]int{}
    dfs(&res, 0, nums)
    return res
}

func dfs(res *[][]int, index int, nums []int) {
    if index == len(nums) - 1 { *res = append(*res, append([]int{}, nums...)) }
    used := make(map[int]bool)
    for i := index; i < len(nums); i++ {
        if _, ok := used[nums[i]]; ok { continue }
        nums[i], nums[index] = nums[index], nums[i]
        dfs(res, index + 1, nums)
        nums[i], nums[index] = nums[index], nums[i]
        used[nums[i]] = true
    }
}