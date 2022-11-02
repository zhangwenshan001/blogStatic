class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        int curWidth = words[0].length();
        for (int i = 1;i<words.length+1;i++) {
            if (i > start && i < words.length && curWidth + words[i].length() + 1 <= maxWidth) {
                curWidth += 1 + words[i].length();
                continue;
            }

            int wordCount = i - start;
            if (wordCount == 1 || i == words.length) {
               StringBuilder sb = new StringBuilder();
               for (int j = start;j<i;j++) {
                   if (j == start) sb.append(words[j]);
                   else {
                       sb.append(' ');
                       sb.append(words[j]);
                   }
               }
               sb.append((new String(" ")).repeat(maxWidth - curWidth));
               ans.add(sb.toString());
            } else {
                int intervals = wordCount - 1;
                int evenWidth = (maxWidth - curWidth + intervals) / intervals;
                int oneMoreWidthCount = maxWidth - curWidth + intervals - evenWidth * intervals;
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (int j = start;j<i;j++) {
                    if (j == start) sb.append(words[j]);
                    else if (count < oneMoreWidthCount){
                        sb.append((new String(" ").repeat(evenWidth + 1)));
                        sb.append(words[j]);
                        count++;
                    } else {
                        sb.append((new String(" ").repeat(evenWidth)));
                        sb.append(words[j]);
                    }
                }
                ans.add(sb.toString());
            }
            if (i != words.length) {
                start = i;
                curWidth = words[i].length();
            }
        }
        return ans;
    }
}