class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        List<Character> chs = new ArrayList<Character>();
        Map<Long,Integer> s = new HashMap<Long,Integer>();
        StringBuilder sb = new StringBuilder();

        if (numerator > 0 && denominator <0 || numerator <0 && denominator > 0) {
            sb.append('-');
        }
        System.out.println(sb.toString());

        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(Long.toString(num / den));
        if (num % den == 0) return sb.toString();
        num = (num % den) * 10;
        sb.append('.');

        int i = 0;
        int pos = -1;
        while(true) {
            i++;
            if (s.containsKey(num)) {
                pos = s.get(num);
                break;
            }
            s.put(num, i);
            chs.add((char)('0' + num / den));
            num = (num % den) * 10;
            if (num == 0) break;
        }

        
        // int dotPos = -1;
        for (int j = 0;j<chs.size();j++) {
            // if (chs.get(j) == '.') dotPos = j;
            if (pos >0 && pos == j+1) sb.append('(');
            sb.append(chs.get(j));    
        }
        if (pos > 0) sb.append(')');
        return sb.toString();  
    }
}