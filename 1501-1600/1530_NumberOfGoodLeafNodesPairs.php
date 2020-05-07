/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     public $val = null;
 *     public $left = null;
 *     public $right = null;
 *     function __construct($val = 0, $left = null, $right = null) {
 *         $this->val = $val;
 *         $this->left = $left;
 *         $this->right = $right;
 *     }
 * }
 */
class Solution {
    private $res = 0;
    private $distance;

    /**
     * @param TreeNode $root
     * @param Integer $distance
     * @return Integer
     */
    function countPairs($root, $distance) {
        $this->distance = $distance;
        $this->handle($root);
        
        return $this->res;
    }
    
    function handle($p) {
        if($p == null) {
            return [];
        }
        if ($p->left == null && $p->right == null) {
            return [1 => 1];
        }
        $leftLeaves = $this->handle($p->left);
        $rightLeaves = $this->handle($p->right);
        $cl = count($leftLeaves);
        $cr = count($rightLeaves);
        if ($cl == 0) {
            $curLeaves = [];
            foreach($rightLeaves as $key => $value) {
                $curLeaves[$key+1] = $value;
            }
            return $curLeaves;    
        }
        if ($cr == 0) {
            $curLeaves = [];
            foreach($leftLeaves as $key => $value) {
                $curLeaves[$key+1] = $value;
            }
            return $curLeaves;
        }
       
        
        foreach($leftLeaves as $key1 => $value1) {
            foreach($rightLeaves as $key2 => $value2) {
                if ($key1 + $key2 <= $this->distance) {
                    $this->res += $value1 * $value2;
                }
            }
        }
        
        $curLeaves = [];
        foreach($leftLeaves as $key => $value) {
            $curLeaves[$key+1] = $value;
        }
        foreach($rightLeaves as $key => $value) {
            if (isset($curLeaves[$key+1])) {
                $curLeaves[$key+1] += $value;
            } else {
                $curLeaves[$key+1] = $value;
            }
        }
        
        return $curLeaves;  
    }
}
