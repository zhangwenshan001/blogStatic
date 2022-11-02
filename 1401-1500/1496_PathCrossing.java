class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        visited.add("0,0");
        int x = 0;
        int y = 0;
        for (int i = 0;i<path.length();i++) {
            if (path.charAt(i) == 'N') y++;
            if (path.charAt(i) == 'S') y--;
            if (path.charAt(i) == 'E') x++;
            if (path.charAt(i) == 'W') x--;
            if (visited.contains(x + "," + y)) return true;
            visited.add(x + "," + y);
        }
        return false;
    }
}
