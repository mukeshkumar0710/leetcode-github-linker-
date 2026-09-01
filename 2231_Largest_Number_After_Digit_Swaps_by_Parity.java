class Solution {
    public int largestInteger(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        PriorityQueue<Integer> evenMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> oddMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (char c : digits) {
            int digit = c - '0';
            if (digit % 2 == 0) {
                evenMaxHeap.offer(digit);
            } else {
                oddMaxHeap.offer(digit);
            }
        }

        int result = 0;
        for (char c : digits) {
            int digit = c - '0';
            if (digit % 2 == 0) {
                result = result * 10 + evenMaxHeap.poll();
            } else {
                result = result * 10 + oddMaxHeap.poll();
            }
        }

        return result;
    }
}