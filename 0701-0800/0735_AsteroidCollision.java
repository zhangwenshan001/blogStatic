class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> stack = new ArrayList<>();
        for (int i = 0;i<asteroids.length;i++) {
                while(true) {
                    if (stack.isEmpty() || asteroids[i] > 0) {
                        stack.add(asteroids[i]);
                        break;
                    }
                    int size = stack.size();
                    int last = stack.get(size-1);
                    if (last < 0) {
                        stack.add(asteroids[i]);
                        break;
                    } else {
                        if (last > -asteroids[i]) break;
                        if (last == -asteroids[i]) {
                            stack.remove(size-1);
                            break;
                        }
                        stack.remove(size-1);
                    }
                }
        }
        int[] ans = new int[stack.size()];
        for(int i = 0;i<ans.length;i++) {
            ans[i] = stack.get(i);
        }
        return ans;
    }
}