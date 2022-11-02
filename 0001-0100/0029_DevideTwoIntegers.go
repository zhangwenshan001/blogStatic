func divide(dividend int, divisor int) int { //-2147483648 ～ 2147483647
	if dividend == -2147483648 && divisor == -1 {
		return 2147483647
	}

	flag := 1 // 1 结果为正 -1 结果为负
	m := 1    //1 正数相除 -1负数相除

	if dividend > 0 && divisor < 0 {
		flag = -1
		divisor = -divisor
	}
	if dividend < 0 {
		m = -1
		if divisor > 0 {
			flag = -1
			divisor = -divisor
		}
	}

	if (divisor > 0 && divisor > dividend) || (divisor < 0 && divisor < dividend) {
		return 0
	}

	if divisor == 1 || divisor == -1 {
		return divisor * flag * dividend
	}

	if dividend == divisor || divisor >= 1073741824 || divisor < -1073741824 {
		return flag
	}

	res := 0

	if m == 1 {
		for dividend >= divisor {
			tmp := divisor
			i := 0
			for ; dividend >= tmp && tmp < 1073741824; i++ {
				tmp = tmp << 1
			}
			if dividend == tmp {
				dividend = 0
				res = res + 1<<i
			} else {
				dividend = dividend - tmp>>1
				res = res + 1<<(i-1)
			}
		}
	}

	if m == -1 {
		for dividend <= divisor {
			tmp := divisor
			i := 0
			for ; dividend <= tmp && tmp >= -1073741824; i++ {
				tmp = tmp << 1
			}
			if dividend == tmp {
				dividend = 0
				res = res + 1<<i
			} else {
				dividend = dividend - tmp>>1
				res = res + 1<<(i-1)
			}
		}
	}

	return flag * res
}