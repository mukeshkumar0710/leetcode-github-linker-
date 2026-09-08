class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int gift : gifts) {
            maxHeap.offer(gift);
        }
        
        for (int i = 0; i < k; i++) {
            int richest = maxHeap.poll();
            int remaining = (int) Math.sqrt(richest);
            maxHeap.offer(remaining);
        }
        
        long totalGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalGifts += maxHeap.poll();
        }
        
        return totalGifts;
    }
}