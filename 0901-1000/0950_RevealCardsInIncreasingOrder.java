class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> idx = new LinkedList<>();
        for (int i = 0;i<deck.length;i++) q.offer(i);
        while(q.size() > 0) {
            idx.offer(q.poll());
            if (q.size() > 0) q.offer(q.poll());
        }
        int[] ans = new int[deck.length];
        int j = 0;
        while(idx.size() > 0) {
            int k = idx.poll();
            ans[k] = deck[j++];
        }
        return ans;
    }
}