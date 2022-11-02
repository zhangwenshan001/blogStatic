func maximumSum(nums []int) int {
    m := make(map[int][]int)
    
    max := -1
    
    for i:=0;i<len(nums);i++ {
        curSum := sumOfDigits(nums[i])
        if _, ok := m[curSum]; ok {
            if m[curSum][0] + nums[i] > max {
                max = m[curSum][0] + nums[i]
            }
            if len(m[curSum]) == 1 {
                if m[curSum][0] >= nums[i] {
                    m[curSum] = append(m[curSum], nums[i])
                } else {
                    m[curSum] = append(m[curSum], m[curSum][0])
                    m[curSum][0] = nums[i]
                }
            } else {
                if nums[i] >= m[curSum][0] {
                    m[curSum][1] = m[curSum][0]
                    m[curSum][0] = nums[i]
                } else if nums[i] >= m[curSum][1] {
                    m[curSum][1] = nums[i]
                }
            }
        } else {
            m[curSum] = append(m[curSum], nums[i])
        }
    }
    
    return max
}

func sumOfDigits(num int) int {
    sum := 0
    for num != 0 {
        sum = sum + num % 10
        num = num / 10
    }
    
    return sum
}