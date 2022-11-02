class Solution {
    int start;
    int starth;
    int minutes;
    
    public int amountOfTime(TreeNode root, int start) {
        this.start = start;
        this.minutes = 0;
        dfs(root, false, 0);
        
        return minutes;
    }
    
    public int dfs(TreeNode p, boolean preInfected, int preh) { 
        if (p == null) {
            return 0;
        }
        int leftDist;
        int rightDist;
        if (!preInfected && p.val == start) {
            preInfected = true;
            this.starth = preh + 1;
            
            dfs(p.left, preInfected, preh + 1);
            dfs(p.right, preInfected, preh + 1);
            
            return -1;
        } else if (preInfected) {
            minutes = Math.max(minutes, (preh + 1 - starth));
            dfs(p.left, preInfected, preh + 1);
            dfs(p.right, preInfected, preh + 1);
            return 0;
        } else {
            leftDist = dfs(p.left, preInfected, preh + 1);
            rightDist = dfs(p.right, preInfected, preh + 1);
            if (leftDist < 0) {
                minutes = Math.max(minutes, (rightDist - leftDist));
                return leftDist - 1;
            } else if (rightDist < 0){
                minutes = Math.max(minutes, (leftDist - rightDist));
                return rightDist - 1;
            } else {
                return Math.max(leftDist, rightDist) + 1;
            }
        }  
    }
}
