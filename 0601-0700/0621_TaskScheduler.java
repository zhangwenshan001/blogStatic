class Solution {
    public int leastInterval(char[] tasks, int n) {
        Integer[] map = new Integer[26];
		Arrays.fill(map, 0);
		for (char task : tasks) {
			map[task-'A']++;
		}

		Arrays.sort(map,Collections.reverseOrder());
		
		int max = map[0];

		int sumOthers = 0;
		int countMax = 1;
		for(int i =1;i<map.length;i++) {
			if (map[i] == max) {
				sumOthers = max - 1 + sumOthers;
				countMax++;
			} else {
				sumOthers = map[i] + sumOthers;
			}
		}

		if ( (max-1) * n > sumOthers) {
			return (n+1) * (max - 1) + countMax;
		} else {
			return tasks.length;
		}
    }
}