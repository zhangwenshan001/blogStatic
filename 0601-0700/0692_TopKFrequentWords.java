class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> m = new HashMap<>();
        for(int i = 0;i< words.length;i++) {
            m.put(words[i], m.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
            (a,b) -> (a.getValue() == b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()
        );
        
        for(Map.Entry<String,Integer> entry : m.entrySet()) {
            pq.offer(entry);
        }
        List<String> res = new ArrayList<>();
        for (int i =0;i<k;i++) {
            Map.Entry<String,Integer> cur = pq.poll();
            if (cur == null) break;
            res.add(cur.getKey());
        }

        return res;
    }
}