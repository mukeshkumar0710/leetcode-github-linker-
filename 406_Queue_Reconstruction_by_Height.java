class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(b[0], a[0]); // Height descending
            } else {
                return Integer.compare(a[1], b[1]); // k ascending
            }
        });

        List<int[]> queue = new ArrayList<>();

        for (int[] p : people) {
            queue.add(p[1], p);
        }

        return queue.toArray(new int[people.length][]);
    }
}