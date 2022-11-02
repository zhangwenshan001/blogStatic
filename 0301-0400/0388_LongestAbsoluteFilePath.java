class Solution {
    public int lengthLongestPath(String input) {
        int start = 0;
        int end = 0;
        int depth = 0;
        boolean isFile = false;
        Path p = null;
        int max = 0;
        for (int i = 0;i<input.length();i++) {
            if (input.charAt(i) == '\t') {
                depth++;
            }
            if (input.charAt(i) == '.') {
                isFile = true;
            }
            if (input.charAt(i) == '\n' || i == input.length()-1) {
                end = i;
                if (i == input.length()-1) {
                    end = i+1;
                }
                while(p!=null && p.depth > depth-1) {
                    p = p.pre;
                }
                Path cur = new Path(isFile, depth, p, input.substring(start+depth, end));
                if (isFile && cur.pathLength > max) {
                    max = cur.pathLength; 
                } 
                p = cur;
                
                start = i+1;
                depth = 0;
                isFile = false;
            }
        }
        
        return max;
    }
}

class Path {
    boolean isFile;
    int depth;
    Path pre;
    String name;
    int pathLength;
    
    public Path(boolean isFile, int depth,Path pre,String name) {
        this.isFile = isFile;
        this.depth = depth;
        this.pre = pre;
        this.name = name;
        if (pre == null) {
            this.pathLength = name.length();
        } else {
            this.pathLength = pre.pathLength + name.length() + 1;
        }
    }
}
