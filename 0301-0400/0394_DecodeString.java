class Solution {
    public String decodeString(String s) {  
        List<String> sstack = new ArrayList<String>();
        List<Integer> nstack = new ArrayList<Integer> ();

        int curNum = 0;
        String curStr = "";
        for (int i = 0;i<s.length();i++) {
            if (s.charAt(i) == '[') {
                nstack.add(curNum);
                sstack.add(curStr); // save str before this [
                curNum = 0;
                curStr = "";
            } else if (s.charAt(i) == ']') {
                int n = nstack.get(nstack.size()-1);
                String sStr = sstack.get(sstack.size()-1);
                curStr = sStr + curStr.repeat(n);
                nstack.remove(nstack.size()-1);  //pop 
                sstack.remove(sstack.size()-1);  //pop
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                curNum = curNum * 10 + s.charAt(i) - '0';
            } else {
                curStr = curStr + s.substring(i, i+1);
            }
        }
        return curStr;
    }
}