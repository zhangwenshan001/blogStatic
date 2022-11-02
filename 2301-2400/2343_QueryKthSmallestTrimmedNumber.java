class Num {
    int i;
    String val;
    Num(int i, String val) {
        this.i = i;
        this.val = val;
    }
}
class Solution {
    int[][] dp;
    int slen;
    Num[] numsArr;
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        slen = nums[0].length();

        //init dp, cache for index, i trim smallest k 
        dp = new int[slen][nums.length]; 
        for (int i = 0;i<slen;i++) {
            for (int j = 0;j<nums.length;j++) {
                dp[i][j] = -1;
            }
        }
        //init numsArr
        numsArr = new Num[nums.length];
        for(int i = 0;i<nums.length;i++) {
            numsArr[i] = new Num(i, nums[i]);
        }

        int k, trim;
        int[] res = new int[queries.length];

        for (int i = 0;i<queries.length;i++) {
            k =  queries[i][0];
            trim = queries[i][1];
            if (dp[trim-1][k-1] >=0) {
                res[i] = dp[trim-1][k-1];
                continue;
            }

            sorting(numsArr, trim);
            for (int j = 0;j<numsArr.length;j++){
                dp[trim-1][j] = numsArr[j].i;
            }
            res[i] = dp[trim-1][k-1];
        }
        return res;
    }

    private void sorting(Num[] numsArr, int trim) {
        Arrays.sort(numsArr, (a, b) -> a.val.substring(slen-trim, slen).compareTo(b.val.substring(slen-trim, slen)) == 0 ? a.i - b.i : a.val.substring(slen-trim, slen).compareTo(b.val.substring(slen-trim, slen)));
    }
}

//class Solution {
//    Map<Integer, String> map = new HashMap<>();
//    int slen;
//    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
//        int[] res = new int[queries.length];
//        slen = nums[0].length();
//        for(int i = 0;i<nums.length;i++) {
//            map.put(i, nums[i]);
//        }
//        for(int i=0;i<queries.length;i++) {
//            res[i] = smallestTrimmedNumber(queries[i]);
//        }
//
//        return res;
//    }
//
//    private int smallestTrimmedNumber(int[] query) {
//        int k = query[0];
//        int trim = query[1];
//        PriorityQueue<Map.Entry<Integer, String>> pq = new PriorityQueue<Map.Entry<Integer, String>>(
//            (a, b) -> b.getValue().substring(slen-trim,slen).compareTo(a.getValue().substring(slen-trim, slen)) == 0 ? b.getKey() - a.getKey() : b.getValue().substring(slen-trim,slen).compareTo(a.getValue().substring(slen-trim, slen))
//            ); 
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            pq.add(entry);
//            if (pq.size() > k) {
//                pq.poll(); //remove the cur max
//            }
//        }
//        return pq.poll().getKey();
//    }
//}