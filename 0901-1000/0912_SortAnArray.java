class Solution {
    protected int[] aux;

    public int[] sortArray(int[] nums) {
        // quickSort(nums, 0, nums.length-1);
        aux = new int[nums.length];
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }

    // merge sort
    public void mergeSort(int[] nums,int start, int end)
    {
        if (start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private void merge(int[] nums, int start, int mid, int end)
    {
        for(int i = start;i<=end;i++) {
            aux[i] = nums[i];
        }
        
        int idx = start;
        int p = mid + 1;

        while (idx <= end) {
            if (start > mid) {
                nums[idx++] = aux[p++];
            } else if (p > end) {
                nums[idx++] =  aux[start++];
            } else {
                if (aux[start] < aux[p]) {
                    nums[idx++] = aux[start++];
                } else {
                    nums[idx++] = aux[p++];
                }
            }
        }

    }

    //quick sort
    public void quickSort(int[] nums,int start, int end) {
        if (start >= end) return;
        int k = quick(nums, start, end);
        quickSort(nums, start, k-1);
        quickSort(nums, k+1, end);
    }

    private int quick(int[] nums,int start, int end)
    {
        int crrNum = nums[start];
        while(start < end) {
            while(start < end && nums[end]>=crrNum) end--;
            nums[start] = nums[end];
            while(start<end && nums[start]<=crrNum) start++;
            nums[end] = nums[start];
        }

        nums[start] = crrNum;
        return start;
    }
}