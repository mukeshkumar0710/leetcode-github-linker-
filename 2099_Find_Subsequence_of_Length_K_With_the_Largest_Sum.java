class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        for (int i = 0; i < nums.length; i++) {
            pq.offer(new int[]{i, nums[i]});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] topK = new int[k][2];
        int idx = 0;
        while (!pq.isEmpty()) {
            topK[idx++] = pq.poll();
        }

        Arrays.sort(topK, (a, b) -> Integer.compare(a[0], b[0]));

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK[i][1];
        }

        return result;
    }
}