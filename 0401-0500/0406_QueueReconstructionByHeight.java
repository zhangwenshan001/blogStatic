class Solution {
    public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0]==b[0] ? a[1] - b[1] : b[0] - a[0]; 
			}
		});


		List<int[]> result = new LinkedList<int[]>();
		for (int[] is : people) {
			result.add(is[1], is);
		}
		return result.toArray(new int[result.size()][]);
    }
}