
func fourSum(nums []int, target int) [][]int {
	sort.Ints(nums)
	return kSum(nums, target, 4, 0)
}

func kSum(nums []int, target int, k int, index int) [][]int {
	var resArray [][]int

	if k == 3 {
		for i := index; i < len(nums)-1; i++ {
			if i > index && nums[i] == nums[i-1] {
				continue
			}
			twoSumArray := twoSum(nums, target-nums[i], i+1)
			for _, v := range twoSumArray {
				resArray = append(resArray, append(v, nums[i]))
			}
		}

		return resArray
	}

	for i := index; i < len(nums); i++ {
		if i > index && nums[i] == nums[i-1] {
			continue
		}
		nextSumArray := kSum(nums, target-nums[i], k-1, i+1)

		for _, v := range nextSumArray {
			resArray = append(resArray, append(v, nums[i]))
		}
	}

	return resArray
}

func twoSum(nums []int, target int, index int) [][]int {
	var resArray [][]int

	if index >= len(nums)-1 || target < nums[index]*2 || target > nums[len(nums)-1]*2 {
		return [][]int{}
	}

	for i, j := index, len(nums)-1; i < j; {
		if i > index && nums[i] == nums[i-1] {
			i++
			continue
		}
		if target == nums[i]+nums[j] {
			resArray = append(resArray, []int{nums[i], nums[j]})
			i++
			continue
		}
		if target > nums[i]+nums[j] {
			i++
			continue
		}
		if target < nums[i]+nums[j] {
			j--
			continue
		}
	}

	return resArray

}