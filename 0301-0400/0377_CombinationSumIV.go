class Solution {
    
    private $dp = [];
    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function combinationSum4($nums, $target) {
        if (isset($this->dp[$target])) {
            return $this->dp[$target];
        }
        if ($nums == null || count($nums) == 0) {
            return 0;
        }
        
        foreach($nums as $num) {
            if ($num == $target) {
                $this->dp[$target] = $this->dp[$target] ? $this->dp[$target] + 1 : 1;
            } else if ($num < $target) {
                $nextRes = $this->combinationSum4($nums,$target - $num);
                $this->dp[$target] = $this->dp[$target] ? $this->dp[$target] + $nextRes : $nextRes;
            }
        }
        return $this->dp[$target] ?? 0;   
    }
}