import java.util.PriorityQueue;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] ugly = new long[n];
        ugly[0] = 1;

        // [current_product, prime_val, index_in_ugly_array]
        PriorityQueue<long[]> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        for (int prime : primes) {
            minHeap.offer(new long[]{prime, prime, 0});
        }

        for (int i = 1; i < n; i++) {
            ugly[i] = minHeap.peek()[0];

            while (minHeap.peek()[0] == ugly[i]) {
                long[] curr = minHeap.poll();
                long prime = curr[1];
                int uglyIdx = (int) curr[2] + 1;

                minHeap.offer(new long[]{ugly[uglyIdx] * prime, prime, uglyIdx});
            }
        }

        return (int) ugly[n - 1];
    }
}