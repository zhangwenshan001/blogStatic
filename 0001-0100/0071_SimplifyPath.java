class Solution {
    public String simplifyPath(String path) {
        List<String> pathDicts = new ArrayList<>();

        int preSlash = 0;
        int curSlash = preSlash + 1;
        while(curSlash < path.length()) {
            StringBuilder sb = new StringBuilder();
            while(curSlash < path.length() && path.charAt(curSlash) != '/') {
                sb.append(path.charAt(curSlash));
                curSlash++;
            }
            preSlash = curSlash;
            curSlash = preSlash + 1;
            if (sb.toString().equals(".")) continue;
            if (sb.toString().equals("..")) {
                if (pathDicts.size() > 0) pathDicts.remove(pathDicts.size()-1);
            }
            else if (sb.length()> 0) pathDicts.add(sb.toString());
        }

        StringBuilder sb = new StringBuilder();
        if (pathDicts.size() == 0) {
            sb.append('/');
            return sb.toString();
        }
        for (String s : pathDicts) {
            sb.append('/');
            sb.append(s);
        }
        return sb.toString();
    }
}