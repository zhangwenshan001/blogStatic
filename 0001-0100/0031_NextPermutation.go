func nextPermutation(nums []int) {
	i := len(nums) - 2
	for ; i >= 0; i-- {
		if nums[i+1] > nums[i] {
			break
		}
	}

	j := len(nums) - 1
	if i >= 0 {
		for ; j > i; j-- {
			if nums[j] > nums[i] {
				break
			}
		}
		nums[i] = nums[i] + nums[j]
		nums[j] = nums[i] - nums[j]
		nums[i] = nums[i] - nums[j]
	}

	for j, k := i+1, len(nums)-1; j < k; j, k = j+1, k-1 {
		nums[k] = nums[k] + nums[j]
		nums[j] = nums[k] - nums[j]
		nums[k] = nums[k] - nums[j]
	}

}